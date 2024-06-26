package com.devil.Job.job;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService{
    private  JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public Boolean addJob(Job job) {
        try {
            jobRepository.save(job);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Job getById(Long id) {
         return jobRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteById(Long id) {
        try{
            Job job = jobRepository.findById(id).orElse(null);
            if (job != null) {
                jobRepository.deleteById(id);
                return true;
            }else return false;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Boolean updateById(Long id , Job updatedJob) {
         Job job = jobRepository.findById(id).orElse(null);
         if(job!= null){

             job.setTitle(updatedJob.getTitle());
             job.setDescription(updatedJob.getDescription());
             job.setLocation(updatedJob.getLocation());
             job.setMaxSalary(updatedJob.getMaxSalary());
             job.setMinSalary(updatedJob.getMinSalary());
             job.setCompany(updatedJob.getCompany());
             jobRepository.save(job);
             return true;
         }else {
             return false;
         }
    }
}
