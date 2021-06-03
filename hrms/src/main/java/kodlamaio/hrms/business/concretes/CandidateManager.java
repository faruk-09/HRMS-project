package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.business.BusinessRules;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorDataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.NoArgsConstructor;


@Service
public class CandidateManager implements CandidateService {
	
	@Autowired
	private CandidateDao candidateDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "CAndidaties are Listed.");
	}
	
	

	@Override
	public Result add(Candidate candidate) {
		Result result = BusinessRules.run
				(checkIfIdentityNumberExist(candidate.getIdentificationNumber()),
				checkIfEmailExist(candidate.getEmail()),checkEmailDomain(candidate.getEmail()));
		if(result.isSuccess()) {
			
			this.candidateDao.save(candidate);
			return new SuccessResult("Aday Eklendi ");
		}
		return new ErrorResult(result.getMessage());
	}
	
	private Result checkIfEmailExist(String email) {

        if(!userDao.existsByEmail(email)) {
            return new SuccessResult();
        }
        return new ErrorResult("this email is being used");
    }
	
	private Result checkIfIdentityNumberExist(String identityNumber) {
        if(!candidateDao.existsByIdentificationNumber(identityNumber))
        {
            return new SuccessResult();
        }
        return new ErrorResult("this id is used.");
    }
	
	private Result checkEmailDomain(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()) {
            return new SuccessResult();
        }
        return new ErrorResult("must be in e-mail format");
    }



}