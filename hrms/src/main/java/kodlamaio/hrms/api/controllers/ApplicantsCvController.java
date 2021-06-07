package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ApplicantCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.ApplicantCv;

@RestController
@RequestMapping("/api/applicantCv")
public class ApplicantsCvController {
	private ApplicantCvService applicantCvService;
	
	@Autowired
	public ApplicantsCvController(ApplicantCvService applicantCvService) {
		super();
		this.applicantCvService = applicantCvService;
	}

	@GetMapping("/getAll")
	DataResult<List<ApplicantCv>> getAll() {
		return this.applicantCvService.getAll();
	}

	@GetMapping("/listAll")
	DataResult<List<ApplicantCv>> listAll() {
		return this.applicantCvService.getAll();
	}

	@PostMapping("/add")
	Result add(@RequestBody ApplicantCv applicantCv) {
		return this.applicantCvService.add(applicantCv);
	}

}
