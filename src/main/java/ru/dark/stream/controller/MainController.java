package ru.dark.stream.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dark.stream.config.player.AudioPlayer;
import ru.dark.stream.model.MusicTrack;
import ru.dark.stream.playlist.PlaylistUpdater;
import ru.dark.stream.utils.InternetMusicSercher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class MainController {

    private static int amountInSearchList = 100;
    @Autowired
    Configuration configuration;
    @Autowired
    ServiceLayer serviceLayer;
    private static HttpHeaders responseHeaders = new HttpHeaders();

    static List<MusicTrack> trackList = new ArrayList<>();
    static List<MusicTrack> playlist = new ArrayList<>();
    public static boolean updated = false;


    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "index";
    }

    @PostMapping("search")
    public String searchTrack(Model model, @RequestParam(value = "trackname", required = false) String trackname) throws IOException, TemplateException {
        trackList = new ArrayList<>();
//        if (trackList.size() > 0) trackList.clear();
        InternetMusicSercher internetMusicSercher = new InternetMusicSercher();
        trackList.addAll(internetMusicSercher.searchMusic(trackname));
        if (trackList.size() == 0) {
            model.addAttribute("playlist", trackList);
            model.addAttribute("mainPageMessage", "Не найдено");
            return "search";
        } else {
            List<MusicTrack> sublist = new ArrayList<>();
            if (amountInSearchList > trackList.size()) amountInSearchList = trackList.size();
            if (trackList.size() > 1) {
                for (int i = 0; i < amountInSearchList; i++) {
                    sublist.add(trackList.get(i));
                }
            }
            trackList = sublist;
            String mainPageMessage = "Найденные треки: ";
            model.addAttribute("playlist", trackList);
            model.addAttribute("mainPageMessage", mainPageMessage);
            if (trackname == null) {
                return "no parameters";
            }
            return "search";
        }
    }

    @GetMapping("get_playlist")
    public String getPlayList(Model model) throws JsonProcessingException {
        serviceLayer.getPlayList();
        trackList = PlaylistUpdater.playlist;
        model.addAttribute("playlist", trackList);
        model.addAttribute("mainPageMessage", "ВАШ ПЛЕЙЛИСТ");
        return "playlist";
    }

    @GetMapping("add-{number}")
    public String addTrackToPlayList(Model model, @PathVariable int number) throws JsonProcessingException {
        MusicTrack musicTrack;
        musicTrack = trackList.get(number);
        serviceLayer.addTrackToPlayList(musicTrack);
        String mainPageMessage = "Музыкальный трек № " + (number + 1) + " " + musicTrack.getTrackInfo() + " Добавлен в плейлист";
        model.addAttribute("playlist", trackList);
        model.addAttribute("mainPageMessage", mainPageMessage);
        return "search";
    }

    @GetMapping("delete-{number}")
    public ResponseEntity deleteFromPlayListByNumber(@PathVariable int number) {
        if (trackList.size() > 0 && number > 0) {
            serviceLayer.deleteFromPlayList(number);
        }
        String message = "Музыкальный трек c номером " + number + " удален из плейлиста";
        return new ResponseEntity<>(message, responseHeaders, HttpStatus.OK);
    }

    @GetMapping("delete_from_playlist-{number}")
    public String deleteFromPlayList(Model model, @PathVariable int number) {
        if (trackList.size() > 0) {
            number = number+1;
            serviceLayer.deleteFromPlayList(number);
        }

        serviceLayer.getPlayList();
        trackList = PlaylistUpdater.playlist;

        String mainPageMessage = "Музыкальный трек c номером " + number + " удален из плейлиста";
        model.addAttribute("playlist", trackList);
        model.addAttribute("mainPageMessage", mainPageMessage);
        return "playlist";
    }

    @GetMapping("/play-{number}")
    public String play(Model model, @PathVariable int number) {
        String mainPageMessage = "Проигрывается: № " + (number + 1) + " " + trackList.get(number).getTrackInfo();
        model.addAttribute("playlist", trackList);
        model.addAttribute("mainPageMessage", mainPageMessage);
        if (AudioPlayer.isPlayed) AudioPlayer.stopMusic();
        AudioPlayer.playMusic(trackList.get(number));
        return "search";
    }

    @GetMapping("/playlist_play-{number}")
    public String playlistPlay(Model model, @PathVariable int number) {
        String mainPageMessage = "Проигрывается: № " + (number + 1) + " " + trackList.get(number).getTrackInfo();
        model.addAttribute("playlist", trackList);
        model.addAttribute("mainPageMessage", mainPageMessage);
        if (AudioPlayer.isPlayed) AudioPlayer.stopMusic();
        AudioPlayer.playMusic(trackList.get(number));
        return "playlist";
    }

    @GetMapping("/playlist_stop")
    public String playlistStop(Model model) {
        String mainPageMessage = "Остановлено: " + AudioPlayer.getMusicTrack().getTrackInfo();
        model.addAttribute("playlist", trackList);
        model.addAttribute("mainPageMessage", mainPageMessage);
        AudioPlayer.stopMusic();
        return "playlist";
    }


    @GetMapping("/stop")
    public String stop(Model model) {
        String mainPageMessage = "Остановлено: " + AudioPlayer.getMusicTrack().getTrackInfo();
        model.addAttribute("playlist", trackList);
        model.addAttribute("mainPageMessage", mainPageMessage);
        AudioPlayer.stopMusic();
        return "search";
    }

    @PostMapping("hello")
    public void hello(@PathVariable int number) {
        System.out.println("HELLO");
    }
}
