package ru.dark.stream.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.dark.stream.model.MusicTrack;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Bundle {
    private UUID id = UUID.randomUUID();
    private List<MusicTrack> musicTrackList;
    private boolean isReady = false;


    public List<MusicTrack> getResult()  {
        while(!isReady){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return musicTrackList;
    }

}
