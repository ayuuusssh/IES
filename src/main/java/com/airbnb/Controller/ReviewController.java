package com.airbnb.Controller;

import com.airbnb.Entity.Property;
import com.airbnb.Entity.PropertyUser;
import com.airbnb.Entity.Review;
import com.airbnb.Repository.PropertyRepository;
import com.airbnb.Repository.ReviewRepository;
import com.airbnb.dto.ReviewDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/review")
public class ReviewController {
    private PropertyRepository propertyRepository;

    private ReviewRepository reviewRepository;

    public ReviewController(PropertyRepository propertyRepository, ReviewRepository reviewRepository) {
        this.propertyRepository = propertyRepository;
        this.reviewRepository = reviewRepository;
    }
@PostMapping("/addReview/{propertyId}")
    public ResponseEntity<String>addReview(
            @PathVariable long propertyId,
            @RequestBody Review review,
            @AuthenticationPrincipal PropertyUser user){

    Optional<Property> opProperty = propertyRepository.findById(propertyId);
        Property property = opProperty.get();

    Review r = reviewRepository.findReviewByUser(property, user);
    if(r!=null){
        return new ResponseEntity<>("You have already a review for the project",HttpStatus.BAD_REQUEST);
    }

    review.setProperty(property);
        review.setPropertyUser(user);
        reviewRepository.save(review);
        return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);


    }
    @GetMapping("/userReviews")
    public ResponseEntity<List<Review>> getUserReview(@AuthenticationPrincipal PropertyUser user){
        List<Review> reviews = reviewRepository.findByPropertyUser(user);
        return new ResponseEntity<>(reviews,HttpStatus.OK);
    }
}
