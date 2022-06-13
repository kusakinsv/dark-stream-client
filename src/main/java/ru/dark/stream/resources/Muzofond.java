//package ru.dark.stream.resources;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import ru.dark.stream.model.MusicTrack;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
////https://muzofond.fm/
//public class Muzofond implements MusicResource {
//    public List<MusicTrack> getMusic(String name) throws IOException {
//        List<MusicTrack> foundMusicTracks = new ArrayList<>();
//        try {
//            String transformedName = name.toLowerCase().replaceAll(" ", "%20");
//            String url = "https://muzofond.fm/collections/pesni/" + transformedName;
//
////            try {
//            Document doc = Jsoup.connect(url)
////                .userAgent("Chrome/4.0.249.0 Safari/532.5")
////                .referrer("http://www.google.com")
//                        .get();
//
////            } catch (Exception e) {return foundMusicTracks;}
//            Elements elementList = doc.select("ul.mainSongs").get(0).children();
//            for (Element element : elementList) {
//                try {
//                    String trackName = element.child(1).child(0).child(1).text();
//                    String trackAuthor = element.child(1).child(0).child(0).text();
//                    String trackDuration = element.child(2).text();
//                    String trackUrl = element.child(0).child(0).child(0).attr("data-url");
//                    foundMusicTracks.add(new MusicTrack(trackName, trackAuthor, trackUrl, trackDuration, name));
//                } catch (IndexOutOfBoundsException e) {
//                    continue;
//                }
//            }
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//        return foundMusicTracks;
//    }
//}
