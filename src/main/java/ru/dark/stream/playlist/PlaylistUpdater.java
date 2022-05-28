package ru.dark.stream.playlist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import ru.dark.stream.model.MusicTrack;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PlaylistUpdater {
    public static List<MusicTrack> playlist;
    public static boolean updated = false;

}
