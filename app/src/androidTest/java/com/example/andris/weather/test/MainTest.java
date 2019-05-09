package com.example.andris.weather.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.andris.weather.R;
import com.example.andris.weather.ui.main.MainActivity;
import com.example.andris.weather.utils.EspressoUtils;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.andris.weather.utils.AndroidTestUtils.setTestInjector;


@RunWith(AndroidJUnit4.class)
public class MainTest {

    public static final String CITY = "Szeged";

    public MainTest() {
        //super(MainActivity.class);
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp(){
        setTestInjector();
    }

    @Test
    public void testNavigateToInfoActivity(){
        onView(withId(com.example.andris.weather.R.id.searchEditText)).perform(typeText("Szeged"), closeSoftKeyboard());
        onView(withText("Szeged")).perform(click());
        onView(withId(R.id.searchButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Az általad választott település");
    }
    @Test
    public void testNavigateToModifyActivity(){
        onView(withId(R.id.addButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Új elem felvétele, szerkesztése");
    }
}
