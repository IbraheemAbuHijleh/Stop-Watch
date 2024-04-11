package com.example.stopwatchtownew;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int Second=0;

    private boolean Flag=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        Chreck(savedInstanceState);

        run();

    }

    private void Chreck(Bundle savedInstanceState) {

        Log.d("Stop",  "savedInstanceState is null");


        if (savedInstanceState !=null ) {

            Log.d("Stop",  "savedInstanceState is null 1");
         

            Second = savedInstanceState.getInt("SECONDS");

            Flag = savedInstanceState.getBoolean("Run");

        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);


        outState.putInt("Seconds",Second);

        outState.putBoolean("Run",Flag);

    }

    private void run() {
        Handler handler = new Handler();

        final TextView  txtwat = findViewById(R.id.txtwat);

        handler.post(new Runnable() {

            @Override
            public void run() {

                int hours = Second / 3600;

                int minits = (Second % 3600) / 60;

                int secs = Second % 60;

                String res = hours + " : " + minits + " : " + secs;

                txtwat.setText(res);


                if(Flag){

                    Second++;
                }

                handler.postDelayed(this, 1000);
            }

        });
    }

    public void btnrestart(View view) {
        Flag=false;

        Second=0;

    }

    public void btnstop(View view) {

       Flag=false;

    }

    public void btnstart(View view) {

        Flag=true;

    }



}