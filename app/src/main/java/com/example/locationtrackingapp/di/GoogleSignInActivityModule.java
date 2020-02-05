package com.example.locationtrackingapp.di;

import androidx.appcompat.app.AppCompatActivity;

import com.example.locationtrackingapp.eventbus.AccountEvent;
import com.example.locationtrackingapp.ui.MainActivity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * GoogleSignInActivity için bağımlılıkları sağlar.
 */
@Module(includes = BaseActivityModule.class)
public abstract class GoogleSignInActivityModule {
    @Binds
    @PerActivity
    abstract AppCompatActivity activity(MainActivity mainActivity);

    @Provides
    @PerActivity
    static AccountEvent providesAccountEvent() {
        return new AccountEvent();
    }
}
