package com.example.locationtrackingapp.di.application;

import android.app.Application;
import android.content.Context;

import com.example.locationtrackingapp.App;
import com.example.locationtrackingapp.data.network.EventBus;
import com.example.locationtrackingapp.data.network.IEventBus;
import com.example.locationtrackingapp.data.pref.ISharedPrefHelper;
import com.example.locationtrackingapp.data.pref.SharedPrefHelper;

import javax.inject.Singleton;
import dagger.Binds;
import dagger.Module;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Uygulama genelinde kullanılacak olan sınıfların bağımlılıklarını sağlar
 */
@Module(includes = AndroidSupportInjectionModule.class)
abstract class ApplicationModule {

    /**
     * Application contexti inject etmek için. Uygulama genelinde kullanılıyor.
     *
     * @param application
     * @return
     */
    @Binds
    abstract Context bindContext(Application application);

    @Binds
    @Singleton
    abstract Application application(App app);

    @Binds
    @Singleton
    abstract IEventBus providesEventBus(EventBus eventBus);

    @Binds
    @Singleton
    abstract ISharedPrefHelper providesSharedPref(SharedPrefHelper sharedPrefHelper);

}
