package com.example.nimish.anti_pickpocket;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

RadioGroup rg;
RadioButton rb;
Switch myswitch;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg=(RadioGroup) findViewById(R.id.rgrp);

    }

    public void rbclick(View V)
    {
        int rbid=rg.getCheckedRadioButtonId();
        rb=(RadioButton) findViewById(rbid);

        String str[]=rb.getText().toString().split(" ");
        final int delay_val=Integer.parseInt(str[0]);

        myswitch=(Switch)findViewById(R.id.switch1);
        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(getBaseContext(), "Delay set to " + delay_val + " sec", Toast.LENGTH_SHORT).show();
                    Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                    Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                    r.play();
            }
            }
        });
    }
}
