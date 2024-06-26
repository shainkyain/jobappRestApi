package com.devil.Job.company;

import com.devil.Job.job.Job;
import com.devil.Job.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "company")
    @JsonIgnore
    private List<Job> job;

    @OneToMany(mappedBy = "company")
    private List<Review> reviews;

    public Company(){
        super();
    }
    public Company(Long id, String title, String description, List<Job> job) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.job = job;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJob() {
        return job;
    }

    public void setJob(List<Job> job) {
        this.job = job;
    }
}
