package ru.dark.stream.resources;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.dark.stream.model.MusicTrack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        String name = "Группа крови";
        String transformedName = name.toLowerCase().replaceAll(" ", "%20");
        String url = "https://muzofond.fm/collections/pesni/" + transformedName;
        List<MusicTrack> foundMusicTracks = new ArrayList<>();
        Document doc = Jsoup.connect(url)
//                .userAgent("Chrome/4.0.249.0 Safari/532.5")
//                .referrer("http://www.google.com")
                .get();
        Elements elementList = doc.select("ul.mainSongs").get(0).children();
        Element element = elementList.get(0);
        String trackName = element.child(1).child(0).child(1).text();;
        String trackAuthor = element.child(1).child(0).child(0).text();
        String trackDuration = element.child(2).text();
        String trackUrl = element.child(0).child(0).child(0).attr("data-url");

        System.out.printf("%s \n" +
                "%s \n" +
                "%s \n" +
                "%s \n", trackName, trackAuthor, trackDuration, trackUrl);
        System.out.println();
        System.out.println(element);
    }
}
