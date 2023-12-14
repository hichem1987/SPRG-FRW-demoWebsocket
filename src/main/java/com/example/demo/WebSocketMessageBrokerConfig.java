package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
@EnableScheduling
public class WebSocketMessageBrokerConfig implements WebSocketMessageBrokerConfigurer {

    // URL du serveur Websocket
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/demo").withSockJS();
    }

    // Canal ayant le role de Horloge parlante
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //config.setApplicationDestinationPrefixes("/app");
        config.enableSimpleBroker("/topic/time", "/topic/chat");
    }
}