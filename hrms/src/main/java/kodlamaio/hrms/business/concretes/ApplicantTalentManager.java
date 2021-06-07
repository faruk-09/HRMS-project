package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ApplicantTalentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ApplicantTalentDao;
import kodlamaio.hrms.entities.concretes.ApplicantTalent;

@Service
public class ApplicantTalentManager implements ApplicantTalentService {
	private ApplicantTalentDao aplicantTalentDao;
	
	@Autowired
	public ApplicantTalentManager(ApplicantTalentDao aplicantTalentDao) {
		super();
		this.aplicantTalentDao = aplicantTalentDao;
	}

	
	@Override
	public DataResult<List<ApplicantTalent>> getAll() {
		return new SuccessDataResult<List<ApplicantTalent>>(this.aplicantTalentDao.findAll(),"Yetenekler Listelendi");
	}


}
