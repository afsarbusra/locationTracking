package com.example.locationtrackingapp.di.application;

import com.example.locationtrackingapp.di.GoogleSignInActivityModule;
import com.example.locationtrackingapp.di.LocationTrackingModule;
import com.example.locationtrackingapp.di.MainActivityModule;
import com.example.locationtrackingapp.di.PerActivity;
import com.example.locationtrackingapp.di.SettingsActivityModule;
import com.example.locationtrackingapp.ui.GoogleSignInActivity;
import com.example.locationtrackingapp.ui.LocationTracking;
import com.example.locationtrackingapp.ui.MainActivity;
import com.example.locationtrackingapp.ui.SettingsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Activityler için gerekli olan bağımlılıkları sağlayan modüllere enjektör sağlar.
 * <p>
 * Bu abstract sınıfa tüm Activity Moduller yazılmalıdır.
 */
@Module
public abstract class ActivityBuilder {
    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = {GoogleSignInActivityModule.class})
    abstract GoogleSignInActivity bindGoogleSignInActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = LocationTrackingModule.class)
    abstract LocationTracking bindLocationTracking();

    @PerActivity
    @ContributesAndroidInjector(modules = SettingsActivityModule.class)
    abstract SettingsActivity bindSettingsActivity();
}