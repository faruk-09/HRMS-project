package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ApplicantSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.ApplicantSchool;

@RestController
@RequestMapping("/api/applicantSchool")
public class ApplicantsSchoolController {
	private ApplicantSchoolService applicantSchoolService;
	
	@Autowired
	public ApplicantsSchoolController(ApplicantSchoolService applicantSchoolService) {
		super();
		this.applicantSchoolService = applicantSchoolService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<ApplicantSchool>> getAll() {
		return this.applicantSchoolService.getAll();
	}
}
