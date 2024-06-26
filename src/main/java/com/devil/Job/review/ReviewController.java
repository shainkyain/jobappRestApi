package com.devil.Job.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {
    private final ReviewServiceImpl reviewService;

    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> allReviewOfCompany(@PathVariable Long companyId){
       return new ResponseEntity<>( reviewService.getAllReview(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@PathVariable Long companyId ,
                                            @RequestBody Review review){
        reviewService.addReview(companyId , review);
        return  new ResponseEntity<>("review Added" , HttpStatus.CREATED);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> findReviewById(@PathVariable Long companyId,
                                                 @PathVariable Long reviewId){
       return new ResponseEntity<>(reviewService.getReviewByID(companyId , reviewId), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Boolean> updateReview(@PathVariable Long companyId,
                                                @PathVariable Long reviewId,
                                                @RequestBody Review updatedReview){
         reviewService.updateReview(companyId,reviewId,updatedReview);
         return new ResponseEntity<>(true , HttpStatus.OK);
    }
    @DeleteMapping("{reviewId}")
    public ResponseEntity<Boolean> deleteReview(@PathVariable Long companyId,
                                                @PathVariable Long reviewId){
        reviewService.deleteReview(companyId,reviewId);
        return new ResponseEntity<>(true , HttpStatus.OK);
    }


}
