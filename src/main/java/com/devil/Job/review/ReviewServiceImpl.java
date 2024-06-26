package com.devil.Job.review;

import com.devil.Job.company.Company;
import com.devil.Job.company.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final CompanyRepository companyRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             CompanyRepository companyRepository) {
        this.reviewRepository = reviewRepository;
        this.companyRepository = companyRepository;
    }


    @Override
    public List<Review> getAllReview(Long companyId) {
       return reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyRepository.findById(companyId).orElse(null);
        if(company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else
            return false;

    }

    @Override
    public Review getReviewByID(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        if(reviews != null){
            return reviews.stream()
                    .filter(review -> review.getId().equals(reviewId))
                    .findFirst()
                    .orElse(null);
        }else return null;
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

             Review originalReview = reviews.stream()
                                        .filter(review1 -> review1.getId().equals(reviewId))
                                        .findFirst()
                                        .orElse(null);

             if(originalReview !=null){
                 originalReview.setTitle(updatedReview.getTitle());
                 originalReview.setDescription(updatedReview.getDescription());
                 originalReview.setRating(updatedReview.getRating());
                 reviewRepository.save(originalReview);
                return  true;
             }else
                return false;

    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);

        Review originalReview = reviews.stream()
                .filter(review1 -> review1.getId().equals(reviewId))
                .findFirst()
                .orElse(null);

        originalReview.setCompany(null);
     try {
         if (originalReview != null){
             reviewRepository.delete(originalReview);
         return true;
     }
         else return false;
     }catch (Exception e){
         return false;
     }

    }
}
