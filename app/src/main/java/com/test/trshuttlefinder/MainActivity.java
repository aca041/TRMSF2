package com.test.trshuttlefinder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner spinner, spinner2, spinner3;
    public String _From,_To,_Time;




    @Override
    protected void onCreate(Bundle savedInstanceState){


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner)findViewById(R.id.input_From);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.From,android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        spinner2 = (Spinner)findViewById(R.id.input_To);
        ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this,R.array.To,android.R.layout.simple_spinner_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);

        spinner3 = (Spinner)findViewById(R.id.input_Time);
        final ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.ETD,android.R.layout.simple_spinner_item);
        spinner3.setAdapter(adapter2);
        spinner3.setOnItemSelectedListener(this);

        Button button_Search =(Button) findViewById(R.id.button_Search);
        button_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ActivityTwo.class);

                intent.putExtra("From1", _From);
                intent.putExtra("To1",_To);
                intent.putExtra("Time1", _Time);
                startActivity(intent);
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
       _From = spinner.getSelectedItem().toString();
       _To = spinner2.getSelectedItem().toString();
       _Time = spinner3.getSelectedItem().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }





}