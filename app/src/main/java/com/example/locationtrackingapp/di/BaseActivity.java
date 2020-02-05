
package com.example.locationtrackingapp.di;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import dagger.android.AndroidInjection;

/**
 * Abstract Activity for all Activities to extend.
 * <p>
 * DEPENDENCY INJECTION
 * <p>
 * Bu abstract sınıfı tüm activity sınıflar miras edinmelidir. Amacımız, activity depenceny inject i sağlamaktır.
 * Daha sonra tüm activitylerin miras etmesini istediğimiz bir özellik olduğunda burada değişiklik yapmak yeterli oalcaktır.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }


}
