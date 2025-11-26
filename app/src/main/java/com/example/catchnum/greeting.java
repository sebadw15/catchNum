package com.example.catchnum;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class greeting extends AppCompatActivity {


    private EditText playerNameEditText,age;
    private Button startGameButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        age = findViewById(R.id.editTextText);
        playerNameEditText = findViewById(R.id.playerNameEditText);
        startGameButton = findViewById(R.id.startGameButton);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = playerNameEditText.getText().toString().trim();
                String playerAge = age.getText().toString().trim();


                if (playerName.isEmpty() || playerAge.isEmpty()) {
                    Toast.makeText(greeting.this, "Please enter both Name and Age", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(greeting.this, MainActivity.class);
                    intent.putExtra("PLAYER_NAME", playerName);
                    intent.putExtra("PLAYER_AGE", playerAge);
                    startActivity(intent);
                }
            }
        });


    }
}