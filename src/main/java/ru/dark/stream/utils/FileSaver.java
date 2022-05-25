package ru.dark.stream.utils;

import ru.dark.stream.model.MusicTrack;

import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileSaver {
    public void saveAllTracksInList(List<MusicTrack> musicTrackList, int count){
        int finalCount = Math.min(musicTrackList.size(), count);
        for (int i = 0; i < count; i++) {
            int element = i;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(musicTrackList.get(element));
                    try {
                        new FileSaver().saveFileByURL(musicTrackList.get(element).getAuthor() + " - " + musicTrackList.get(element).getTrackName(), musicTrackList.get(element).getUrl());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
    }

    public void saveFileByBuffer(String name, BufferedInputStream buffer) throws IOException {
        Path absolutePath= Paths.get("").toAbsolutePath();
        String path = absolutePath.toString();
        OutputStream os = new FileOutputStream(path + String.format("/output/%s.mp3", name));
        os.write(buffer.readAllBytes());
        os.flush();
        os.close();
    }

    public void saveFileByURL(String name, String url) throws IOException {
        Path absolutePath= Paths.get("").toAbsolutePath();
        String path = absolutePath.toString();
        InputStream inputStream = new BufferedInputStream(new URL(url).openStream());
        OutputStream os = new FileOutputStream(path + String.format("/output/%s.mp3", name));
        os.write(inputStream.readAllBytes());
        os.flush();
        inputStream.close();
        os.close();
    }
}
