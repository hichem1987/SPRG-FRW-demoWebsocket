package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class ClockScheduledTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private SimpMessagingTemplate template;

    @Scheduled(fixedRate = 5000L) //5000L type is : long
    public void reportCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss"); // yyyy-MM-dd HH:mm:ss"
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(formatter);

        // write in server log
        System.out.println("The time is now " + time);

        // ----> WEBSOCKET
        // sends the message to /topic/time
        this.template.convertAndSend("/topic/time", "Time: " + time);
    }
}