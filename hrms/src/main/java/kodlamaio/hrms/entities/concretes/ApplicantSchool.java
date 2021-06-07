package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "applicant_school")
public class ApplicantSchool {
	
	@Id
	@GeneratedValue ( strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "entry_date")
	private Date entryDate;
	
	@Column(name = "graduation_date")
	private Date graduationDate;
	
	@Column(name = "department")
	private String department;
	
	@ManyToOne(targetEntity=ApplicantCv.class)
	@JoinColumn(name="applicant_cv_id")
    private ApplicantCv applicantCv;
	
	

	
}
