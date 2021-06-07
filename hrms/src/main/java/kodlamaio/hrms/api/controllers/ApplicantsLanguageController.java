package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ApplicantLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.ApplicantLanguage;

@RestController
@RequestMapping("/api/applicantLanguage")
public class ApplicantsLanguageController {

	private ApplicantLanguageService applicantLanguageService;

	@Autowired
	public ApplicantsLanguageController(ApplicantLanguageService applicantLanguageService) {
		super();
		this.applicantLanguageService = applicantLanguageService;
	}
	
	@GetMapping("/gettAll")
	DataResult<List<ApplicantLanguage>> getAll(){
		return this.applicantLanguageService.getAll();			
	}
	
}
