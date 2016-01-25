package com.test.trshuttlefinder;


import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.util.Log;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.HashMap;

public class ActivityTwo extends AppCompatActivity {

    static String _From,_To,_Time;
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

        dbHandler = new SQLite(this,null,null,1);

        KnowledgeFont = Typeface.createFromAsset(getAssets(), "fonts/Knowledge-Medium.ttf");
        ListView list = (ListView) findViewById(R.id.SCHEDULE);
        //TextView tResult = (TextView) findViewById(R.id.VAN_No);
        //tResult.setTypeface(KnowledgeFont);

        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<String, String>();

        String dbString = dbHandler.databaseToString();
        String dbRowValues[] = dbString.split(System.getProperty("line.separator"));
        String tmpString[]=null;


        for (int i=0; i < dbRowValues.length; i++){
            //for (int i=0; i < 50; i++){
            map = new HashMap<String, String>();
            if ( i==0 ){
                TextView tResult = (TextView) findViewById(R.id.data0);

                tResult.setTextColor(Color.parseColor("#F7F7F7"));
                tResult.setTypeface(KnowledgeFont);

                tResult.setText(dbRowValues[0] + "\n" + dbRowValues[1] +
                        "\n" + "Number of Records: " + dbRowValues.length);
                i = 1;
                map.put("van", "VAN #");
                map.put("from", "FROM");
                map.put("to", "TO");
                map.put("etd", "ETD");
                map.put("bldg","BLDG");
            }
            else {
                tmpString=dbRowValues[i].split(",");

                /*Log.d("brey_rec0", tmpString[0]);
                Log.d("brey_rec1", tmpString[1]);
                Log.d("brey_rec2", tmpString[2]);
                Log.d("brey_rec3", tmpString[3]);
                Log.d("brey_rec4", tmpString[4]);
                Log.d("brey_rec5", tmpString[5]);*/
                map.put("van", tmpString[0] + "  " + tmpString[1]);
                map.put("from", tmpString[2]);
                map.put("to", tmpString[3]);
                map.put("etd", tmpString[4]);
                map.put("bldg", tmpString[5]);

            }
            mylist.add(map);
        }


        MySimpleAdapter mSchedule = new MySimpleAdapter(this, mylist, R.layout.raw,
                new String[] {"van", "from", "to","etd","bldg"}, new int[] {R.id.VAN_No, R.id.FROM_CELL, R.id.TO_CELL, R.id.ETD, R.id.BLDG});
        list.setAdapter(mSchedule);

        Log.d("breyerror_1", "list.setAdapter(mSchedule);");

        //TextView tResult1 = (TextView) findViewById(R.id.VAN_No);
        //tResult1.setTypeface(KnowledgeFont);

    }
    public class MySimpleAdapter extends SimpleAdapter {

        private ArrayList<HashMap<String, String>> results;

        public MySimpleAdapter(Context context, ArrayList<HashMap<String, String>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
            this.results = data;
        }

        public View getView(int position, View view, ViewGroup parent){

            Typeface localTypeface1 = Typeface.createFromAsset(getAssets(), "fonts/Knowledge-Medium.ttf");
            View v = view;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.raw, null);
            }
            TextView vanText = (TextView) v.findViewById(R.id.VAN_No);
            vanText.setText(results.get(position).get("van"));
            vanText.setTypeface(localTypeface1);

            TextView fromText = (TextView) v.findViewById(R.id.FROM_CELL);
            fromText.setText(results.get(position).get("from"));
            fromText.setTypeface(localTypeface1);

            TextView toText = (TextView) v.findViewById(R.id.TO_CELL);
            toText.setText(results.get(position).get("to"));
            toText.setTypeface(localTypeface1);

            TextView etdText = (TextView) v.findViewById(R.id.ETD);
            etdText.setText(results.get(position).get("etd"));
            etdText.setTypeface(localTypeface1);

            TextView bldgText = (TextView) v.findViewById(R.id.BLDG);
            bldgText.setText(results.get(position).get("bldg"));
            bldgText.setTypeface(localTypeface1);

            return v;
        }
    }


}
