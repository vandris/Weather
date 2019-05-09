package com.example.andris.weather;

import android.content.Context;

import com.example.andris.weather.di.Network;
import com.example.andris.weather.ui.UIModule;

import java.util.concurrent.Executor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AndroidTestModule {
    private final UIModule UIModule;

    public AndroidTestModule(Context context) {
        this.UIModule = new UIModule(context);
    }

    @Provides
    public Context provideContext() {
        return UIModule.provideContext();
    }

    @Provides
    @Singleton
    @Network
    public Executor provideNetworkExecutor() {
        return UIModule.provideNetworkExecutor();
    }
}
