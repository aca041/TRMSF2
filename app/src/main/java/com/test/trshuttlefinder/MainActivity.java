package com.test.trshuttlefinder;

import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import android.view.ViewGroup;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    Spinner spinner, spinner2, spinner3;
    public String _From,_To,_Time;
    public Typeface KnowledgeFont;



    @Override
    protected void onCreate(Bundle savedInstanceState){


        KnowledgeFont = Typeface.createFromAsset(getAssets(),"fonts/Knowledge-Medium.ttf");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        spinner = (Spinner)findViewById(R.id.input_From);
        //ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.From, android.R.layout.simple_spinner_item);
        MySpinnerAdapter adapter = new MySpinnerAdapter(
                this,
                android.R.layout.simple_spinner_item,
                Arrays.asList(getResources().getStringArray(R.array.From))
        );
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        ChangeSpinnerColorDropDown(spinner);



        spinner2 = (Spinner)findViewById(R.id.input_To);
        //ArrayAdapter adapter1 = ArrayAdapter.createFromResource(this, R.array.To, android.R.layout.simple_spinner_item);
        MySpinnerAdapter adapter1 = new MySpinnerAdapter(
                this,
                android.R.layout.simple_spinner_item,
                Arrays.asList(getResources().getStringArray(R.array.To))
        );
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);
        ChangeSpinnerColorDropDown(spinner2);

        spinner3 = (Spinner)findViewById(R.id.input_Time);
        //final ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.ETD,android.R.layout.simple_spinner_item);
        MySpinnerAdapter adapter2 = new MySpinnerAdapter(
                this,
                android.R.layout.simple_spinner_item,
                Arrays.asList(getResources().getStringArray(R.array.ETD))
        );
        spinner3.setAdapter(adapter2);
        spinner3.setOnItemSelectedListener(this);
        ChangeSpinnerColorDropDown(spinner3);

        Button button_Search =(Button) findViewById(R.id.button_Search);
        button_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ActivityTwo.class);

                intent.putExtra("From1", _From);
                intent.putExtra("To1", _To);
                intent.putExtra("Time1", _Time);
                startActivity(intent);
            }
        });

        button_Search.setTypeface(KnowledgeFont);

        TextView textView = (TextView) findViewById(R.id.textView);
        TRKownledgeFont(textView, KnowledgeFont);
        textView = (TextView) findViewById(R.id.lbl_From);
        TRKownledgeFont(textView, KnowledgeFont);
        textView = (TextView) findViewById(R.id.lbl_To);
        TRKownledgeFont(textView, KnowledgeFont);
        textView = (TextView) findViewById(R.id.lbl_Time);
        TRKownledgeFont(textView, KnowledgeFont);


        ImageView img = (ImageView)findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://thehub.thomsonreuters.com/groups/manila-automation-group"));
                startActivity(intent);
            }
        });


    }

    public static class MySpinnerAdapter extends ArrayAdapter<String> {
        // Initialise custom font, for example:
        Typeface font = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/Knowledge-Medium.ttf");

        // (In reality I used a manager which caches the Typeface objects)
        // Typeface font = FontManager.getInstance().getFont(getContext(), Knowledge-Medium.);

        private MySpinnerAdapter(Context context, int resource, List<String> items) {
            super(context, resource, items);
        }

        // Affects default (closed) state of the spinner
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getView(position, convertView, parent);
            view.setTypeface(font);
            return view;
        }

        // Affects opened state of the spinner
        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getDropDownView(position, convertView, parent);
            view.setTypeface(font);
            return view;
        }
    }

    public void TRKownledgeFont(TextView textview,Typeface myFont){
        textview.setTypeface(myFont);
    }

    public void ChangeSpinnerColorDropDown(Spinner spin){
        Drawable spinnerDrawable = spin.getBackground().getConstantState().newDrawable();

        spinnerDrawable.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            spin.setBackground(spinnerDrawable);

        }else{
            spin.setBackgroundDrawable(spinnerDrawable);
        }
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