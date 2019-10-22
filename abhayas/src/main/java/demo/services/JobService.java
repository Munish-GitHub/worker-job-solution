package demo.services;

import java.util.List;

import demo.pojo.job.Job;
import demo.pojo.job.WorkerResponse;

/**
 * @author Munish
 *
 */
public interface JobService {
	
	/**
	 * Method to find job for particular worker
	 * @param wid
	 * 			Worker Id
	 * @return
	 * 			Return maximum of three jobs if found after meeting criteria
	 */
	public WorkerResponse findJobsForworker(int wid);

}
