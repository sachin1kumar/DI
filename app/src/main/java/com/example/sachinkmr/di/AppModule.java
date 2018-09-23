package com.example.sachinkmr.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by sachinkumar05 on 3/28/2018.
 * It is the dependency provider which provides the dependency to the dependent.
 */

@Module
public class AppModule {

    private final MyApplication application;

    public AppModule(MyApplication app){
        this.application = app;
    }

    @Provides @Singleton
    Context providesAppContext(){
        return application;
    }

    @Provides @Singleton
    SharedPreferences proivdeSharedPreference(Context context){
        return context.getSharedPreferences("MyPref",Context.MODE_PRIVATE);
    }

    @Provides
    Resources getResources(Context context){
        return context.getResources();
    }
}
