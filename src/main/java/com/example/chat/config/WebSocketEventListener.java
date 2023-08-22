package com.example.chat.config;

import com.example.chat.Controller.ChatMesaage;
import lombok.RequiredArgsConstructor;
import java.util.logging.Logger;  // Import the Logger class
import com.example.chat.Controller.MessageType;


import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@RequiredArgsConstructor
public class WebSocketEventListener {
    //Define a logger instance for your class
    private static final Logger log = Logger.getLogger(WebSocketEventListener.class.getName());
    private final SimpMessageSendingOperations messagingTemplate;
    @EventListener
    public void handleWebSocketDisconnectListener(
            SessionDisconnectEvent event
    ){
      //TO Do -- implemented latter
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null){
            log.info("user  disconnected"+ username);
            var chatMesaage = ChatMesaage.builder().type(MessageType.LEAVE)
                    .sender(username)
                    .build();
            messagingTemplate.convertAndSend("/topic/public", chatMesaage);




        }
    }
}
