package com.airbnb.Repository;

import com.airbnb.Entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
