package ru.dark.stream.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dark.stream.model.MusicTrack;

@Service
public class ServiceLayer {
    @Autowired
    RabbitController controller;
    ObjectMapper objectMapper = new ObjectMapper();

    public void searchMusic() {

    }

    public void addTrackToPlayList(MusicTrack musicTrack) throws JsonProcessingException {
        String serializedValue = objectMapper.writeValueAsString(musicTrack);
        serializedValue = "ADD_" + serializedValue;
        controller.response(serializedValue);
    }

    public void deleteFromPlayList(int number) {
        String serializedValue = "DEL_" + number;
        controller.response(serializedValue);
    }

    public void getPlayList(){
        String serializedValue = "PLAYLIST";
        controller.sendAndRecieve(serializedValue);
    }

    public void replaceTrack() {

    }



}
