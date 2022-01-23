package com.anirbit.anirbitadak.safar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class endscreen extends AppCompatActivity {

    TextView time;
    Button OK;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endscreen);
        time=(TextView)findViewById(R.id.time);
        OK=(Button)findViewById(R.id.OK);
        long diff = MainActivity2.endtime - MainActivity2.starttime;
        diff = TimeUnit.MILLISECONDS.toMinutes(diff);
        if(diff<60)
            time.setText("Total Time: " + diff + " minutes");
        else
            time.setText("Total Time: " + diff/60 + " hours");

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "!!! SEE YOU SOON AGAIN !!!", Toast.LENGTH_SHORT).show();
                Intent exit = new Intent(Intent.ACTION_MAIN);
                exit.addCategory(Intent.CATEGORY_HOME);
                exit.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(exit);
                finish();
            }
        });
    }
}