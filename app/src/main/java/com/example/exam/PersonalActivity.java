package com.example.exam;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PersonalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_area);
        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this::onClick);
        ImageButton imagebutton3 = (ImageButton) findViewById(R.id.imageButton3);
        imagebutton3.setOnClickListener(this::onClick);
        ImageButton imagebutton4 = (ImageButton) findViewById(R.id.imageButton4);
        imagebutton4.setOnClickListener(this::onClick);
        SQLiteDatabase db=getBaseContext().openOrCreateDatabase("db.db",MODE_PRIVATE,null);
        Cursor query =db.rawQuery("SELECT login FROM clients;",null);
        query.moveToLast();
        TextView textView2=(TextView) findViewById(R.id.textView2);
        textView2.setText("Добрый день, "+query.getString(0)+"!");
        db.close();
    }

    private void onClick(View v) {
        switch (v.getId()) {
            case R.id.button4:

                Intent intent1 = new Intent(Intent.ACTION_DIAL);
                intent1.setData(Uri.parse("tel:+79016714574"));
                startActivity(intent1);
                break;
            case R.id.imageButton3:
                Intent intent2 = new Intent(PersonalActivity.this, MainActivity.class);
                startActivity(intent2);
            case R.id.imageButton4:
                Intent intent3 = new Intent(PersonalActivity.this, SettingsActivity.class);
                startActivity(intent3);


        }

    }
}
