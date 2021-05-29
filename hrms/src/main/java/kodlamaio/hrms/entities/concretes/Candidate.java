package kodlamaio.hrms.entities.concretes;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@EqualsAndHashCode(callSuper = false)
@Table(name = "candidates")
@NoArgsConstructor
@Entity
@Data
public class Candidate extends User {
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column (name = "identification_number")
	private String identificationNumber;
	
	@Column(name = "birth_date")
	private Date birthDay;

	public Candidate(int id, String emailAddress, String password,  String firstName, String lastName, String identificationNumber, Date birthDay) {
		super(id, emailAddress, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.identificationNumber = identificationNumber;
		this.birthDay = birthDay;
	}
	
	public Candidate(String emailAddress, String password,  String firstName, String lastName, String identificationNumber, Date birthDay) {
		super(emailAddress, password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.identificationNumber = identificationNumber;
		this.birthDay = birthDay;
	}

}
