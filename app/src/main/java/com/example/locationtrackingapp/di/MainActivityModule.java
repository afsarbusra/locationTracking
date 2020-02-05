package com.example.locationtrackingapp.di;


import androidx.appcompat.app.AppCompatActivity;

import com.example.locationtrackingapp.eventbus.AccountEvent;
import com.example.locationtrackingapp.ui.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * MainActivity için bağımlılıkları sağlar.
 */
@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {
    @Binds
    @PerActivity
    abstract AppCompatActivity activity(MainActivity mainActivity);

    @Provides
    @PerActivity
    static AccountEvent providesAccountEvent() {
        return new AccountEvent();
    }
}
