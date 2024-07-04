package com.airbnb.Repository;

import com.airbnb.Entity.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favourite,Long> {


}
