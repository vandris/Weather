package com.example.andris.weather.test;

import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.andris.weather.R;
import com.example.andris.weather.ui.info.InfoActivity;
import com.example.andris.weather.ui.main.MainActivity;
import com.example.andris.weather.ui.modify.ModifyActivity;
import com.example.andris.weather.utils.EspressoUtils;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.example.andris.weather.utils.AndroidTestUtils.setTestInjector;

@RunWith(AndroidJUnit4.class)
public class InfoTest {

    public static final String CITY = "Szeged";

    public InfoTest(){
        //super(InfoActivity.class);
    }

    @Rule
    public ActivityTestRule<InfoActivity> mActivityRule = new ActivityTestRule<InfoActivity>(InfoActivity.class){
        @Override
        protected Intent getActivityIntent() {
            InstrumentationRegistry.getTargetContext();
            String res = "9;Szeged;20.15;46.25;25;61;1016";
            //String res = "";
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
    public void checkDatas(){
        onView(withText("Szeged")).perform(click());
        onView(withText("N 20.15, E 46.25")).perform(click());
        onView(withText("25 °C")).perform(click());
        onView(withText("61 %")).perform(click());
        onView(withText("1016 hPa")).perform(click());
    }

    @Test
    public void testNavigateToModifyActivity(){
        onView(withId(R.id.modifyButton)).perform(click());
        EspressoUtils.matchToolbarTitle("Új elem felvétele, szerkesztése");
    }

}
