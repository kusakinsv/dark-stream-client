package ru.dark.stream.config.player;

import javazoom.jl.player.Player;
import lombok.SneakyThrows;

import javax.sound.sampled.Clip;

public class Audio implements Runnable {
    Player player;

    @SneakyThrows
    @Override
    public void run() {
        player.play();
        player.close(); //Закрываем
    }

    public Audio(Player player) {
        this.player = player;
    }
}
