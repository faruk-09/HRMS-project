package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@Table(name = "employers")
@NoArgsConstructor
@Entity
@Data
public class Employer extends User {
	
	@Column(name = "company_name" )
	private String companyName;
	
	@Column(name = "web_address")
	private String webAddress;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "is_activated")
	private boolean isActivated;
	
	
	public Employer(int id, String emailAddress, String password, String companyName, String webAddress, String phoneNumber, boolean isActivated) {
		super(id, emailAddress, password);
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
		this.isActivated = isActivated;
	}
	
	public Employer(String emailAddress, String password, String companyName, String webAddress, String phoneNumber, boolean isActivated) {
		super(emailAddress, password);
		this.companyName = companyName;
		this.webAddress = webAddress;
		this.phoneNumber = phoneNumber;
		this.isActivated = isActivated;
	}

}

