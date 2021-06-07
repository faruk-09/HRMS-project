package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;



@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;

	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		/*if (checkAllFieldsControl(jobAdvertisement) == false) {

			return new ErrorResult("Tüm Alanlar Zorunludur.");
		} else {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessDataResult<>("İş İlanı Başarıyla Eklendi.");
		}*/
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessDataResult<>("İş İlanı Başarıyla Eklendi.");
	}

	private boolean checkAllFieldsControl(JobAdvertisement jobAdvertisement) {

		if (jobAdvertisement.getJobDescription().isEmpty() || jobAdvertisement.getOpenPosition() == 0
				|| jobAdvertisement.getApplicationDeadLine() == null) {

			return false;
		}
		return true;
	}
	

	@Override
	public DataResult<List<JobAdvertisement>> findAllByEnableTrueOrderByApplicationDeadLineDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAllByEnableTrueOrderByApplicationDeadLineDesc(), "Listelendi.");
	}

}
