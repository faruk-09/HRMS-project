package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobTitles")
public class JobTitlesController {
	
	@Autowired
	private JobTitleService jobTitleService;
	
	
	@GetMapping("/getAll")
	public DataResult<List<JobTitle>> getAll(){
		return this.jobTitleService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobTitle jobTitle) {
		
		return this.jobTitleService.add(jobTitle);
	}


}