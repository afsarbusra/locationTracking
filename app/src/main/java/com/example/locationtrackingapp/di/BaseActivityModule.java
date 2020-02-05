package com.example.locationtrackingapp.di;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;


/**
 * Provides base activity dependencies.
 * <p>
 * DEPENDENCY INJECTION
 * <p>
 * Activitylerin temel bağımlılığını sağlar. Bu modül tüm activitylerin modüllerine include edilmelidir.
 */
@Module
public abstract class BaseActivityModule {

}
