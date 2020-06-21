package com.uplift.sample.basictemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.InputMismatchException;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    Button ok ;
    EditText text;
    LinearLayout linearLayout;
    Random gen = new Random();
    int target =0;
    boolean guessed = false;
    int guesses=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        text = findViewById(R.id.text);
        ok = findViewById(R.id.ok);
        linearLayout=findViewById(R.id.linearlayout);

        while(hasDupes(target= (gen.nextInt(9000) + 1000)));
        final String targetStr = target +"";
       ok.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String s=text.getText().toString();

               if(s!=null && !s.equals("")) {
                  int[] ans =  game(targetStr, s);
                   TextView textView = new TextView(GameActivity.this);
                    textView.setText(guesses+".  "+s+"   "+ans[1]+" Cows &"+ans[0]+" Bulls.");
//                  textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
                    linearLayout.addView(textView);
                    if(guessed) {
                        Toast.makeText(GameActivity.this, guesses+" is valu", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(GameActivity.this, ScoreActivity.class).putExtra("Guesses", guesses);
                        GameActivity.this.startActivity(intent);
                    }
               }
           }
       });


    }
    public int[] game(String targetStr, String temp){

            int bulls = 0;
            int cows = 0;
            int guess;
            int[] ans = new int[2];
            try{
                    guess=Integer.parseInt(temp);
                if(hasDupes(guess) || guess < 1000) return ans;
            }catch(InputMismatchException e){
                return ans;
            }
            guesses++;
            String guessStr = guess + "";
            for(int i= 0;i < 4;i++){
                if(guessStr.charAt(i) == targetStr.charAt(i)){
                    bulls++;
                }else if(targetStr.contains(guessStr.charAt(i)+"")){
                    cows++;
                }
            }
            if(bulls == 4){
                guessed = true;
            }

        ans[0]=bulls;
            ans[1]=cows;
            return ans;
    }
    public static boolean hasDupes(int num){
        boolean[] digs = new boolean[10];
        while(num > 0){
            if(digs[num%10]) return true;
            digs[num%10] = true;
            num/= 10;
        }
        return false;
    }
}
