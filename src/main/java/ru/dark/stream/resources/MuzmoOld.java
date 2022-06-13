package ru.dark.stream.resources;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.dark.stream.model.MusicTrack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//https://rus.muzmo.cc/search?q=%D0%A2%D0%B2%D0%BE%D0%B8+%D0%B3%D0%BB%D0%B0%D0%B7%D0%B0
public class MuzmoOld implements MusicResource {
    String mainUrl = "https://rus.muzmo.cc";

    public List<MusicTrack> getMusic(String name) throws IOException {
        List<MusicTrack> foundMusicTracks = new ArrayList<>();
        try{
//    public void getMusic(String name) throws IOException {
        String transformedName = name.toLowerCase().replaceAll(" ", "+");
        String url = "https://rus.muzmo.cc/search?q=" + transformedName;

        Document doc = Jsoup.connect(url)
                .referrer("http://www.google.com")
                .get();
        Elements elementList = doc.select("div.item-song").addClass("div.ajax-item");

        for (Element element : elementList) {
            try {
                String[] data = element.child(0).child(0).child(0).child(0).attr("data-title").split(" - ");
                String trackAuthor = data[0];; //автор
                String trackName = data[1]; // название
                String trackDuration = element.child(0).child(0).child(0).child(3).child(0).child(0).text(); //время
                String trackUrl = mainUrl + element.child(0).child(0).child(0).child(0).attr("data-file"); //ссылка
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
