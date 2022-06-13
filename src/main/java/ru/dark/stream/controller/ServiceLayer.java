package ru.dark.stream.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dark.stream.model.MusicTrack;
import ru.dark.stream.model.Separator;
import ru.dark.stream.playlist.PlaylistUpdater;
import ru.dark.stream.utils.Bundle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
@Getter
@Setter
public class ServiceLayer {
    @Autowired
    RabbitController controller;
    ObjectMapper objectMapper = new ObjectMapper();
    public static volatile ConcurrentMap<UUID, Bundle> bundleMap = new ConcurrentHashMap<>();

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
        try {
            if (!PlaylistUpdater.updated) {
                while (!PlaylistUpdater.updated) {
                    Thread.sleep(200);
                }
            }
        }catch (Exception e){}
        PlaylistUpdater.updated = false;
    }

    public List<MusicTrack> searchInBase(String name) {
        Bundle bundle = new Bundle();
        String serializedValue = "SEARCH" + Separator.SEPARATOR + bundle.getId() + Separator.SEPARATOR + name;
        controller.sendAndRecieve(serializedValue);
        bundleMap.put(bundle.getId(), bundle);
        return bundle.getResult();
    }



}
