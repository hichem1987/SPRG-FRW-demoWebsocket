package com.example.demo;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WebSocketController {

    @MessageMapping("/newMessage")
    @SendTo("/topic/chat")
    public String greeting(String message) throws Exception {
        return HtmlUtils.htmlEscape(message);
    }
}
