package com.devil.Job.job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    Boolean addJob(Job job);
    Job getById(Long id);
    Boolean deleteById(Long id);
    Boolean updateById(Long id , Job updatedJob);


}
