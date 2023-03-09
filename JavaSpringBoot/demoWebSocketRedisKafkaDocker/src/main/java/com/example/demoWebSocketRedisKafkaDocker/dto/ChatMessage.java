package com.example.demoWebSocketRedisKafkaDocker.dto;

import com.example.demoWebSocketRedisKafkaDocker.enumf.MessageType;

import lombok.Data;

@Data
public class ChatMessage {
    private String content;
    private String sender;
    private MessageType type;

    // constructors, getters and setters
}