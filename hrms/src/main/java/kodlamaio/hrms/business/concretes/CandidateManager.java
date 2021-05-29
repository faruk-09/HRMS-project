package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.ErrorDataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Service
public class CandidateManager implements CandidateService {
	
	@Autowired
	private CandidateDao candidateDao;

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "CAndidaties are Listed.");
	}

	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessDataResult<>("Aday Eklendi ");
	}

	@Override
	public Result update(int id, Candidate candidate) {
		if(candidateDao.getOne(id)==null) {
			return new ErrorDataResult<>("Aday Bulunamadı");
		}
		candidateDao.save(candidate);
		return new SuccessDataResult<>("Adaylar Güncellendi");
		
	}

	@Override
	public Result delete(int id) {
		if(candidateDao.getOne(id)==null) {
			return new ErrorDataResult<>("Adayın Kimliği Bulunamadı");
		}
		candidateDao.deleteById(id);
		return new SuccessDataResult<>("Aday Silindi");
	}

}