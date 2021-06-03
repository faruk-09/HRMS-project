package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

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
		if (checkAllFieldsControl(jobAdvertisement) == false) {

			return new ErrorResult("Tüm Alanlar Zorunludur.");
		} else {
			this.jobAdvertisementDao.save(jobAdvertisement);
			return new SuccessDataResult<>("İş İlanı Başarıyla Eklendi.");
		}
	}

	private boolean checkAllFieldsControl(JobAdvertisement jobAdvertisement) {

		if (jobAdvertisement.getJobDescription().isEmpty() || jobAdvertisement.getOpenPosition() == 0
				|| jobAdvertisement.getApplicationDeadline() == null) {

			return false;
		}
		return true;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobDescription(String jobDescription) {
		return new SuccessDataResult<List<JobAdvertisement>>(
				this.jobAdvertisementDao.getByJobDescription(jobDescription), "Job description listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsActive(isActive),
				"Data listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobAdvertisementDetailsByIsActive(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getJobAdvertisementDetailsByIsActive(isActive),"İlanlar Listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementOrderByApplyDateAsc(boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementOrderByApplyDateAsc(isActive));
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsWithCompanyName(String companyName,
			boolean isActive) {
		return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.getJobAdvertisementDetailsWithCompanyName(companyName, isActive),"Data listelendi");
	}

	@Override
	public Result updateIsActiveAndEmployeerId(int id, int employerId) {
		this.jobAdvertisementDao.updateIsActiveAndEmployeerId(id, employerId);
		return new SuccessResult("İlan pasife çevirildi.");
	}

}
