package com.airbnb.Controller;

import com.airbnb.Entity.Favourite;
import com.airbnb.Entity.PropertyUser;
import com.airbnb.Repository.FavoriteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/favourite")
public class FavouriteController {

    private FavoriteRepository favoriteRepository;

    public FavouriteController(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }
    @PostMapping
    public ResponseEntity<Favourite>addFavourite(
            @RequestBody Favourite favourite,
            @AuthenticationPrincipal PropertyUser user
            ){
        favourite.setPropertyUser(user);
        Favourite savedFavourite = favoriteRepository.save(favourite);
        return new ResponseEntity<>(savedFavourite, HttpStatus.CREATED);

    }

}
