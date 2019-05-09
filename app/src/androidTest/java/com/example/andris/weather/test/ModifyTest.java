package com.example.andris.weather.test;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.andris.weather.R;
import com.example.andris.weather.ui.main.MainActivity;
import com.example.andris.weather.ui.modify.ModifyActivity;
import com.example.andris.weather.utils.EspressoUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.example.andris.weather.utils.AndroidTestUtils.setTestInjector;

@RunWith(AndroidJUnit4.class)
public class ModifyTest {

    public static final String CITY = "Szeged";

    public ModifyTest(){
        //super(ModifyActivity.class);

    }

    @Rule
    public ActivityTestRule<ModifyActivity> mActivityRule = new ActivityTestRule<ModifyActivity>(ModifyActivity.class){
        @Override
        protected Intent getActivityIntent() {
            InstrumentationRegistry.getTargetContext();
            //String res = "9;Szeged;20.15;46.25;25;61;1016";
            String res = "";
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.putExtra(MainActivity.EXTRA_MESSAGE, res);
            return intent;
        }
    };

    @Before
    public void setUp(){
        setTestInjector();
    }

    @Test
    public void addMisingDatas(){
        onView(withId(com.example.andris.weather.R.id.cityinfoEditText)).perform(typeText("Szeged1"), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Új elem felvétele, szerkesztése");
    }

    @Test
    public void addNewCity(){
        onView(withId(R.id.cityinfoEditText)).perform(typeText("Szeged1"), closeSoftKeyboard());
        onView(withId(R.id.coordinfoEditText)).perform(typeText("18, 20"), closeSoftKeyboard());
        onView(withId(R.id.tempinfoEditText)).perform(typeText("2"), closeSoftKeyboard());
        onView(withId(R.id.humidinfoEditText)).perform(typeText("2"), closeSoftKeyboard());
        onView(withId(R.id.pressureinfoEditText)).perform(typeText("1020"), closeSoftKeyboard());
        onView(withId(R.id.saveButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Weather1");
    }

}
