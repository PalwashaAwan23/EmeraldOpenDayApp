package com.example.emeraldopendayapp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class ChatMessage {
    private String content;
    private boolean isSender;
    private String time;

    public ChatMessage(String content, boolean isSender, String time) {
        this.content = content;
        this.isSender = isSender;
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public boolean isSender() {
        return isSender;
    }

    public String getTime() {
        return time;
    }
}

//public class ChatMessage {
//
//    public static final int SENDER_USER = 0;
//    public static final int SENDER_BOT = 1;
//
//    private String message;
//    private String time;
//    private int senderType;
//
//    // Constructor with time auto-generated
//    public ChatMessage(String message, int senderType) {
//        this.message = message;
//        this.senderType = senderType;
//        this.time = getCurrentTime(); // auto-sets time
//    }
//
//    // Constructor with custom time if needed
//    public ChatMessage(String message, String time, int senderType) {
//        this.message = message;
//        this.time = time;
//        this.senderType = senderType;
//    }
//
//    private String getCurrentTime() {
//        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public String getTime() {
//        return time;
//    }
//
//    public int getSenderType() {
//        return senderType;
//    }
//}

