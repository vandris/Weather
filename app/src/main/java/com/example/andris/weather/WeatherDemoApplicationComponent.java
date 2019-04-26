package com.example.andris.weather;


import com.example.andris.weather.interactor.cities.CitiesInteractor;
import com.example.andris.weather.ui.info.InfoPresenter;
import com.example.andris.weather.ui.main.MainActivity;

//@Singleton
//@Component(modules = {UIModule.class, NetworkModule.class,
//        InteractorModule.class})
public interface WeatherDemoApplicationComponent {

    void inject(MainActivity mainActivity);

    void inject(CitiesInteractor citiesInteractor);

    void inject(InfoPresenter citiesPresenter);

}
