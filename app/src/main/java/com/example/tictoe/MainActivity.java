package com.example.tictoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int[] state={2,2,2,2,2,2,2,2,2};
    boolean start=true;
    int active=0;
    public void display(View view) {
        ImageView img = (ImageView) view;
        if (!start) {
            gameReset();
        } else {

            int tap = Integer.parseInt(img.getTag().toString());
            if (state[tap] == 2) {
                state[tap] = active;
                img.setTranslationY(1000f);

                if (active == 0) {
                    img.setImageResource(R.drawable.o);
                    active = 1;

                } else {
                    img.setImageResource(R.drawable.x);
                    active = 0;
                }
                img.animate().translationYBy(-1000f).setDuration(300);

            }
        }


        if (((state[0] == state[1]) && (state[0] == state[2]) && state[0] == 0) || ((state[3] == state[4]) && (state[3] == state[5]) && state[3] == 0) || ((state[6] == state[7]) && (state[6] == state[8]) && state[6] == 0) || ((state[0] == state[4]) && (state[0] == state[8]) && state[0] == 0) || ((state[2] == state[4]) && (state[2] == state[6]) && state[2] == 0) || ((state[0] == state[3]) && (state[0] == state[6]) && state[0] == 0) || ((state[1] == state[4]) && (state[1] == state[7]) && state[1] == 0) || ((state[2] == state[5]) && (state[2] == state[8]) && state[2] == 0)) {
            Toast.makeText(this, " O has won the game", Toast.LENGTH_SHORT).show();
            start = false;
            gameReset();
        }
        else if (((state[0] == state[1]) && (state[0] == state[2]) && state[0] == 1) || ((state[3] == state[4]) && (state[3] == state[5]) && state[3] == 1) || ((state[6] == state[7]) && (state[6] == state[8]) && state[6] == 1) || ((state[0] == state[4]) && (state[0] == state[8]) && state[0] == 1) || ((state[2] == state[4]) && (state[2] == state[6]) && state[2] == 1) || ((state[0] == state[3]) && (state[0] == state[6]) && state[0] == 1) || ((state[1] == state[4]) && (state[1] == state[7]) && state[1] == 1) || ((state[2] == state[5]) && (state[2] == state[8]) && state[2] == 1)) {
            Toast.makeText(this, " X has won the game", Toast.LENGTH_SHORT).show();
            start = false;
            gameReset();
        }
    }



    public void gameReset() {
        start = true;
        active = 0;
        Arrays.fill(state, 2);
        ((ImageView)findViewById(R.id.o0)).setImageResource(0);
        ((ImageView)findViewById(R.id.o1)).setImageResource(0);
        ((ImageView)findViewById(R.id.o2)).setImageResource(0);
        ((ImageView)findViewById(R.id.o3)).setImageResource(0);
        ((ImageView)findViewById(R.id.o4)).setImageResource(0);
        ((ImageView)findViewById(R.id.o5)).setImageResource(0);
        ((ImageView)findViewById(R.id.o6)).setImageResource(0);
        ((ImageView)findViewById(R.id.o7)).setImageResource(0);
        ((ImageView)findViewById(R.id.o8)).setImageResource(0);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void retry(View v)

    {
        gameReset();

    }


}