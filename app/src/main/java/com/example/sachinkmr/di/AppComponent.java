package com.example.sachinkmr.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sachinkumar05 on 3/28/2018.
 * Specifying the dependency provider.
 * It also contains the injection methods specifying the type of dependents which require
 * dependency.
 */

@Singleton @Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(MyApplication application);
    void inject(MainActivity mainActivity);
}
