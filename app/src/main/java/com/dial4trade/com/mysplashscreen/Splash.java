package com.dial4trade.com.mysplashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {

    private ProgressBar progressBar;
    private int process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        progressBar = (ProgressBar) findViewById(R.id.progbar);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startActivity();
            }
        });

          thread.start();
    }

    public void doWork(){

        for (process =20;process<=100;process=process+20){

            try {
                Thread.sleep(1000);
                progressBar.setProgress(process);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public void startActivity(){
        Intent intent = new Intent(Splash.this,MainActivity.class);
        startActivity(intent);
        finish();

    }
}
