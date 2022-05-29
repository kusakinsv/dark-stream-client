package ru.dark.stream.config.player;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import lombok.Getter;
import ru.dark.stream.model.MusicTrack;

import javax.sound.sampled.*;
import java.io.*;
import java.net.URL;
import java.util.UUID;
@Getter
public class AudioPlayer {

    static Thread playerThread;
    static Player player;
    public static boolean isPlayed = false;
    static MusicTrack musicTrack;

    public static void playMusic(MusicTrack music) {
        musicTrack = music;
        try {
            File soundFile = downloadFile(musicTrack.getUrl());
            FileInputStream fileInputStream = new FileInputStream(soundFile);
            player = new Player(fileInputStream);

//            Audio audio = new Audio(player);
            playerThread = new Audio(player);
            playerThread.start();

            isPlayed = true;
        } catch (IOException | JavaLayerException exc) {
            exc.printStackTrace();
        }
    }

    public static void stopMusic() {
        player.close();
        playerThread.interrupt();
        isPlayed = false;
    }

    static File downloadFile(String urlAdress) throws IOException {
        File file = File.createTempFile(String.valueOf(UUID.randomUUID()), ".mp3");
        URL url = new URL(urlAdress);
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        FileOutputStream fis = new FileOutputStream(file);
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = bis.read(buffer, 0, 1024)) != -1) {
            fis.write(buffer, 0, count);
        }
        fis.close();
        bis.close();
        return file;
    }

    public static MusicTrack getMusicTrack() {
        return musicTrack;
    }
}
