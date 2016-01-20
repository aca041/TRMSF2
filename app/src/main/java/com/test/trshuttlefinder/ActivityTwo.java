package com.test.trshuttlefinder;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ActivityTwo extends AppCompatActivity {

    static String _From,_To,_Time;
    TextView text_Result;
    SQLite dbHandler;
    public String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download/shuttle.csv";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        _From = getIntent().getStringExtra("From1");
        _To = getIntent().getStringExtra("To1");
        _Time = getIntent().getStringExtra("Time1");

        dbHandler = new SQLite(this,null,null,1);
        printDatabase();
    }


    public void printDatabase(){
        String dbString = dbHandler.databaseToString();
        text_Result = (TextView) findViewById(R.id.text_Result);
        text_Result.setText(dbString);
        text_Result.setTextColor(Color.parseColor("#FFFFFF"));


    }
}
