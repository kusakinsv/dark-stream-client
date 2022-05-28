package ru.dark.stream.rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dark.stream.controller.RabbitController;
import ru.dark.stream.model.MusicTrack;
import ru.dark.stream.playlist.PlaylistUpdater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EnableRabbit
@Service
public class Listener {

    @Autowired
    RabbitController rabbitController;

    @RabbitListener(queues = "dark-stream-queue-clients")
    public void processQueue1(String message) throws JsonProcessingException {
        System.out.println(("Received from queue: " + message));
        interpritate(message);
    }

    void interpritate(String message) throws JsonProcessingException {
        Object object = null;
        if (message.startsWith("PLAYLIST_")) {
            message = message.substring(9);
            ObjectMapper objectMapper = new ObjectMapper();
            object = objectMapper.readValue(message, MusicTrack[].class);
            MusicTrack[] castedObject = (MusicTrack[]) object;
            List<MusicTrack> trackList = Arrays.asList(castedObject);
            PlaylistUpdater.playlist = trackList;
            PlaylistUpdater.updated = true;
        }
    }}
