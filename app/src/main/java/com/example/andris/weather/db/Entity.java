package com.example.andris.weather.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.RoomDatabase;

@Entity(tableName = "city")
class City{
    @PrimaryKey(autoGenerate = true) int id;
    @ColumnInfo(name = "name") String name;
    @ColumnInfo(name = "lon") String lon;
    @ColumnInfo(name = "lat") String lat;
    @ColumnInfo(name = "temper") String temper;
    @ColumnInfo(name = "humidity") String humidity;
    @ColumnInfo(name = "pressure") String pressure;

}
