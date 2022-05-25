package ru.dark.stream.resources;

import ru.dark.stream.model.MusicTrack;

import java.io.IOException;
import java.util.List;

public interface MusicResource {
   List<MusicTrack> getMusic(String name) throws IOException;
}
