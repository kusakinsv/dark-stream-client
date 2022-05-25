package ru.dark.stream.resources;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.dark.stream.model.MusicTrack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//https://ru.hitmotop.com/song/47828908
public class Hitmo implements MusicResource {

    public List<MusicTrack> getMusic(String name) throws IOException {
        List<MusicTrack> foundMusicTracks = new ArrayList<>();
        try{
        String transformedName = name.replaceAll(" ", "+");
        String url = "https://ru.hitmotop.com/search?q=" + transformedName;

        Document doc = Jsoup.connect(url)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();
        Elements elementList = doc.select("div.track__info");
        for (Element element : elementList) {
            try {
                String trackName = element.child(0).child(0).text(); // название
                String trackAuthor = element.child(0).child(1).text(); //автор
                String trackDuration = element.child(1).child(0).text(); //время
                String trackUrl = element.child(1).child(1).attr("href"); //ссылка
                foundMusicTracks.add(new MusicTrack(trackName, trackAuthor, trackUrl, trackDuration, name));
            } catch (IndexOutOfBoundsException e) {
                continue;
            }
        }
        } catch (Exception e){
            e.printStackTrace();
        }
        return foundMusicTracks;
    }
}