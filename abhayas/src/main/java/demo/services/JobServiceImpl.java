package demo.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demo.error.WorkerNotFoundError;
import demo.pojo.job.Job;
import demo.pojo.job.WorkerResponse;
import demo.pojo.worker.Worker;
import utility.Constants;
import utility.DistanceCalculator;

/**
 * @author Munish
 *
 */
@Service
public class JobServiceImpl implements JobService {

	//TODO Apis result can be saved in in-memory data structure, instead of calling it at every request
	private static final String API_JOBS = "http://test.swipejobs.com/api/jobs";
	private static final String API_WORKERS = "http://test.swipejobs.com/api/workers";

	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public WorkerResponse findJobsForworker(int wid) {

		WorkerResponse response = new WorkerResponse();
		try {
			Worker wrkrs[] = restTemplate.getForObject(API_WORKERS, Worker[].class);

			List<Worker> workers = Arrays.asList(wrkrs);

			Optional<Worker> optionalWrks = workers.stream().filter(worker -> worker.getUserId().equals(wid))
					.findFirst();
			Worker wrks = optionalWrks.get();
			List<Job> perfectJobs = null;
			if (isWorkerActive(wrks)) {
				Job jobsArr[] = restTemplate.getForObject(API_JOBS, Job[].class);

				List<Job> jobs = Arrays.asList(jobsArr);

				perfectJobs = jobs.stream()
						.filter(job -> job.getDriverLicenseRequired().equals(wrks.getHasDriversLicense()))
						.filter(job -> isWorkerAvailableonJobDay(job, wrks)).filter(job -> doesWorkerHvCert(job, wrks))
						.filter(job -> isValidJobDistance(job, wrks)).limit(3).collect(Collectors.toList());

				response.setJobList(perfectJobs);
				if(perfectJobs.isEmpty()){
					WorkerNotFoundError error = new WorkerNotFoundError();
					error.setCode(Constants.JOB_NOT_FOUND_CODE);
					error.setMessage(Constants.JOB_NOT_FOUND_MESSAGE);
					response.setError(error);
				}
					
				return response;
			} else {
				WorkerNotFoundError error = new WorkerNotFoundError();
				error.setCode(Constants.WORKER_NOT_ACTIVE_CODE);
				error.setMessage(Constants.WORKER_NOT_ACTIVE_MESSAGE);
				response.setError(error);
				return response;
			}

		} catch (Exception e) {
			if (e.getMessage().equals(Constants.NO_VALUE_PRESENT)) {
				WorkerNotFoundError error = new WorkerNotFoundError();
				error.setCode(Constants.NO_WORKER_PRESENT_CODE);
				error.setMessage(Constants.NO_WORKER_PRESENT_MESSAGE);
				response.setError(error);
				return response;
			}
		}
		
		return response;

	}

	/**
	 * Method to check if worker is active
	 * 
	 * @param wrks
	 * @return
	 */
	private boolean isWorkerActive(Worker wrks) {
		return wrks != null && wrks.getIsActive() ? true : false;
	}

	/**
	 * Method to check the distance from job location
	 * Third party class is used to calculate the distance
	 * 
	 * @param job
	 * @param wrks
	 * @return
	 */
	private boolean isValidJobDistance(Job job, Worker wrks) {
		long maxJobDistance = wrks.getJobSearchAddress().getMaxJobDistance();
		
		long distance = Math.round(DistanceCalculator.distance(Double.parseDouble(job.getLocation().getLatitude()),
				Double.parseDouble(job.getLocation().getLongitude()),
				Double.parseDouble(wrks.getJobSearchAddress().getLatitude()),
				Double.parseDouble(wrks.getJobSearchAddress().getLongitude()), Constants.DISTANCE_KM));
		return distance < maxJobDistance ? true : false;
	}

	/**
	 * Method to validate if worker is certified for the job
	 * @param job
	 * @param worker
	 * @return
	 */
	private boolean doesWorkerHvCert(Job job, Worker worker) {
		return worker.getCertificates().containsAll(job.getRequiredCertificates());
	}

	/**
	 * Method to check whether worker is available on given date.
	 * Compared start date with the available weekdays of worker
	 * 
	 * @param job
	 * @param worker
	 * @return
	 */
	private boolean isWorkerAvailableonJobDay(Job job, Worker worker) {
		
		int weekDay = job.getStartDate().getDayOfWeek().getValue();
		return worker.getAvailability().stream().filter(el -> el != null).anyMatch(av -> av.getDayIndex() == weekDay);
	}
}
