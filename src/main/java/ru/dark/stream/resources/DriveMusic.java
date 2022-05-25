package ru.dark.stream.resources;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.dark.stream.model.MusicTrack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DriveMusic implements MusicResource {
    String mainUrl = "https://ru.drivemusic.me";

    @Override
    public List<MusicTrack> getMusic(String name) throws IOException {
        List<MusicTrack> foundMusicTracks = new ArrayList<>();
        try{
        String transformedName = name.toLowerCase().replaceAll(" ", "+");
        String url = "https://ru.drivemusic.me/?do=search&subaction=search&story=" + transformedName;

        Document doc = Jsoup.connect(url)
                .referrer("http://www.google.com")
                .get();
        Elements elementList = doc.select("div.music-popular__item");
//        System.out.println(elementList.size());
//        Element element1 = elementList.get(0).child(1).child(1);
//        System.out.println(element1.text());
////        String trackUrl = element.attr("data-url");
////        System.out.println(trackUrl);


        for (Element element : elementList) {
            try {
                String trackName = element.child(0).child(1).child(0).text(); // название
                String trackAuthor = element.child(0).child(1).child(1).text(); //автор
                String trackDuration = element.child(1).child(1).text(); //время
                String trackUrl = element.child(0).child(0).child(0).attr("data-url"); //ссылка
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
