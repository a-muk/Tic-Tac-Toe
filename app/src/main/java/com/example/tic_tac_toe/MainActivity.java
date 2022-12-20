package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    boolean gameactive=true;
    int active=0;
    int[] state={2,2,2,2,2,2,2,2,2};
    //states---   0- X 1-O 2-null
    int[][] winpositions={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void tap(View view){
        ImageView img = (ImageView) view;
        if(!gameactive){
            reset(view);
        }
        int tappedImage=Integer.parseInt(img.getTag().toString());
        if(state[tappedImage]==2){
            state[tappedImage]= active;
            img.setTranslationY(-1000f);
            if(active==0){
                img.setImageResource(R.drawable.x);
                active=1;
                TextView status=findViewById(R.id.below_text);
                status.setText("O's turn -Tap to play!");
            }
            else{
                img.setImageResource(R.drawable.o);
                active=0;
                TextView status=findViewById(R.id.below_text);
                status.setText("X's turn -Tap to play!");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        //Check winning status
        String winner;
        for(int[] win : winpositions){
            if((state[win[0]]==state[win[1]])&& (state[win[1]]==state[win[2]]) && (state[win[0]]!=2)){
                gameactive=false;
                if(state[win[0]]==0){
                    winner="X has won";
                }
                else{
                    winner="O has won!";
                }
                TextView status=findViewById(R.id.below_text);
                status.setText(winner);
            }

        }
    }

    public void reset(View view){
        gameactive=true;
        active=0;
        for(int i=0;i<state.length;i++){
            state[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}