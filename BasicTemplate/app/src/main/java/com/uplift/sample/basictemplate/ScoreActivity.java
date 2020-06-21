package com.uplift.sample.basictemplate;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        int guesses= getIntent().getIntExtra("Guesses",0);
        TextView textView = findViewById(R.id.text);
        textView.setText("You won after "+guesses+" guesses!");
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(ScoreActivity.this,MainActivity.class);
        startActivity(intent);
    }
}
