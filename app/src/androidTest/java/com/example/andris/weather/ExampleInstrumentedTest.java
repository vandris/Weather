package com.example.andris.weather;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.andris.weather.ui.main.MainActivity;
import com.example.andris.weather.utils.EspressoUtils;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.andris.weather", appContext.getPackageName());
    }

    // Begépelés tesztelés
    @Test
    public void typing(){
        onView(withId(R.id.searchEditText)).perform(typeText("Szeged"), closeSoftKeyboard());
        onView(withText("Szeged")).perform(click());
    }

    // Sikertelen keresés
    @Test
    public void badSearching(){
        onView(withId(R.id.searchEditText)).perform(typeText("Szeged1"), closeSoftKeyboard());
        onView(withText("Szeged1")).perform(click());
        onView(withId(R.id.searchButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Weather1");
    }

    // Sikeres keresés
    @Test
    public void goodSearching(){
        onView(withId(R.id.searchEditText)).perform(typeText("Szeged"), closeSoftKeyboard());
        onView(withText("Szeged")).perform(click());
        onView(withId(R.id.searchButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Az általad választott település");
    }

    // Hozzáadás gomb megnyomása
    @Test
    public void pushAddButton(){
        onView(withId(R.id.addButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Új elem felvétele, szerkesztése");
    }

    // Hiányos adatokkal új település felvétele
    @Test
    public void addMissingInformation(){
        onView(withId(R.id.addButton)).perform(click());
        onView(withId(R.id.cityinfoEditText)).perform(typeText("Szeged1"), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Új elem felvétele, szerkesztése");
    }

    // Település felvétele sikeresen
    @Test
    public void addNewCity(){
        onView(withId(R.id.addButton)).perform(click());
        onView(withId(R.id.cityinfoEditText)).perform(typeText("Szeged1"), closeSoftKeyboard());
        onView(withId(R.id.coordinfoEditText)).perform(typeText("18, 20"), closeSoftKeyboard());
        onView(withId(R.id.tempinfoEditText)).perform(typeText("2"), closeSoftKeyboard());
        onView(withId(R.id.humidinfoEditText)).perform(typeText("2"), closeSoftKeyboard());
        onView(withId(R.id.pressureinfoEditText)).perform(typeText("1020"), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Weather1");
    }

    // Újonnan felvett település megtalálása
    @Test
    public void goodSearching1(){
        onView(withId(R.id.searchEditText)).perform(typeText("Szeged1"), closeSoftKeyboard());
        onView(withText("Szeged1")).perform(click());
        onView(withId(R.id.searchButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Az általad választott település");
    }

    // Település törlése
    @Test
    public void deleteCity(){
        onView(withId(R.id.searchEditText)).perform(typeText("Szeged1"), closeSoftKeyboard());
        onView(withText("Szeged1")).perform(click());
        onView(withId(R.id.searchButton)).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Weather1");
    }

    // Törölt település sikertelen keresése
    @Test
    public void badSearching1(){
        onView(withId(R.id.searchEditText)).perform(typeText("Szeged1"), closeSoftKeyboard());
        onView(withText("Szeged1")).perform(click());
        onView(withId(R.id.searchButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Weather1");
    }
}
