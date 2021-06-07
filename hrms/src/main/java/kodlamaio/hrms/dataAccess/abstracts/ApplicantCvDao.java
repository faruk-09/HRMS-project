package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ApplicantCv;

public interface ApplicantCvDao extends JpaRepository<ApplicantCv, Integer>{

	List<ApplicantCv> findByCandidateId(int id);
	
}
