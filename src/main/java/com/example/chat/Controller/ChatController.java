package com.example.chat.Controller;

import org.apache.catalina.util.CharsetMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/chat.sendMesaage")
    @SendTo("/topic/public")
    public ChatMesaage sendMessage(
             @Payload  ChatMesaage chatMesaage
            ){
        return  chatMesaage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMesaage addUser(
            @Payload ChatMesaage chatMesaage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        String sender = chatMesaage.getSender(); // Use the 'getSender()' method to get the sender's name
        headerAccessor.getSessionAttributes().put("username", sender);
        return chatMesaage;
    }



}