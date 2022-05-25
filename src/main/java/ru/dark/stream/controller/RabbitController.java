package ru.dark.stream.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
public class RabbitController {

    @Autowired
    AmqpTemplate template;

    @ResponseBody
    public String response(String object) {
        System.out.println("Emit to dark-stream-queue");
        template.convertAndSend("dark-stream-queue-server", object);
        return "Emit to queue";
    }

    @GetMapping("/searchTrackInBase")
    ResponseEntity<?> searchTrack(@RequestParam(value = "track", required = false) String track
    ) throws SQLException, InterruptedException {
        try {
            System.out.println("Отправлено: " + track);
            template.convertAndSend("dark-stream-queue-server", track);
            String msg = "testmsg";
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok("in progress");
    }

    @ResponseBody
    public String sendAndRecieve(String object) {
        System.out.println("Emit to dark-stream-queue");
        Object o = template.convertSendAndReceive("dark-stream-queue-server", object);
        String objectToString = (String) o;
        System.out.println(objectToString);
        return "Emit to queue";
    }
}
