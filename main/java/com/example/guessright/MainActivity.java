package com.example.guessright;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    TextView textView, textView2, textView3;
    ImageButton imageButton,imageButton2;
    Button button;
    java.util.Random random = new java.util.Random();
    Integer level,num,choice;
    MediaPlayer player;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
        imageButton = findViewById(R.id.imageButton);
        imageButton2 = findViewById(R.id.imageButton2);
        button = findViewById(R.id.button);
        level=1;
        choice = 0;
        textView3.setText("Level"+" "+level);
        num = random.nextInt(2) + 1;
        imageButton.setImageResource(R.drawable.card);
        imageButton2.setImageResource(R.drawable.card);
    }
    @SuppressLint("SetTextI18n")
    public void guess(View view) {
        if (imageButton.isPressed()) {
            choice =1;
            if(choice.equals(num)) {
                imageButton.setImageResource(R.drawable.correct);
                level++;
                num = random.nextInt(2) + 1;
                textView3.setText("Level"+" "+level);
                player = MediaPlayer.create(this, R.raw.success);
                player.start();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Congratulations! You have proceeded to the next level!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                imageButton.setImageResource(R.drawable.card);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
            else {
                imageButton.setImageResource(R.drawable.wrong);
                player = MediaPlayer.create(this, R.raw.fail);
                player.start();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You have guessed wrong... You have reached to level "+level+"\nTry again.")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                @SuppressLint("UnsafeIntentLaunch") Intent intent = getIntent();
                                finish();
                                startActivity(intent);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
    }
    @SuppressLint("SetTextI18n")
    public void guess1(View view) {
        if (imageButton2.isPressed()) {
            choice =1;
            if(choice.equals(num)) {
                imageButton2.setImageResource(R.drawable.correct);
                level++;
                num = random.nextInt(2) + 1;
                textView3.setText("Level"+" "+level);
                player = MediaPlayer.create(this, R.raw.success);
                player.start();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Congratulations! You have proceeded to the next level!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                imageButton2.setImageResource(R.drawable.card);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
            else {
                imageButton2.setImageResource(R.drawable.wrong);
                player = MediaPlayer.create(this, R.raw.fail);
                player.start();
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("You have guessed wrong..."+"\nTry again.")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                @SuppressLint("UnsafeIntentLaunch") Intent intent = getIntent();
                                finish();
                                startActivity(intent);
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
            }
        }
    }
    public void sim(View view) {
        int[] results = new int[15];
        for (int i = 0; i<15; i++) {
            num = random.nextInt(2) + 1;
            results[i] = num;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("A random combination is the following:\n\n"+ Arrays.toString(results))
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        @SuppressLint("UnsafeIntentLaunch") Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}