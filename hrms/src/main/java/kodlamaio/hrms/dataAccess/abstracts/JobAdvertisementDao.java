package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
	List<JobAdvertisement> getByJobDescription(String jobDescription);
	List<JobAdvertisement> getByIsActive(boolean isActive);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"+
	"(e.id , jt.jobDescription , ja.salary , ja.applicationDeadline, jt.openPosition , ja.enable"+
	"From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.jobTitle jp Where ja.isActive=?1")
	List<JobAdvertisement> getJobAdvertisementDetailsByIsActive(boolean isActive);
	
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"+
	"(e.id , jt.jobDescription , ja.salary , ja.applicationDeadline, jt.openPosition , ja.enable"+
	"From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.jobTitle jp Where ja.isActive=?1 Order By ja.applyDate ASC"	)
	List<JobAdvertisementDto> getJobAdvertisementOrderByApplyDateAsc(boolean isActive);
	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"+
	"(e.id , jt.jobDescription , ja.salary , ja.applicationDeadline, jt.openPosition , ja.enable"+
	"From JobAdvertisement ja Inner Join ja.employer e Inner Join ja.jobTitle jp Where ja.isActive=?1"+
	"Where e.companyName=:companyName and ja.isActive=:isActive")
	List<JobAdvertisementDto> getJobAdvertisementDetailsWithCompanyName(String companyName, boolean isActive);
	
	@Transactional
	@Modifying
	@Query("UPDATE JobAdvertisement j SET j.isActive = false WHERE j.id =:id AND j.id=:employerId")
	void updateIsActiveAndEmployeerId(int id, int employerId);
}
