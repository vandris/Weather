package com.example.andris.weather.mock;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "city_sqlite.db";
    public static final String TABLE_NAME = "city";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_LON = "lon";
    public static final String COLUMN_LAT = "lat";
    public static final String COLUMN_TEMPER = "temper";
    public static final String COLUMN_HUMIDITY = "humidity";
    public static final String COLUMN_PRESSURE = "pressure";

    private static com.example.andris.weather.mock.DBHelper instance = null;

    private DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    // static method to create instance of Singleton class
    public static com.example.andris.weather.mock.DBHelper getInstance(Context context)
    {
        if (instance == null)
            instance = new com.example.andris.weather.mock.DBHelper(context);

        return instance;
    }

    //public DBHelper(Context context){
    //    super(context, DATABASE_NAME, null, 1);
    //}

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table city " +
                "(id integer primary key, name text,lon text,lat text,temper text,humidity text,pressure text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS city");
        onCreate(db);
    }

    public boolean insertCity(Integer id, String name, String lon, String lat, String temper, String humidity, String pressure){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("lon", lon);
        contentValues.put("lat", lat);
        contentValues.put("temper", temper);
        contentValues.put("humidity", humidity);
        contentValues.put("pressure", pressure);
        db.insert("city", null, contentValues);
        //db.update("city", contentValues, "id = ? ", new String[] { Integer.toString(id) });
        return true;
    }

    public boolean updateCity(Integer id, String name, String lon, String lat, String temper, String humidity, String pressure){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("lon", lon);
        contentValues.put("lat", lat);
        contentValues.put("temper", temper);
        contentValues.put("humidity", humidity);
        contentValues.put("pressure", pressure);
        db.update("city", contentValues, "id = ? ", new String[] { Integer.toString(id) });
        return true;
    }

    public Integer deleteCity(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("city", "id = ? ", new String[]{ Integer.toString(id) });
    }

    public Cursor getData(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from city where name = \''" + name + "\'", null);
        return res;
    }

    public String getDataString(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from city where name = \'" + name + "\'", null);
        String str = "";
        if(res.getCount() > 0) {
            res.moveToFirst();
            str += res.getString(res.getColumnIndex(COLUMN_ID)) + ";";
            str += res.getString(res.getColumnIndex(COLUMN_NAME)) + ";";
            str += res.getString(res.getColumnIndex(COLUMN_LON)) + ";";
            str += res.getString(res.getColumnIndex(COLUMN_LAT)) + ";";
            str += res.getString(res.getColumnIndex(COLUMN_TEMPER)) + ";";
            str += res.getString(res.getColumnIndex(COLUMN_HUMIDITY)) + ";";
            str += res.getString(res.getColumnIndex(COLUMN_PRESSURE));
        }else
            str = "";
        return str;
    }

    public int numberOfRows(){
        SQLiteDatabase db = this.getReadableDatabase();
        int numRows = (int) DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        return numRows;
    }

    public int maxID(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select max(id) as id from city", null);
        if(res.getCount() > 0) {
            res.moveToFirst();
            return Integer.parseInt(res.getString(res.getColumnIndex(COLUMN_ID)));
        }
        return 0;
    }

    public ArrayList<String> getAllCities(){
        ArrayList<String> array_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from city", null);
        res.moveToFirst();

        while(res.isAfterLast() == false){
            array_list.add(res.getString(res.getColumnIndex(COLUMN_NAME)));
            array_list.add(res.getString(res.getColumnIndex(COLUMN_LON)));
            array_list.add(res.getString(res.getColumnIndex(COLUMN_LAT)));
            array_list.add(res.getString(res.getColumnIndex(COLUMN_TEMPER)));
            array_list.add(res.getString(res.getColumnIndex(COLUMN_HUMIDITY)));
            array_list.add(res.getString(res.getColumnIndex(COLUMN_PRESSURE)));
            res.moveToNext();
        }
        return array_list;
    }
}
