package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.ApplicantTalent;
import kodlamaio.hrms.business.abstracts.ApplicantTalentService;

@RestController
@RequestMapping("/api/applicantTalent")
public class ApplicantsTalentController {
	private ApplicantTalentService applicantTalentService;
	
	@Autowired
	public ApplicantsTalentController(ApplicantTalentService applicantTalentService) {
		super();
		this.applicantTalentService = applicantTalentService;
	}

	@GetMapping("/getAll")
	DataResult<List<ApplicantTalent>> getAll() {
		return this.applicantTalentService.getAll();
	}
	
}
