package demo.pojo.job;

import java.util.List;

import demo.error.WorkerNotFoundError;

public class WorkerResponse {
	private List<Job> jobList;
	private WorkerNotFoundError error;
	public List<Job> getJobList() {
		return jobList;
	}
	public void setJobList(List<Job> jobList) {
		this.jobList = jobList;
	}
	public WorkerNotFoundError getError() {
		return error;
	}
	public void setError(WorkerNotFoundError error) {
		this.error = error;
	}


}
