package com.example.catchnum;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView n1, n2, n3, n4, n5, n6, random, numbers;
    private int counttrue=0;
    private Button start, newgame,score;
    private boolean isRunning;
    private Random rand = new Random();
    private int count=0,winSum=0,tgame=1;

    private EditText name;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.num1);
        n2 = findViewById(R.id.num2);
        n3 = findViewById(R.id.num3);
        n4 = findViewById(R.id.num4);
        n5 = findViewById(R.id.num5);
        n6 = findViewById(R.id.num6);
        numbers = findViewById(R.id.points);
        random = findViewById(R.id.randNum);
        newgame = findViewById(R.id.newgame);
        start = findViewById(R.id.startstop);
        score=findViewById(R.id.scoreGame);
        name = findViewById(R.id.editTextText);

        n1.setText(String.valueOf(rand.nextInt(40) + 1));
        n2.setText(String.valueOf(rand.nextInt(40) + 1));
        n3.setText(String.valueOf(rand.nextInt(40) + 1));
        n4.setText(String.valueOf(rand.nextInt(40) + 1));
        n5.setText(String.valueOf(rand.nextInt(40) + 1));
        n6.setText(String.valueOf(rand.nextInt(40) + 1));
        random.setText("0");
        numbers.setText("");
        start.setText("start");
        isRunning = false;
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tgame++;
                if(count>5){
                    n1.setText(String.valueOf(rand.nextInt(40) + 1));
                    n2.setText(String.valueOf(rand.nextInt(40) + 1));
                    n3.setText(String.valueOf(rand.nextInt(40) + 1));
                    n4.setText(String.valueOf(rand.nextInt(40) + 1));
                    n5.setText(String.valueOf(rand.nextInt(40) + 1));
                    n6.setText(String.valueOf(rand.nextInt(40) + 1));
                    random.setText("0");
                    numbers.setText("");
                    start.setText("start");
                    isRunning = false;
                    count=0;
                    n1.setBackgroundColor(0);
                    n2.setBackgroundColor(0);
                    n3.setBackgroundColor(0);
                    n4.setBackgroundColor(0);
                    n5.setBackgroundColor(0);
                    n6.setBackgroundColor(0);
                }

            }
        });
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isRunning&&count<6) {
                    count++;
                    isRunning = true;
                    start.setText("stop");
                    start.setBackgroundTintList(ColorStateList.valueOf(Color.RED));

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (isRunning) {
                                final int num = rand.nextInt(40) + 1;


                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        random.setText(String.valueOf(num));
                                    }
                                });

                                try {
                                    Thread.sleep(100);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }).start();

                } else {
                    if (count == 6) {
                        Toast.makeText(MainActivity.this, "انتهت اللعبة! اضغط New  لتبدأ من جديد.", Toast.LENGTH_SHORT).show();
                    }

                    isRunning = false;
                    start.setText("start");
                    start.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                    String drawn = random.getText().toString();
                    counttrue=0;

                    if (n1.getText().toString().equals(drawn)){
                        winSum++;
                        counttrue++;
                        numbers.setText(counttrue+" out of 6");
                        n1.setBackgroundColor(0xffff0000);

                    }

                    if (n2.getText().toString().equals(drawn)){
                        winSum++;
                        counttrue++;
                        numbers.setText(counttrue+" out of 6");
                        n2.setBackgroundColor(0xffff0000);
                    }

                    if (n3.getText().toString().equals(drawn)){
                        winSum++;
                        counttrue++;
                        numbers.setText(counttrue+" out of 6");
                        n3.setBackgroundColor(0xffff0000);
                    }

                    if (n4.getText().toString().equals(drawn)){
                        winSum++;
                        counttrue++;
                        numbers.setText(counttrue+" out of 6");
                        n4.setBackgroundColor(0xffff0000);
                    }

                    if (n5.getText().toString().equals(drawn)){
                        winSum++;
                        counttrue++;
                        numbers.setText(counttrue+" out of 6");
                        n5.setBackgroundColor(0xffff0000);
                    }

                    if (n6.getText().toString().equals(drawn)){
                        winSum++;
                        counttrue++;
                        numbers.setText(counttrue+" out of 6");
                        n6.setBackgroundColor(0xffff0000);
                    }

                }
            }
        });


        score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                String name2 = name.getText().toString().trim(); // ← خذ الاسم هنا بعد ما المستخدم يكتبه



                Intent intent = new Intent(MainActivity.this, ScoreActivity.class);
                intent.putExtra("TOTAL_GAMES", tgame);
                intent.putExtra("TOTAL_CORRECT_ATTEMPTS", winSum);
                intent.putExtra("PLAYERNAME", name2);

                startActivity(intent);
            }
        });


    }


}
