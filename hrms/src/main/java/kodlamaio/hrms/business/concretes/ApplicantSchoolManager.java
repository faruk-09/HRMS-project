package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ApplicantSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ApplicantSchoolDao;
import kodlamaio.hrms.entities.concretes.ApplicantSchool;

@Service
public class ApplicantSchoolManager implements ApplicantSchoolService {
	private ApplicantSchoolDao applicantSchoolDao;
	
	@Autowired
	public ApplicantSchoolManager(ApplicantSchoolDao applicantSchoolDao) {
		super();
		this.applicantSchoolDao = applicantSchoolDao;
	}

	@Override
	public DataResult<List<ApplicantSchool>> getAll() {
		return new SuccessDataResult<List<ApplicantSchool>>(this.applicantSchoolDao.findAll(),"Adayın Okulları Listelendi");
	}

	@Override
	public DataResult<List<ApplicantSchool>> findByApplicantCvId(int id) {
		return new SuccessDataResult<List<ApplicantSchool>>(this.applicantSchoolDao.findByApplicantCvId(id));
	}

	@Override
	public DataResult<List<ApplicantSchool>> getSchoolNameOrderByGraduationDateDesc(int id) {
		return new SuccessDataResult<List<ApplicantSchool>>
		(this.applicantSchoolDao.getSchoolNameOrderByGraduationDateDesc(id), "Okul Adı ve mezuniyet tarihleri listelendi");
	}

}
