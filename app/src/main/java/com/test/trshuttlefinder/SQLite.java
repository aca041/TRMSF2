package com.test.trshuttlefinder;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

//Import for android
/*import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;*/


public class SQLite extends SQLiteOpenHelper  {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NAME ="route.db";
    public static final String TABLE_ROUTE = "route";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_VAN = "van";
    public static final String COLUMN_ETD = "etd";
    public static final String COLUMN_BLDG = "bldg";
    public static final String COLUMN_FROM = "start";
    public static final String COLUMN_VIA = "via";
    public static final String COLUMN_TO = "destination";




    public SQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

   }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_ROUTE);
        onCreate(db);
    }

    public String databaseToString() {

     SQLiteDatabase db = getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " +TABLE_ROUTE);
            String query = "CREATE TABLE " +TABLE_ROUTE + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_VAN + " INTEGER, " + COLUMN_ETD + " TEXT, " +COLUMN_BLDG + " TEXT, " +
                    COLUMN_FROM + " TEXT, " +COLUMN_VIA + " TEXT, " +COLUMN_TO + " TEXT " +
                    "); ";

            db.execSQL(query);

        //============================================================================================
        //used for android
        /*String path1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download";
        File file = new File (path1 + "/shuttle.CSV");

        String [] loadText = Load(file);

        String finalString = "";
        String dbString = null;
        int j = 0;
        for (int i = 0; i < loadText.length; i++)
        {
            j = i;

            if(j == 0)
            {
                dbString=loadText[i];
            }
            else if (j==1){
                finalString += " (" + loadText[i] + ")" + System.getProperty("line.separator");
            }
            else
            {
                finalString += ", (" + loadText[i] + ")" + System.getProperty("line.separator");
            }

        }

        String dataValues = finalString;
        //============================================================================================*/

        //============================================================================================
        //used for blackberry
        String dbString= "Effective 07/01/15";

        String dataValues = "('7','00:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('6','00:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('3','00:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','00:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','00:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('6','00:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','00:15','8/10','MH','MM','PRO-P')"+ System.getProperty("line.separator")
                +",('14','00:15','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('4','00:15','8/10','MH','*','MM')"+ System.getProperty("line.separator")
                +",('14','00:15','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('7','00:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','00:40','18/20','MH','SHELL','PRO-P')"+ System.getProperty("line.separator")
                +",('5','00:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('6','00:40','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','00:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('3','00:40','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','00:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','00:45','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('7','01:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('6','01:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('3','01:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','01:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','01:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('6','01:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','01:15','8/10','MH','MM','PRO-P')"+ System.getProperty("line.separator")
                +",('4','01:15','8/10','MH','*','MM')"+ System.getProperty("line.separator")
                +",('7','01:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','01:40','18/20','MH','SHELL','PRO-P')"+ System.getProperty("line.separator")
                +",('5','01:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('6','01:40','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','01:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('3','01:40','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','01:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','01:45','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('7','02:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('6','02:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('3','02:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','02:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','02:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('6','02:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','02:15','8/10','MH','MM','PRO-P')"+ System.getProperty("line.separator")
                +",('4','02:15','8/10','MH','*','MM')"+ System.getProperty("line.separator")
                +",('7','02:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','02:40','18/20','MH','SHELL','PRO-P')"+ System.getProperty("line.separator")
                +",('5','02:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('6','02:40','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','02:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('3','02:40','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','02:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','02:45','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('7','03:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('6','03:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('3','03:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','03:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','03:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('6','03:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','03:15','8/10','MH','MM','PRO-P')"+ System.getProperty("line.separator")
                +",('4','03:15','8/10','MH','*','MM')"+ System.getProperty("line.separator")
                +",('7','03:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','03:40','18/20','MH','SHELL','PRO-P')"+ System.getProperty("line.separator")
                +",('5','03:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('6','03:40','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','03:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('3','03:40','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','03:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','03:45','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('7','04:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('6','04:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('3','04:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','04:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','04:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('6','04:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','04:15','8/10','MH','MM','PRO-P')"+ System.getProperty("line.separator")
                +",('4','04:15','8/10','MH','*','MM')"+ System.getProperty("line.separator")
                +",('7','04:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','04:40','18/20','MH','SHELL','PRO-P')"+ System.getProperty("line.separator")
                +",('5','04:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('6','04:40','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','04:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('3','04:40','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','04:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','04:45','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('6','05:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('3','05:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','05:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('8','05:10','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('12','05:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('6','05:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','05:15','8/10','MH','MM','PRO-P')"+ System.getProperty("line.separator")
                +",('14','05:15','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('7','05:15','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('4','05:15','8/10','MH','*','MM')"+ System.getProperty("line.separator")
                +",('14','05:15','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('2','05:25','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('8','05:30','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('4','05:35','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('7','05:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('14','05:35','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','05:40','18/20','MH','SHELL','PRO-P')"+ System.getProperty("line.separator")
                +",('5','05:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('10','05:40','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('12','05:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('3','05:40','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','05:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('6','05:45','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('4','06:05','8/10','MH','MM','PRO-P')"+ System.getProperty("line.separator")
                +",('2','06:05','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('4','06:05','8/10','MH','*','MM')"+ System.getProperty("line.separator")
                +",('6','06:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('10','06:10','18/20','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','06:10','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('3','06:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','06:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('8','06:10','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('12','06:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('6','06:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('10','06:10','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('7','06:15','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('14','06:15','3WSQ','MH','','G4')"+ System.getProperty("line.separator")
                +",('8','06:30','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('2','06:35','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('4','06:35','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('7','06:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('14','06:35','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','06:40','18/20','MH','SHELL','PRO-P')"+ System.getProperty("line.separator")
                +",('5','06:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','06:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('6','06:40','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('9','06:40','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('12','06:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('3','06:40','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','06:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('10','06:45','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('14','07:05','3WSQ','MH','G4','PRO-P')"+ System.getProperty("line.separator")
                +",('2','07:05','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('7','07:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('14','07:05','3WSQ','MH','*','G4')"+ System.getProperty("line.separator")
                +",('6','07:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','07:10','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('5','07:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('8','07:10','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('9','07:10','18/20','MH','','SM')"+ System.getProperty("line.separator")
                +",('6','07:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('10','07:15','18/20','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('4','07:15','8/10','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('10','07:15','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('3','07:20','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('12','07:20','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('2','07:35','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('7','07:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('14','07:35','3WSQ','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','07:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','07:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('8','07:40','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('9','07:40','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('5','07:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('2','08:05','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('7','08:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('14','08:05','3WSQ','MH','','G4')"+ System.getProperty("line.separator")
                +",('9','08:10','18/20','MH','SHELL','PRO-P')"+ System.getProperty("line.separator")
                +",('3','08:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('4','08:10','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('6','08:10','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('10','08:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('12','08:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('9','08:10','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('1','08:20','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('5','08:20','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('8','08:20','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('2','08:35','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('7','08:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('14','08:35','3WSQ','G4','','MH')"+ System.getProperty("line.separator")
                +",('6','08:40','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','08:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('6','08:40','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','08:50','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('5','08:50','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('2','09:05','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('7','09:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('1','09:10','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('3','09:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('4','09:10','8/10','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('8','09:10','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('9','09:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('12','09:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('14','09:10','3WSQ','MH','','G4')"+ System.getProperty("line.separator")
                +",('6','09:20','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('5','09:30','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('2','09:35','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('7','09:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('1','09:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('6','09:50','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('6','09:50','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('2','10:05','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('7','10:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('14','10:05','3WSQ','G4','','MH')"+ System.getProperty("line.separator")
                +",('5','10:10','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','10:10','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('3','10:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('12','10:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','10:10','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('6','10:30','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('2','10:35','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('7','10:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('1','10:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('3','10:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('12','10:40','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('5','10:50','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('14','10:55','3WSQ','MH','','G4')"+ System.getProperty("line.separator")
                +",('2','11:05','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('7','11:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('6','11:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','11:10','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('6','11:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','11:15','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','11:20','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('3','11:20','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('12','11:20','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','11:20','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('2','11:35','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('7','11:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('1','11:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('6','11:40','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('4','11:55','8/10','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('2','12:05','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('7','12:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('6','12:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('6','12:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','12:20','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('4','12:25','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('6','12:30','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('9','12:30','18/20','G4','','MH')"+ System.getProperty("line.separator")
                +",('7','12:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('5','12:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('5','12:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('7','13:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('6','13:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','13:10','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('5','13:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('9','13:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('6','13:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('3','13:20','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('8','13:20','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('10','13:20','18/20','G4','','MH')"+ System.getProperty("line.separator")
                +",('10','13:20','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('12','13:20','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('2','13:25','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('14','13:25','3WSQ','G4','','MH')"+ System.getProperty("line.separator")
                +",('6','13:30','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('7','13:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('5','13:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','13:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('9','13:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','13:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('3','13:50','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('8','13:50','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('12','13:50','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('14','13:55','3WSQ','MH','','G4')"+ System.getProperty("line.separator")
                +",('2','14:05','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('4','14:05','8/10','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('7','14:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('6','14:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('9','14:10','18/20','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','14:10','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('5','14:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('6','14:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('9','14:10','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('3','14:20','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('8','14:20','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('12','14:20','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('14','14:25','3WSQ','G4','','MH')"+ System.getProperty("line.separator")
                +",('2','14:35','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('7','14:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('5','14:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','14:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('6','14:40','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('9','14:40','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('5','14:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','14:45','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('3','14:50','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('12','14:50','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('2','15:05','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('7','15:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('10','15:05','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('6','15:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','15:10','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('5','15:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('8','15:10','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('6','15:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','15:15','8/10','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('14','15:15','3WSQ','MH','','G4')"+ System.getProperty("line.separator")
                +",('3','15:20','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('12','15:20','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('2','15:35','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('7','15:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('10','15:35','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('5','15:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','15:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('6','15:40','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('8','15:40','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('5','15:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('14','15:45','3WSQ','G4','','MH')"+ System.getProperty("line.separator")
                +",('4','15:55','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('7','16:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('10','16:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('10','16:05','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('6','16:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','16:10','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('2','16:10','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('3','16:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('5','16:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('8','16:10','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('9','16:10','18/20','MH','','G4')"+ System.getProperty("line.separator")
                +",('12','16:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('6','16:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('14','16:15','3WSQ','MH','','G4')"+ System.getProperty("line.separator")
                +",('4','16:25','8/10','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('7','16:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('10','16:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('10','16:35','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('5','16:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','16:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('2','16:40','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('3','16:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('6','16:40','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('8','16:40','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('9','16:40','18/20','G4','','MH')"+ System.getProperty("line.separator")
                +",('12','16:40','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('5','16:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('14','16:45','3WSQ','G4','','MH')"+ System.getProperty("line.separator")
                +",('4','17:05','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('7','17:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('6','17:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('1','17:10','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('2','17:10','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('3','17:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('8','17:10','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('9','17:10','18/20','MH','','SM')"+ System.getProperty("line.separator")
                +",('10','17:10','18/20','MH','','SM')"+ System.getProperty("line.separator")
                +",('10','17:10','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('12','17:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('6','17:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('14','17:15','3WSQ','MH','','G4')"+ System.getProperty("line.separator")
                +",('5','17:20','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('7','17:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('1','17:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('2','17:40','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('8','17:40','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('9','17:40','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('10','17:40','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('10','17:40','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('14','17:45','3WSQ','G4','','MH')"+ System.getProperty("line.separator")
                +",('5','17:50','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('3','17:50','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('6','17:50','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','17:50','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('5','17:50','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','18:05','8/10','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('7','18:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('1','18:10','8/10','SL1','','MH')"+ System.getProperty("line.separator")
                +",('2','18:10','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('8','18:10','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('10','18:10','18/20','MH','','SM')"+ System.getProperty("line.separator")
                +",('10','18:10','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('14','18:15','3WSQ','MH','','G4')"+ System.getProperty("line.separator")
                +",('6','18:20','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('9','18:20','18/20','MH','','SM')"+ System.getProperty("line.separator")
                +",('6','18:20','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','18:30','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('7','18:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','18:40','18/20','MH','SHELL','PRO-P')"+ System.getProperty("line.separator")
                +",('1','18:40','8/10','MH','','SL1')"+ System.getProperty("line.separator")
                +",('2','18:40','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('10','18:40','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','18:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('3','18:40','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','19:05','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('7','19:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('10','19:10','18/20','MH','G4','PRO-P')"+ System.getProperty("line.separator")
                +",('5','19:10','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('9','19:10','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('15','19:10','3WSQ','MH','','SM')"+ System.getProperty("line.separator")
                +",('10','19:10','18/20','MH','*','G4')"+ System.getProperty("line.separator")
                +",('5','19:10','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('8','19:15','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('2','19:20','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('6','19:20','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('7','19:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','19:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('9','19:40','18/20','MH','','G4')"+ System.getProperty("line.separator")
                +",('10','19:40','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','19:40','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('2','19:50','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('4','20:05','8/10','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('7','20:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('14','20:05','3WSQ','G4','','MH')"+ System.getProperty("line.separator")
                +",('6','20:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('5','20:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('8','20:10','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('9','20:10','18/20','G4','','MH')"+ System.getProperty("line.separator")
                +",('10','20:10','18/20','MH','','G4')"+ System.getProperty("line.separator")
                +",('6','20:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('2','20:20','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('3','20:20','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('12','20:20','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','20:30','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('5','20:30','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('7','20:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('14','20:35','3WSQ','MH','','G4')"+ System.getProperty("line.separator")
                +",('8','20:40','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('9','20:40','18/20','MH','','G4')"+ System.getProperty("line.separator")
                +",('10','20:40','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('4','20:45','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('2','20:50','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('6','20:50','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','21:00','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('12','21:00','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('7','21:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('14','21:05','3WSQ','G4','','MH')"+ System.getProperty("line.separator")
                +",('5','21:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('8','21:10','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('9','21:10','18/20','G4','','MH')"+ System.getProperty("line.separator")
                +",('10','21:10','18/20','MH','','G4')"+ System.getProperty("line.separator")
                +",('4','21:15','8/10','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('6','21:20','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('2','21:20','18/20','MH','','SL1')"+ System.getProperty("line.separator")
                +",('6','21:20','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('7','21:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('14','21:35','3WSQ','MH','','G4')"+ System.getProperty("line.separator")
                +",('5','21:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('3','21:40','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('8','21:40','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('9','21:40','18/20','MH','','G4')"+ System.getProperty("line.separator")
                +",('12','21:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','21:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('2','21:50','18/20','SL1','','MH')"+ System.getProperty("line.separator")
                +",('6','21:50','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('10','21:50','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('4','21:55','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('7','22:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('14','22:05','3WSQ','G4','','MH')"+ System.getProperty("line.separator")
                +",('3','22:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('8','22:10','8/10','MH','','G4')"+ System.getProperty("line.separator")
                +",('9','22:10','18/20','G4','','MH')"+ System.getProperty("line.separator")
                +",('12','22:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('6','22:20','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('2','22:20','18/20','MH','','SM')"+ System.getProperty("line.separator")
                +",('5','22:20','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('6','22:20','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','22:25','8/10','MH','MM','PRO-P')"+ System.getProperty("line.separator")
                +",('4','22:25','8/10','MH','*','MM')"+ System.getProperty("line.separator")
                +",('7','22:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','22:40','18/20','MH','SHELL','PRO-P')"+ System.getProperty("line.separator")
                +",('8','22:40','8/10','G4','','MH')"+ System.getProperty("line.separator")
                +",('9','22:40','18/20','MH','','G4')"+ System.getProperty("line.separator")
                +",('12','22:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('3','22:40','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','22:50','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('2','22:50','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('6','22:50','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('5','22:50','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','22:55','8/10','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('7','23:05','18/20','MH','','SHELL')"+ System.getProperty("line.separator")
                +",('8','23:10','8/10','MH','SHELL','G4')"+ System.getProperty("line.separator")
                +",('6','23:10','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('3','23:10','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('5','23:10','8/10','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('9','23:10','18/20','G4','','MH')"+ System.getProperty("line.separator")
                +",('12','23:10','18/20','MH','','PRO-P')"+ System.getProperty("line.separator")
                +",('8','23:10','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('6','23:10','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('10','23:15','18/20','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('14','23:15','3WSQ','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('10','23:15','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('14','23:15','3WSQ','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('2','23:20','18/20','MH','','SM')"+ System.getProperty("line.separator")
                +",('4','23:25','8/10','MH','MM','PRO-P')"+ System.getProperty("line.separator")
                +",('4','23:25','8/10','MH','*','MM')"+ System.getProperty("line.separator")
                +",('7','23:35','18/20','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('14','23:35','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('3','23:40','18/20','MH','SHELL','PRO-P')"+ System.getProperty("line.separator")
                +",('5','23:40','8/10','MH','SHELL','SM')"+ System.getProperty("line.separator")
                +",('6','23:40','3WSQ','SHELL','','MH')"+ System.getProperty("line.separator")
                +",('12','23:40','18/20','PRO-P','','MH')"+ System.getProperty("line.separator")
                +",('3','23:40','18/20','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('5','23:40','8/10','MH','*','SHELL')"+ System.getProperty("line.separator")
                +",('4','23:55','8/10','PRO-P','','MH')"+ System.getProperty("line.separator");
        //============================================================================================
        String sql = "INSERT INTO " + TABLE_ROUTE + " ("+COLUMN_VAN+","+COLUMN_ETD+","+COLUMN_BLDG+","+COLUMN_FROM+","+COLUMN_VIA+","+COLUMN_TO+") VALUES "
             + dataValues;

     db.execSQL(sql);

        String query1=null;
        String select = null;
        //select="SELECT  'Van' || ' ' || van ||  start ||' - \t' || destination  || '\t\t(' || etd || bldg || ')'  AS one FROM ";
        select="SELECT  'Van' || ',' || van || ',' || start " +
                "||',' || destination  || ',' || etd ||  ',' || bldg " +
                "  AS one FROM ";

            if (ActivityTwo._From.length() >= 2 && ActivityTwo._To.length() >= 2 && ActivityTwo._Time.length() >= 2){
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_ETD + " like \"" + ActivityTwo._Time.substring(0,2) + "%\" AND "+ COLUMN_FROM + " like \"%"+ ActivityTwo._From +"%\" AND " +COLUMN_TO + " like \"%" + ActivityTwo._To + "%\";" ;
            }
            else if (ActivityTwo._From.length() < 2 && ActivityTwo._To.length() >= 2 && ActivityTwo._Time.length() >= 2){
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_ETD + " like \"" + ActivityTwo._Time.substring(0,2) + "%\" AND "+ COLUMN_TO + " like \"%" + ActivityTwo._To + "%\";" ;
            }
            else if (ActivityTwo._From.length() < 2 && ActivityTwo._To.length() < 2 && ActivityTwo._Time.length() > 2){
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_ETD + " like \"" + ActivityTwo._Time.substring(0,2) + "%\"";
            }

            else if (ActivityTwo._From.length() >= 2 && ActivityTwo._To.length() < 2 && ActivityTwo._Time.length() >= 2){
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_ETD + " like \"" + ActivityTwo._Time.substring(0,2) + "%\" AND "+ COLUMN_FROM + " like \"%"+ ActivityTwo._From +"%\";" ;
            }
            else if (ActivityTwo._From.length() >= 2 && ActivityTwo._To.length() < 2 && ActivityTwo._Time.length() < 2){
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_FROM + " like \"%" + ActivityTwo._From + "%\";" ;
            }
            else if (ActivityTwo._From.length() < 2 && ActivityTwo._To.length() >= 2 && ActivityTwo._Time.length() < 2){
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_TO + " like \"%"+ ActivityTwo._To +"%\";" ;
            }
            else if (ActivityTwo._From.length() >= 2 && ActivityTwo._To.length() >= 2 && ActivityTwo._Time.length() < 2){
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_FROM + " like \"%"+ ActivityTwo._From +"%\" AND " +COLUMN_TO + " like \"%" + ActivityTwo._To + "%\";" ;
            }
            else if (ActivityTwo._From.length() < 2 && ActivityTwo._To.length() < 2 && ActivityTwo._Time.length() < 2){
                    query1 = select  + TABLE_ROUTE + ";" ;
            }


            Cursor c  = db.rawQuery(query1, null);

            dbString = dbString + System.getProperty("line.separator") + "Available Shuttles: ";

            if (c.moveToFirst()) {
                    do {
                            for (int i=0; i<c.getColumnCount(); i++) {
                                    //dbString += System.getProperty("line.separator") + c.getString(i).replace("|", "\t");
                                    dbString += System.getProperty("line.separator")  + c.getString(i);
                            }


                    } while (
                            c.moveToNext()
                            );
            }
            db.close();


            return dbString;
    }

    //============================================================================================
    //used for android
    /*public static String[] Load(File file)
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl=0;
        try
        {
            while ((test=br.readLine()) != null)
            {
                anzahl++;
            }
        }
        catch (IOException e) {e.printStackTrace();}

        try
        {
            fis.getChannel().position(0);
        }
        catch (IOException e) {e.printStackTrace();}

        String[] array = new String[anzahl];

        String line;

        int i = 0;
        String line1 = "";


        String stringTemp = "VAN,ROUTE,ETD,BLDG,FROM,VIA,TO";
        String[] arrLine;

        try
        {
            while((line=br.readLine())!=null)
            {
                arrLine = line.split(",");

                if (i == 0) {
                    array[i] = arrLine[0];
                }
                else{

                    stringTemp=arrLine[0];
                    line1 = "'" + stringTemp + "'";

                    stringTemp=arrLine[1];
                    line1 += ",'" + stringTemp + "'";

                    stringTemp=arrLine[2];
                    line1 += ",'" + stringTemp + "'";

                    stringTemp=arrLine[3];
                    line1 += ",'" + stringTemp + "'";

                    stringTemp=arrLine[4];
                    line1 += ",'" + stringTemp + "'";

                    stringTemp=arrLine[5];
                    line1 += ",'" + stringTemp + "'";

                    array[i] = line1;

                }
                i++;
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return array;
    }*/
    //============================================================================================


}
