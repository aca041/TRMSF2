package com.test.trshuttlefinder;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityTwo extends AppCompatActivity {

    static String _From, _To, _Time;
    TextView text_Result;
    SQLite dbHandler;
    public Typeface KnowledgeFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        _From = getIntent().getStringExtra("From1");
        _To = getIntent().getStringExtra("To1");
        _Time = getIntent().getStringExtra("Time1");

        dbHandler = new SQLite(this, null, null, 1);

        KnowledgeFont = Typeface.createFromAsset(getAssets(), "fonts/Knowledge-Medium.ttf");
        ListView list = (ListView) findViewById(R.id.SCHEDULE);

        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();

        String dbString = dbHandler.databaseToString();
        String dbRowValues[] = dbString.split(System.getProperty("line.separator"));
        String tmpString[] = null;


        for (int i = 0; i < dbRowValues.length; i++) {

            map = new HashMap<String, String>();
            if (i == 0) {
                TextView tResult = (TextView) findViewById(R.id.data0);

                tResult.setTextColor(Color.parseColor("#F7F7F7"));
                tResult.setTypeface(KnowledgeFont);

                tResult.setText(dbRowValues[0] + "\n" + dbRowValues[1] +
                        "\n" + "Number of Records: " + (dbRowValues.length - 2));
                i = 1;
                map.put("van", "VAN #");
                map.put("from", "FROM");
                map.put("to", "TO");
                map.put("etd", "ETD");
                map.put("bldg", "BLDG");
            } else {
                tmpString = dbRowValues[i].split(",");


                map.put("van", tmpString[0] + "  " + tmpString[1]);
                map.put("from", tmpString[2]);
                map.put("to", tmpString[3]);
                map.put("etd", tmpString[4]);
                map.put("bldg", tmpString[5]);

            }
            mylist.add(map);
        }


        SimpleAdapter mSchedule = new SimpleAdapter(this, mylist, R.layout.raw,
                new String[]{"van", "from", "to", "etd", "bldg"}, new int[]{R.id.VAN_No, R.id.FROM_CELL, R.id.TO_CELL, R.id.ETD, R.id.BLDG});
        list.setAdapter(mSchedule);
        Log.d("breyerror_1", "list.setAdapter(mSchedule);");

    }

}