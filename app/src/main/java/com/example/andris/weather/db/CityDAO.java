package com.example.andris.weather.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import java.util.List;
import retrofit2.http.Query;

@Dao
public interface CityDAO {

    //@Query("SELECT * FROM city WHERE name= \'Szeged\'")
    //public List<City> getCity();
    //@Query("SELECT * FROM city")
    //public List<City> getAllGrades();
    //@Query("SELECT * FROM city WHERE name > :city")
    //public List<City> getSpecificCity(String city);
    @Insert
    public void insertGrades(City city);
    @Delete
    public void deleteGrade(City city);

}
