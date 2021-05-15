package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "job_seekers")
public class JobSeekers {
	@Id
	@GeneratedValue
	@Column(name ="job_seeker_id")
	private int jobSeekersId;
	
	@Column(name ="first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "national_id")
	private String nationalId;
	
	@Column(name= "birth_day")
	private Date birthDay;
	
	public JobSeekers() {
		
	}
	
	public JobSeekers(int jobSeekersId, String firstName, String lastName, String nationalId, Date birthDay) {
		super();
		this.jobSeekersId = jobSeekersId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.birthDay = birthDay;
	}


	public int getJobSeekersId() {
		return jobSeekersId;
	}


	public void setJobSeekersId(int jobSeekersId) {
		this.jobSeekersId = jobSeekersId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getNationalId() {
		return nationalId;
	}


	public void setNationalId(String nationalId) {
		this.nationalId = nationalId;
	}


	public Date getBirthDay() {
		return birthDay;
	}


	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	
	
}	
