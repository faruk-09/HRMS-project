package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.ApplicantLanguage;

public interface ApplicantLanguageDao extends JpaRepository<ApplicantLanguage, Integer> {

}
