package com.example.emeraldopendayapp;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.util.Log; // for logging
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatBot extends AppCompatActivity {

    private EditText messageBox;
    private ImageButton sendButton;
    private RecyclerView recyclerView;
    private ChatAdapter adapter;
    private ArrayList<ChatMessage> messageList;
    private ChatApi chatApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot);

        messageBox = findViewById(R.id.message_box);
        sendButton = findViewById(R.id.send_button);
        recyclerView = findViewById(R.id.recyclerView);

        messageList = new ArrayList<>();
        adapter = new ChatAdapter(this, messageList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8000/") // Replace with your actual FastAPI server URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        chatApi = retrofit.create(ChatApi.class);

        sendButton.setOnClickListener(v -> {
            String msg = messageBox.getText().toString().trim();
            if (!msg.isEmpty()) {
                addMessage(msg, true); // Add user message to list
                sendToApi(msg); // Send message to the API
                messageBox.setText(""); // Clear input box
            }
        });
    }

    private void addMessage(String text, boolean isSender) {
        String time = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());
        messageList.add(new ChatMessage(text, isSender, time));
        adapter.notifyItemInserted(messageList.size() - 1);
        recyclerView.scrollToPosition(messageList.size() - 1);
    }

    private void sendToApi(String question) {
        ChatRequest request = new ChatRequest(question);
        chatApi.sendQuestion(request).enqueue(new Callback<ChatResponse>() {
            @Override
            public void onResponse(@NonNull Call<ChatResponse> call, @NonNull Response<ChatResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("ChatBot", "AI Reply: " + response.body().getAnswer());
                    // Add response to message list
                    addMessage(response.body().getAnswer(), false);
                } else {
                    // Log the full response body if it's unsuccessful
                    Log.e("ChatBot", "Error: No response or body is null. Response: " + response.toString());
                    addMessage("Error: No response", false);
                }
            }

            @Override
            public void onFailure(@NonNull Call<ChatResponse> call, @NonNull Throwable t) {
                Log.e("ChatBot", "Error: " + t.getMessage());
                addMessage("Error: " + t.getMessage(), false); // In case of failure
            }
        });
    }
}
