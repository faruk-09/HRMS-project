package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@GetMapping("/getall")
	DataResult<List<JobAdvertisement>> getAll() {
		return this.jobAdvertisementService.getAll();
	}

	@PostMapping("/add")
	Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/listing")
	DataResult<List<JobAdvertisement>> getAll2() {
		return this.jobAdvertisementService.findAllByEnableTrueOrderByApplicationDeadLineDesc();
	}
	
	
	
}