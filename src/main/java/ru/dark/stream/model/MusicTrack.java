package ru.dark.stream.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("id")
public class MusicTrack {
    String trackName;
    String author;
    String url;
    String duration;
    String pattern;

    @Override
    public String toString() {
        return String.format(
                "-----------------------\n" +
                " %s, %s, %s \n %s", this.trackName, this.author, this.duration, this.url);
    }

    @JsonIgnore
    public String getTrackInfo(){
        return this.author + " - " + this.trackName + " " + this.duration;
    }
}
