package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.ApplicantSchool;

public interface ApplicantSchoolService {
	
	DataResult<List<ApplicantSchool>> getAll();
	DataResult<List<ApplicantSchool>> findByApplicantCvId(int id);
	DataResult<List<ApplicantSchool>>   getSchoolNameOrderByGraduationDateDesc(int id);
	
}
