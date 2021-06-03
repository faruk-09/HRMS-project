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
@Table(name = "job_advertisement")
public class JobAdvertisement {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "salary")
	private int salary;
	
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@Column(name = "open_position")
	private int openPosition;
	
	@Column(name = "enable")
	private boolean enable;
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne()
	@JoinColumn(name ="employer_id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name ="job_title_id")
	private JobTitle jobTitle;
	
}
