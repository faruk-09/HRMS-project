package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class EmployerManager implements EmployerService{
	
	@Autowired
	private EmployerDao employerDao;

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "İşveren Listelendi");
	}

	@Override
	public Result add(Employer employer) {
		this.employerDao.save(employer);
		return new SuccessDataResult<>("İşveren Eklendi ");
	}

	@Override
	public Result update(int id, Employer employer) {
		if(employerDao.getOne(id)==null) {
			return new ErrorDataResult<>("İşveren Bulunamadı");
		}
		employerDao.save(employer);
		return new SuccessDataResult<>("İşveren Güncellendi");
		
	}

	@Override
	public Result delete(int id) {
		if(employerDao.getOne(id)==null) {
			return new ErrorDataResult<>("İşveren kimliği boş");
		}
		employerDao.deleteById(id);
		return new SuccessDataResult<>("İşveren Silindi");
	}

}