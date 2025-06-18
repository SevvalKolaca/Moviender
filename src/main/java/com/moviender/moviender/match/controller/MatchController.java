package com.moviender.moviender.match.controller;

import com.moviender.moviender.match.service.MatchService;
import com.moviender.moviender.match.session.RoomSessionManager;
import com.moviender.moviender.match.session.UserSessionData;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/v1/match")
public class MatchController {

    private final UserSessionData userSessionData;
    private final RoomSessionManager roomSessionManager;
    private final MatchService matchService;

    public MatchController(UserSessionData userSessionData, RoomSessionManager roomSessionManager, MatchService matchService){
        this.userSessionData=userSessionData;
        this.roomSessionManager = roomSessionManager;
        this.matchService = matchService;
    }

    @PostMapping("/select-genre")
    public ResponseEntity<String> selectGenres(@RequestParam(name = "genres") List<Integer> genreIds){
        if(genreIds == null || genreIds.isEmpty()){
            return ResponseEntity.badRequest().body("Genre list is empty!!");
        }

        userSessionData.setSelectedGenreIds(genreIds);
        log.info("Selected genres: {}", matchService.getGenreNamesByMovieService(genreIds));
        return ResponseEntity.ok("Genres are selected successfully!!");
    }

    @PostMapping("/join-room")
    public ResponseEntity<String> joinRoom(@RequestParam String roomName){
        if(userSessionData.getSelectedGenreIds().isEmpty()){
            return ResponseEntity.badRequest().body("Genre not selected!!!");
        }else{
            roomSessionManager.addUserGenres(roomName, userSessionData.getSelectedGenreIds());
            return ResponseEntity.ok("Joining room...");
        }
    }

    
}
