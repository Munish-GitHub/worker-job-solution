# worker-job-solution
How to setup on machine:
1. clone the repo using below command:
git clone https://github.com/Munish-GitHub/worker-job-solution.git
2. Import project in eclipse using "existing maven project" and select the folder where you cloned the project
3. Select the JDK 1.8 in eclipse to run the application
4. Build the project using maven
5. Look for class AbhayasApplication in demo package.
6. Run using simple java application.
7. Hit the below url to find job for worker:
  http://localhost:8080/findJobs/id 
  Example: http://localhost:8080/findJobs/30


The Job worker solution is build on Java 1.8 and with Spring boot framework. 

Matching patterns: Java 1.8 streams are being used to find the matching jobs for a given worker.
  patterns: IsWorkerActive (chehck if worker is active or not)
            isValidJobDistance (Check the distance)
            doesWorkerHvCert (certificates)
            isWorkerAvailableonJobDay (check if user is working on that day equal to start day of job)

Third party: 
One third party utility is being used to calculate the location named DistanceCalculator in utility folder to calculate longitude and latitude.

Error handling in code:
Below condition are handled with given codes:
public static final int JOB_NOT_FOUND_CODE = 1400;
public static final String JOB_NOT_FOUND_MESSAGE = "Job not found";
	
public static final int WORKER_NOT_ACTIVE_CODE = 1500;
public static final String WORKER_NOT_ACTIVE_MESSAGE = "Worker is not active";
	
public static final int NO_WORKER_PRESENT_CODE = 1600;
public static final String NO_WORKER_PRESENT_MESSAGE = "No worker present with given worker id";

Enhancement and improvement:
Code can be improved by handling more exceptions. 
In code, the apis (worker and job) are getting called at every request. Apis result can be stored and used in memory.
