package com.test.trshuttlefinder;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.util.Log;
import android.widget.Switch;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


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

    public String databaseToString(int dbStringSwitch) {

     SQLiteDatabase db = getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " +TABLE_ROUTE);
            String query = "CREATE TABLE " +TABLE_ROUTE + "(" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_VAN + " INTEGER, " + COLUMN_ETD + " TEXT, " +COLUMN_BLDG + " TEXT, " +
                    COLUMN_FROM + " TEXT, " +COLUMN_VIA + " TEXT, " +COLUMN_TO + " TEXT " +
                    "); ";

            db.execSQL(query);

            //String manufacturer = Build.MANUFACTURER;
            String dbString = null;
            String dataValues = null;



                    //============================================================================================
                    // used for android
                    String path1 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Download";
                    //
                    File file = new File(path1 + "/shuttle.CSV");

                    String[] loadText = Load(file);
                    String sql ="INSERT INTO " + TABLE_ROUTE + " ("+COLUMN_VAN+","+COLUMN_ETD+","+COLUMN_BLDG+","+COLUMN_FROM+","+COLUMN_VIA+","+COLUMN_TO+") VALUES ";
                    String finalString = "";

                    int j = 0;
                    for (int i = 0; i < loadText.length; i++) {

                        if ((i % 501 == 0) && (i > 0)) {
                            sql += finalString + ";";
                            db.execSQL(sql);
                            sql ="INSERT INTO " + TABLE_ROUTE + " ("+COLUMN_VAN+","+COLUMN_ETD+","+COLUMN_BLDG+","+COLUMN_FROM+","+COLUMN_VIA+","+COLUMN_TO+") VALUES ";
                            j=1;
                            finalString="";
                        }


                            if (j == 0) {
                                    dbString = loadText[i] + " "; // + manufacturer;
                            } else if (j == 1) {
                                    finalString += " (" + loadText[i] + ")" + System.getProperty("line.separator");
                            } else {
                                   finalString += ", (" + loadText[i] + ")" + System.getProperty("line.separator");
                            }

                        j++;

                    }

                    sql += finalString;

                    //dataValues = finalString;

                    // used for android
                    //============================================================================================

      //String sql = "INSERT INTO " + TABLE_ROUTE + " ("+COLUMN_VAN+","+COLUMN_ETD+","+COLUMN_BLDG+","+COLUMN_FROM+","+COLUMN_VIA+","+COLUMN_TO+") VALUES " + dataValues;

     db.execSQL(sql);

        String query1=null;
        String select = null;
        //select="SELECT  'Van' || ' ' || van ||  start ||' - \t' || destination  || '\t\t(' || etd || bldg || ')'  AS one FROM ";
        select="SELECT  'Van' || ',' || van || ',' || start " +
                "||',' || destination  || ',' || etd ||  ',' || bldg " +
                "  AS one FROM ";

        switch (dbStringSwitch){
            case 1:
                if (ActivityTwo._From.length() >= 2 && ActivityTwo._To.length() >= 2 && ActivityTwo._Time.length() >= 2) {
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_ETD + " like \"" + ActivityTwo._Time.substring(0, 2) + "%\" AND " + COLUMN_FROM + " like \"%" + ActivityTwo._From + "%\" AND " + COLUMN_TO + " like \"%" + ActivityTwo._To + "%\";";
                } else if (ActivityTwo._From.length() < 2 && ActivityTwo._To.length() >= 2 && ActivityTwo._Time.length() >= 2) {
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_ETD + " like \"" + ActivityTwo._Time.substring(0, 2) + "%\" AND " + COLUMN_TO + " like \"%" + ActivityTwo._To + "%\";";
                } else if (ActivityTwo._From.length() < 2 && ActivityTwo._To.length() < 2 && ActivityTwo._Time.length() > 2) {
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_ETD + " like \"" + ActivityTwo._Time.substring(0, 2) + "%\"";
                } else if (ActivityTwo._From.length() >= 2 && ActivityTwo._To.length() < 2 && ActivityTwo._Time.length() >= 2) {
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_ETD + " like \"" + ActivityTwo._Time.substring(0, 2) + "%\" AND " + COLUMN_FROM + " like \"%" + ActivityTwo._From + "%\";";
                } else if (ActivityTwo._From.length() >= 2 && ActivityTwo._To.length() < 2 && ActivityTwo._Time.length() < 2) {
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_FROM + " like \"%" + ActivityTwo._From + "%\";";
                } else if (ActivityTwo._From.length() < 2 && ActivityTwo._To.length() >= 2 && ActivityTwo._Time.length() < 2) {
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_TO + " like \"%" + ActivityTwo._To + "%\";";
                } else if (ActivityTwo._From.length() >= 2 && ActivityTwo._To.length() >= 2 && ActivityTwo._Time.length() < 2) {
                    query1 = select + TABLE_ROUTE + " " + "WHERE " + COLUMN_FROM + " like \"%" + ActivityTwo._From + "%\" AND " + COLUMN_TO + " like \"%" + ActivityTwo._To + "%\";";
                } else if (ActivityTwo._From.length() < 2 && ActivityTwo._To.length() < 2 && ActivityTwo._Time.length() < 2) {
                    query1 = select + TABLE_ROUTE + ";";
                }
                dbString = dbString + System.getProperty("line.separator") + "Available Shuttles: ";
                break;
            case 2:
                select = "SELECT  distinct " + COLUMN_FROM + " FROM ";
                query1 = select + TABLE_ROUTE + " Order by " + COLUMN_FROM + " asc;";
                dbString="";
                break;
            case 3:
                select = "SELECT  distinct " + COLUMN_TO + " FROM ";
                query1 = select + TABLE_ROUTE + " Order by " + COLUMN_TO + " asc;";
                dbString="";
                break;
            default:

                break;
        }

            Cursor c  = db.rawQuery(query1, null);

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



    public static String repeat(char c,int i)
    {
        String tst = "";
        for(int j = 0; j < i; j++)
        {
            tst = tst+c;
        }
        return tst;
    }

    public  String[] Load(File file)
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
    }


}
