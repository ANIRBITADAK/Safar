package com.anirbit.anirbitadak.safar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MainActivity2 extends AppCompatActivity {

    Button navigate, music, video, call, google, exit, emergency,services;
    SimpleDateFormat simpleDateFormat;
    long date;
    String time1;
    TextView timedisplay, nav, play, VID, phone, close;
    static long starttime;
    static long endtime;
    ImageView logo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        navigate = (Button) findViewById(R.id.navigate);
        music = (Button) findViewById(R.id.music);
        video = (Button) findViewById(R.id.video);
        call = (Button) findViewById(R.id.call);
        google = (Button) findViewById(R.id.google);
        exit = (Button) findViewById(R.id.exit);
        emergency = (Button) findViewById(R.id.emerg);
        timedisplay = (TextView) findViewById(R.id.timedisplay);
        nav = (TextView) findViewById(R.id.nav);
        play = (TextView) findViewById(R.id.play);
        VID = (TextView) findViewById(R.id.VID);
        phone = (TextView) findViewById(R.id.phone);
        close = (TextView) findViewById(R.id.close);
        services=(Button)findViewById(R.id.services);
        logo=(ImageView)findViewById(R.id.logo);


        setStarttime();

        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    while (!isInterrupted()) {
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                date = System.currentTimeMillis();
                                simpleDateFormat = new SimpleDateFormat("hh:mm:ss a");
                                time1 = simpleDateFormat.format(date);
                                timedisplay.setText(time1);


                            }
                        });
                    }
                } catch (InterruptedException e) {
                    Log.e("TAG", "run: error ", e);
                }
            }
        };
        t.start();

        navigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startnavigate();
            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startmusic();
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startvideo();
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "DON'T CALL WHILE DRIVE" + "\n PARK THE VEHICLE", Toast.LENGTH_LONG).show();
                startcall();
            }
        });

        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "DON'T USE MOBILE WHILE DRIVING" + "\n PARK THE VEHICLE", Toast.LENGTH_LONG).show();
                startgoogle();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setEndtime();
                appexit();
            }
        });

        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, emergency.class);
                startActivity(intent);
            }
        });
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity2.this,MapsActivity.class);
                startActivity(intent);
            }
        });

    }

    public void startnavigate(){
        Intent mapIntent = new Intent(Intent.ACTION_VIEW);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }

    }

    public void startmusic(){
        Intent intent = new Intent(MediaStore.INTENT_ACTION_MEDIA_PLAY_FROM_SEARCH);
        startActivity(intent);
    }

    public  void startvideo(){
        Intent videoplayer=new Intent(Intent.ACTION_VIEW);
        videoplayer.setType("video/*");
        startActivity(videoplayer);
    }

    public void startcall(){
        Intent call=new Intent(Intent.ACTION_DIAL);
        startActivity(call);
    }

    public void startgoogle(){
        Intent browser=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"));
        startActivity(browser);

    }

    public void appexit(){
        Intent intent = new Intent(MainActivity2.this, endscreen.class);
        startActivity(intent);
    }

    public void setStarttime(){
        date = System.currentTimeMillis();
        starttime=date;
    }

    public void setEndtime(){
        date = System.currentTimeMillis();
        endtime=date;
    }
}