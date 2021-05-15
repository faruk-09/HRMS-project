package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "job_position")
public class JobPosition {
	@Id
	@GeneratedValue
	@Column(name = "job_position_id")
	private int jobPositionId;
	
	@Column(name = "position_name")
	private String positionName;
	
	public JobPosition() {
		
	}
	
	public JobPosition(int jobPositionId, String positionName) {
		super();
		this.jobPositionId = jobPositionId;
		this.positionName = positionName;
	}

	public int getJobPositionId() {
		return jobPositionId;
	}

	public void setJobPositionId(int jobPositionId) {
		this.jobPositionId = jobPositionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	
}
