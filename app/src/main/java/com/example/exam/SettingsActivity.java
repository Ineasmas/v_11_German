package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        ImageButton btexit = (ImageButton) findViewById(R.id.btexit);
        btexit.setOnClickListener(this::onClick);
        Button btsbros = (Button) findViewById(R.id.btsbros);
        btsbros.setOnClickListener(this::onClick);

    }

    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.btexit:
                Intent intent = new Intent(SettingsActivity.this, PersonalActivity.class);
                startActivity(intent);
                break;
            case R.id.btsbros:
                Switch sw1=(Switch) findViewById(R.id.sw1);
                Switch sw2=(Switch) findViewById(R.id.sw2);
                Switch sw3=(Switch) findViewById(R.id.sw3);
                sw1.setChecked(true);
                sw2.setChecked(true);
                sw3.setChecked(true);


        }
    }
}