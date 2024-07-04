package com.airbnb.Repository;

import com.airbnb.Entity.Property;
import com.airbnb.Entity.PropertyUser;
import com.airbnb.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    @Query("select r from Review r where r.property=:property and r.propertyUser=:user")
    Review findReviewByUser(@Param("property") Property property,@Param("user") PropertyUser user);

    List<Review> findByPropertyUser(PropertyUser user);


}
