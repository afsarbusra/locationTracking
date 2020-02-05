package com.example.locationtrackingapp.di.application;


import com.example.locationtrackingapp.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;

/**
 * Uygulama bağımlılıklarını inject eder.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ActivityBuilder.class})
public interface ApplicationComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {

    }

}
