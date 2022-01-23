package com.anirbit.anirbitadak.safar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class emergency extends AppCompatActivity {

    RadioGroup radio;
    RadioButton fire,ambulance,police,women,child;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        radio = (RadioGroup) findViewById(R.id.radio);
        fire = (RadioButton) findViewById(R.id.fire);
        ambulance = (RadioButton) findViewById(R.id.ambulance);
        police = (RadioButton) findViewById(R.id.police);
        women = (RadioButton) findViewById(R.id.women);
        child = (RadioButton) findViewById(R.id.child);
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.fire:
                if (checked)
                    onfireclicked();
                break;
            case R.id.ambulance:
                if (checked)
                    onambulanceclicked();
                break;
            case R.id.police:
                if (checked)
                    onpoliceclicked();
                break;
            case R.id.women:
                if (checked)
                    onwomenclicked();
                break;
            case R.id.child:
                if (checked)
                    onchildclicked();
                break;
        }


    }

    public void onfireclicked()
    {
        Intent call=new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:101"));
        startActivity(call);
    }
    public void onambulanceclicked()
    {
        Intent call=new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:102"));
        startActivity(call);
    }
    public void onpoliceclicked()
    {
        Intent call=new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:100"));
        startActivity(call);
    }
    public void onwomenclicked()
    {
        Intent call=new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:181"));
        startActivity(call);
    }
    public void onchildclicked()
    {
        Intent call=new Intent(Intent.ACTION_DIAL);
        call.setData(Uri.parse("tel:1098"));
        startActivity(call);
    }
}