package com.moviender.moviender.match.session;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RoomSessionManager {
    Map<String, List<List<Integer>>> roomGenreSelection = new HashMap<>();

    // odaya bir kullanıcının sectigi turleri ekler
    public void addUserGenres(String roomName, List<Integer> genres){
        if(roomGenreSelection.containsKey(roomName)){ // oda varsa oda oluşturulurken eklenen genrelere yeni kullanıcının genreleri eklenir
            System.out.println("There is already room.");
            List<List<Integer>> existUserGenres = roomGenreSelection.get(roomName);
            if(roomGenreSelection.get(roomName).size() < 2) // odadaki kisi sayisi < 2 ise genre ekle
                existUserGenres.add(genres);

        }else{ // oda yoksa odayı kuran kisinin genrelerini barındıran liste olusturulur.
            List<List<Integer>> allUsersGenres = new ArrayList<>();
            allUsersGenres.add(genres);
            roomGenreSelection.put(roomName,allUsersGenres);
        }
    }

    // oda hazir mi
    public boolean isRoomReady(String roomName){
        if(roomGenreSelection.containsKey(roomName)){
            Integer numberOfUsers = roomGenreSelection.get(roomName).size();
            if(numberOfUsers == 2)
                return true; // room is full and ready
            else
                return false; // room is not full and ready
        }
        else
            throw new RuntimeException("No room");
    }

    // turlerin tek bir listede toplanması ve getMoviesFromGenres icin hazirlanması
    public List<Integer> getMergedGenres(String roomName){
        if(roomGenreSelection.containsKey(roomName)){
            List<Integer> mergedGenres = new ArrayList<>();
            for(List<Integer> ids: roomGenreSelection.get(roomName))
                mergedGenres.addAll(ids);
            return mergedGenres;
        }
        else
            throw new RuntimeException("No room found!");
    }
}
