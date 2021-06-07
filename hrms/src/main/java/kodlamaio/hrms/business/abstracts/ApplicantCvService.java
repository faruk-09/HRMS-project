package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ApplicantCv;

public interface ApplicantCvService {
	
	DataResult<List<ApplicantCv>> getAll();
	Result add(ApplicantCv applicantCv);
	DataResult<List<ApplicantCv>> findByCandidatetId(int id);
}
