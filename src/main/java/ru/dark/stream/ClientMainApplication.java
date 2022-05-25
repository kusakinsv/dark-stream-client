package ru.dark.stream;

import freemarker.template.TemplateException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.dark.stream.model.MusicTrack;
import ru.dark.stream.utils.InternetMusicSercher;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class ClientMainApplication {

    public static void main(String[] args) throws URISyntaxException, IOException, TimeoutException, TemplateException {
        ApplicationContext context = SpringApplication.run(ClientMainApplication.class, args);
//        String seacherdTrack = "NЮ - Никто";
//
//        List<MusicTrack> fulltrackList = new InternetMusicSercher().searchMusic(seacherdTrack);
//        int counter = 0;
//        for (MusicTrack x : fulltrackList) {
//            System.out.println(counter + "" + x.toString());
//            counter++;
//        }
//        System.out.println("Выполнено: найдено " + fulltrackList.size());
//        int numberToAdd = 1;

//        ServiceLayer serviceLayer = context.getBean(ServiceLayer.class);
//        serviceLayer.addTrackToPlayList(fulltrackList.get(numberToAdd));



    }


}
