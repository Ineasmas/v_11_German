package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Button btenter = (Button)  findViewById(R.id.btenter);
        btenter.setOnClickListener(this::onClick);

    }

    private void onClick(View v) {
        EditText edlogin=(EditText) findViewById(R.id.edlogin);
        EditText edpassword=(EditText) findViewById(R.id.edpassword);
        String Login=edlogin.getText().toString();
        String Password=edpassword.getText().toString();
        if(!Login.isEmpty() | !Password.isEmpty())
        {
            SQLiteDatabase db = getBaseContext().openOrCreateDatabase("db.db",MODE_PRIVATE,null);
            db.execSQL("CREATE TABLE IF NOT EXISTS users(id INEGER PRIMARY KEY AUTOINCREMENT,login TEXT, password TEXT)",null);
            db.execSQL(String.format("INSERT INTO users(login,password) VALUES('%s','%s1')",Login,Password),null);
            db.close();
        }
        else{
            Toast toast=Toast.makeText(getApplicationContext(),"Заполнены не все значения!", Toast.LENGTH_SHORT);
            toast.show();
        }
        Intent intent = new Intent(MainActivity.this, PersonalActivity.class);
        startActivity(intent);
    }
}