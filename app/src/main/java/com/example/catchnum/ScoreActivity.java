package com.example.catchnum;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScoreActivity extends AppCompatActivity {
    private TextView gamesPlayed;
    private TextView correctAttempts;
    private Button back;


    private TextView playerName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        gamesPlayed = findViewById(R.id.totalGames);
        correctAttempts = findViewById(R.id.correct);
        back = findViewById(R.id.button);
        playerName = findViewById(R.id.playerName);

        back.setOnClickListener(view -> finish());


        Intent intent = getIntent();
            int totalGames = intent.getIntExtra("TOTAL_GAMES", 0);
            int totalCorrect = intent.getIntExtra("TOTAL_CORRECT_ATTEMPTS", 0);
            String name = intent.getStringExtra("PLAYERNAME");

            gamesPlayed.setText(String.valueOf(totalGames));
            correctAttempts.setText(String.valueOf(totalCorrect));
           playerName.setText(name+" "); // ← عرض الاسم الصحيح
        }


    }

