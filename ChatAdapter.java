package com.example.emeraldopendayapp;


import android.content.Context;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<ChatMessage> messages;
    private final Context context;
    private static final int VIEW_TYPE_SENDER = 1;
    private static final int VIEW_TYPE_RECEIVER = 2;

    public ChatAdapter(Context context, List<ChatMessage> messages) {
        this.context = context;
        this.messages = messages;
    }

    @Override
    public int getItemViewType(int position) {
        return messages.get(position).isSender() ? VIEW_TYPE_SENDER : VIEW_TYPE_RECEIVER;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_SENDER) {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_sender_view, parent, false);
            return new SenderViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.activity_reciver_view, parent, false);
            return new ReceiverViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ChatMessage message = messages.get(position);
        if (holder instanceof SenderViewHolder) {
            ((SenderViewHolder) holder).senderText.setText(message.getContent());
            ((SenderViewHolder) holder).senderTime.setText(message.getTime());
        } else {
            ((ReceiverViewHolder) holder).receiverText.setText(message.getContent());
            ((ReceiverViewHolder) holder).receiverTime.setText(message.getTime());
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    static class SenderViewHolder extends RecyclerView.ViewHolder {
        TextView senderText, senderTime;

        public SenderViewHolder(@NonNull View itemView) {
            super(itemView);
            senderText = itemView.findViewById(R.id.sender_text);
            senderTime = itemView.findViewById(R.id.sender_time);
        }
    }

    static class ReceiverViewHolder extends RecyclerView.ViewHolder {
        TextView receiverText, receiverTime;

        public ReceiverViewHolder(@NonNull View itemView) {
            super(itemView);
            receiverText = itemView.findViewById(R.id.receiver_text);
            receiverTime = itemView.findViewById(R.id.receiver_time);
        }

        public void bind(ChatMessage message) {
            receiverText.setText(message.getContent());
            receiverTime.setText(message.getTime());
        }
    }
}














//public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    private final Context context;
//    private final List<ChatMessage> messageList;
//
//    public ChatAdapter(Context context, List<ChatMessage> messageList) {
//        this.context = context;
//        this.messageList = messageList;
//    }
//
//    @Override
//    public int getItemViewType(int position) {
//        return messageList.get(position).getSenderType();
//    }
//
//    @Override
//    public int getItemCount() {
//        return messageList.size();
//    }
//
//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view;
//        if (viewType == ChatMessage.SENDER_USER) {
//            view = LayoutInflater.from(context).inflate(R.layout.activity_sender_view, parent, false);
//            return new SenderViewHolder(view);
//        } else {
//            view = LayoutInflater.from(context).inflate(R.layout.activity_reciver_view, parent, false);
//            return new ReceiverViewHolder(view);
//        }
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//        ChatMessage message = messageList.get(position);
//        if (holder instanceof SenderViewHolder) {
//            ((SenderViewHolder) holder).senderMessage.setText(message.getMessage());
//            ((SenderViewHolder) holder).senderTime.setText(message.getTime());
//        } else if (holder instanceof ReceiverViewHolder) {
//            ((ReceiverViewHolder) holder).receiverMessage.setText(message.getMessage());
//            ((ReceiverViewHolder) holder).receiverTime.setText(message.getTime());
//        }
//    }
//
//    static class SenderViewHolder extends RecyclerView.ViewHolder {
//        TextView senderMessage, senderTime;
//
//        SenderViewHolder(View itemView) {
//            super(itemView);
//            senderMessage = itemView.findViewById(R.id.sender_text);
//            senderTime = itemView.findViewById(R.id.sender_time);
//        }
//    }
//
//    static class ReceiverViewHolder extends RecyclerView.ViewHolder {
//        TextView receiverMessage, receiverTime;
//
//        ReceiverViewHolder(View itemView) {
//            super(itemView);
//            receiverMessage = itemView.findViewById(R.id.receiver_text);
//            receiverTime = itemView.findViewById(R.id.receiver_time);
//        }
//    }
//}
