package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.ApplicantSchool;

public interface ApplicantSchoolDao extends JpaRepository<ApplicantSchool, Integer> {
	
	List<ApplicantSchool> findByApplicantCvId(int id);
	ApplicantSchool findById(int id);
	
	@Query("From ApplicantSchool c where aplicant_cv_id=:id ORDER BY graduation_date, is_continue DESC")
	List<ApplicantSchool> getSchoolNameOrderByGraduationDateDesc(int id);
}
