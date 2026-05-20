package com.project.lovable_clone.entity;

import com.project.lovable_clone.enums.MessageRole;

import java.time.Instant;

public class ChatMessage {
    Long id;
    ChatSession chatSession;
    String toolCalls; //json array of tools called
    String content;
    Integer tokenUsed;
    MessageRole role;
    Instant createdAt;

}
