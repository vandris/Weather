package com.example.andris.weather;

import android.content.Context;

import com.example.andris.weather.db.DBHelper;
import com.example.andris.weather.ui.main.MainActivity;

import org.junit.Test;

import androidx.test.core.app.ApplicationProvider;
//import static android.support.test.espresso.Espresso.onView;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void proba_teszt(){
        assertTrue(MainActivity.proba(0));
    }

    //private Context context = ApplicationProvider.getApplicationContext();
    private static final String FAKE_STRING = "True";


    @Test
    public void proba_teszt1(){
        MainActivity myObjectUnberTest = new MainActivity();

        String result = myObjectUnberTest.proba1(0);

        assertTrue(FAKE_STRING.equals(result));

    }

    public static String NUMBER_STRING = "0";
    @Test
    public void numberOfRows(){
        Context context = ApplicationProvider.getApplicationContext();
        String result = String.valueOf(DBHelper.getInstance(context).numberOfRows());
        assertTrue(NUMBER_STRING.equals(result));

    }
}