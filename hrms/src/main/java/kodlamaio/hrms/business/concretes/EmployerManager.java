package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	@Autowired
	private EmployerDao employerDao;

	@Autowired
	private UserDao userDao;

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İşveren Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		Result result = BusinessRules.run(checkEmailDomain(employer), checkIfEmailExist(employer.getEmail()));
		if (result.isSuccess()) {

			this.employerDao.save(employer);
			return new SuccessResult("İşveren Eklendi ");
		}
		return new ErrorResult(result.getMessage());
	}

	private Result checkIfEmailExist(String email) {

		if (!userDao.existsByEmail(email)) {
			return new SuccessResult();
		}
		return new ErrorResult("this email is being used");
	}

	private Result checkEmailDomain(Employer employers) {
		try {
			String webSiteName[] = employers.getWebAddress().split("\\.");
			String regex = "^(.+)@" + webSiteName[1] + "(.+)$";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(employers.getEmail());
			if (matcher.matches()) {
				return new SuccessResult();
			}
		} catch (Exception e) {
			String domain = employers.getWebAddress();
			if (domain.contains("www.")) {
				domain = domain.substring(4);
			}
			if (employers.getEmail().contains("@" + domain)) {
				return new SuccessResult();
			}
		}
		return new ErrorResult("Email and web adress domains must be same.");
	}

}