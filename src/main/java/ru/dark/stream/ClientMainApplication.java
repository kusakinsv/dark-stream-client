package ru.dark.stream;

import freemarker.template.TemplateException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.dark.stream.controller.ServiceLayer;
import ru.dark.stream.model.MusicTrack;
import ru.dark.stream.model.Separator;
import ru.dark.stream.utils.InternetMusicSercher;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class ClientMainApplication {

    public static void main(String[] args) throws URISyntaxException, IOException, TimeoutException, TemplateException {
        ApplicationContext context = SpringApplication.run(ClientMainApplication.class, args);
    }


}
