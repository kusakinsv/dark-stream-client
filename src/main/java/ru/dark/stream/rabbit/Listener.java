package ru.dark.stream.rabbit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dark.stream.controller.RabbitController;
import ru.dark.stream.controller.ServiceLayer;
import ru.dark.stream.model.MusicTrack;
import ru.dark.stream.model.Separator;
import ru.dark.stream.playlist.PlaylistUpdater;
import ru.dark.stream.utils.Bundle;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@EnableRabbit
@Service
public class Listener {

    @Autowired
    RabbitController rabbitController;

    @Autowired
    ServiceLayer serviceLayer;

    ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = "dark-stream-queue-clients")
    public void processQueue1(String message) throws JsonProcessingException {
        System.out.println(("Received from queue: " + message));
        interpritate(message);
    }

    void interpritate(String message) throws JsonProcessingException {
        Object object = null;
        if (message.startsWith("PLAYLIST_")) {
            message = message.substring(9);
            object = objectMapper.readValue(message, MusicTrack[].class);
            MusicTrack[] castedObject = (MusicTrack[]) object;
            List<MusicTrack> trackList = Arrays.asList(castedObject);
            PlaylistUpdater.playlist = trackList;
            PlaylistUpdater.updated = true;
        } else if (message.startsWith("RESULT")) {
            String[] rezultmessage = message.split(Separator.SEPARATOR.toString());
            System.out.println(rezultmessage);
            UUID uuid = UUID.fromString(rezultmessage[1]);
            object = objectMapper.readValue(rezultmessage[2], MusicTrack[].class);
            Bundle bundle = ServiceLayer.bundleMap.get(uuid);
            while(ServiceLayer.bundleMap.get(uuid)==null){
                try {
                    Thread.sleep(100);
                    bundle = ServiceLayer.bundleMap.get(uuid);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            bundle.setMusicTrackList(Arrays.asList((MusicTrack[]) object));
            bundle.setReady(true);
        }
    }
}
