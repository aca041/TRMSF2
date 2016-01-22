

package com.test.trshuttlefinder;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;




public class Raw extends AppCompatActivity {

    TextView text_Result;
    public Typeface KnowledgeFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.raw);

        KnowledgeFont = Typeface.createFromAsset(getAssets(), "fonts/Knowledge-Medium.ttf");
        text_Result = (TextView) findViewById(R.id.VAN_No);
        text_Result.setTextColor(Color.parseColor("#ff9000"));
        text_Result.setTypeface(KnowledgeFont);


        //printDatabase();
    }

}
