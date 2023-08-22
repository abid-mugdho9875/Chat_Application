package com.example.chat.Controller;
import lombok.*;
import lombok.extern.slf4j.Slf4j;


@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Builder
public class ChatMesaage {


    private String Content;
    public void setContent(String content) {
        Content = content;
    }
    public String getContent() {
        return Content;
    }


    private MessageType type;
    public void setType(MessageType type) {
        this.type = type;
    }

    public MessageType getType() {
        return type;
    }



    private String sender;
    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }
}
