package ru.dark.stream.utils;

import ru.dark.stream.model.MusicTrack;
import ru.dark.stream.resources.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InternetMusicSercher {

    public List<MusicTrack> searchMusic(String title) throws IOException {
        title = title.toLowerCase();
        List<MusicTrack> fulltrackList = new ArrayList<>();
        MusicResource resource = new Hitmo();
        fulltrackList.addAll(resource.getMusic(title));
        resource = new MuzmoOld();
        fulltrackList.addAll(resource.getMusic(title));
        resource = new DriveMusic();
        fulltrackList.addAll(resource.getMusic(title));
//        resource = new Muzofond();
//        fulltrackList.addAll(resource.getMusic(title));
        return fulltrackList;
    }
}
