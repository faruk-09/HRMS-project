package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getByJobDescription(String jobDescription);
	DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive);
	DataResult<List<JobAdvertisement>> getByJobAdvertisementDetailsByIsActive(boolean isActive);
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementOrderByApplyDateAsc(boolean isActive);
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsWithCompanyName(String companyName, boolean isActive);
	Result updateIsActiveAndEmployeerId(int id, int employerId);
}
