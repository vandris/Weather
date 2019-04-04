package com.example.andris.weather.ui.info;
import com.example.andris.weather.ui.Presenter;

public class InfoPresenter extends Presenter<InfoScreen> {

    private static InfoPresenter instance = null;

    private InfoPresenter() {
            }

    public static InfoPresenter getInstance() {
            if (instance == null) {
            instance = new InfoPresenter();
            }
            return instance;
            }

    @Override
    public void attachScreen(InfoScreen screen) { super.attachScreen(screen);  }

    @Override
    public void detachScreen() { super.detachScreen(); }
}
