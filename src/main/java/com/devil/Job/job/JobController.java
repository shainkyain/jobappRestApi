package com.devil.Job.job;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private JobServiceImpl jobService;

    public JobController(JobServiceImpl jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
      return new ResponseEntity<>(jobService.getAllJobs(), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<String> addJob(@RequestBody Job job){
        jobService.addJob(job);
        return new ResponseEntity<>( "Job Created", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        return new ResponseEntity<>(jobService.getById(id) , HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        jobService.deleteById(id);
        return new ResponseEntity<>("deleted" , HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Boolean> updateJobByID(@PathVariable Long id , @RequestBody Job updatedJob){
       return new ResponseEntity<>(  jobService.updateById(id , updatedJob) , HttpStatus.OK);
    }

}

