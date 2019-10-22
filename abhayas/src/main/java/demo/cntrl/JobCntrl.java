package demo.cntrl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import demo.pojo.job.WorkerResponse;
import demo.services.JobService;

/**
 * @author Munish
 * 
 * Rest controller for getting jobs for given worker
 * 
 */
@RestController
public class JobCntrl {
	
	@Autowired
	JobService jobService;
	
	/**
	 * Method to fetch jobs for worker
	 * @param wid
	 * 			Method accepts path variable: worker id
	 * @return 
	 * 			Returns either matching jobs or jobs not found error
	 */
	@GetMapping("/findJobs/{wid}")
	public WorkerResponse helloworld(@PathVariable("wid") int wid){
	
		return jobService.findJobsForworker(wid);
	}
	

}
