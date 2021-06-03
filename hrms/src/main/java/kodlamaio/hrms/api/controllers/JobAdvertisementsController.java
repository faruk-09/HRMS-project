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

	@GetMapping("/getbyjobdescription")
	DataResult<List<JobAdvertisement>> getByJobDescription(@RequestParam String jobDescription) {
		return this.jobAdvertisementService.getByJobDescription(jobDescription);
	}

	@GetMapping("/getbyisactive")
	DataResult<List<JobAdvertisement>> getByIsActive(boolean isActive) {
		return this.jobAdvertisementService.getByIsActive(isActive);
	}

	/*@GetMapping("/getjobddvertisementdetailsbyisactive")
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsByIsActive(boolean isActive) {
		return this.jobAdvertisementService.getByJobAdvertisementDetailsByIsActive(isActive);
	}*/

	@GetMapping("/getJobAdvertisementOrderByApplyDateAsc")
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementOrderByApplyDateAsc(boolean isActive) {
		return this.jobAdvertisementService.getJobAdvertisementOrderByApplyDateAsc(isActive);
	}

	@GetMapping("/getJobAdvertisementDetailsWithCompanyName")
	DataResult<List<JobAdvertisementDto>> getJobAdvertisementDetailsWithCompanyName(@RequestParam String companyName,
			@RequestParam boolean isActive) {
		return this.jobAdvertisementService.getJobAdvertisementDetailsWithCompanyName(companyName, isActive);
	}

	@PostMapping("/updateIsActiveAndEmployeerId")
	Result updateIsActiveAndEmployeerId(@RequestParam int id, @RequestParam int employerId) {
		return this.jobAdvertisementService.updateIsActiveAndEmployeerId(id, employerId);
	}
}