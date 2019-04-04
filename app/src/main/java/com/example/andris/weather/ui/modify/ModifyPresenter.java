package com.example.andris.weather.ui.modify;

import com.example.andris.weather.ui.Presenter;

public class ModifyPresenter extends Presenter<ModifyScreen> {

    private static ModifyPresenter instance = null;

    private ModifyPresenter() {
    }

    public static ModifyPresenter getInstance() {
        if (instance == null) {
            instance = new ModifyPresenter();
        }
        return instance;
    }

    @Override
    public void attachScreen(ModifyScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

}
