package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "applicant_language")
public class ApplicantLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = ApplicantCv.class)
	@JoinColumn(name = "applicant_cv_id")
	private ApplicantCv applicantCv;

	@ManyToOne(targetEntity = Language.class)
	@JoinColumn(name = "language_id")
	private Language language;

}
