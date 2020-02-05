package com.example.locationtrackingapp.data.pref;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;

import javax.inject.Inject;

public class SharedPrefHelper implements ISharedPrefHelper {

    private final SharedPreferences mPrefs;
    private final String PREF_WARNING_DISTANCE = "warning_distance";
    private String prefFileName = "mypf";

    @Inject
    public SharedPrefHelper(Context context) {
        mPrefs = context.getSharedPreferences(prefFileName, Context.MODE_PRIVATE);
    }


    @Override
    public void saveWarningDistance(String warningDistance) {
        mPrefs.edit().putString(PREF_WARNING_DISTANCE, warningDistance).apply();
    }

    @Override
    public String getWarningDistance() {
        return mPrefs.getString(PREF_WARNING_DISTANCE, null);
    }

    @Override
    public void saveStartLocation(Location startLocation) {

    }

    @Override
    public Location getStartLocation() {
        return null;
    }


}