package com.moviender.moviender.match.controller;

import com.moviender.moviender.match.session.UserSessionData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/match")
public class MatchController {

    private final UserSessionData userSessionData;

    public MatchController(UserSessionData userSessionData){
        this.userSessionData=userSessionData;
    }

    @PostMapping("/select-genres")
    public ResponseEntity<String> selectGenres(@RequestParam List<Integer> genres){
        if(genres == null || genres.isEmpty()){
            return ResponseEntity.badRequest().body("Genre list is empty!!");
        }

        userSessionData.setSelectedGenreIds(genres);
        return ResponseEntity.ok("Genres are selected successfully!!");
    }
}
