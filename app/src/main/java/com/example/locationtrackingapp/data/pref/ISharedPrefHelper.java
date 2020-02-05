package com.example.locationtrackingapp.data.pref;

import android.location.Location;

public interface ISharedPrefHelper {

    void saveWarningDistance(String warningDistance);

    String getWarningDistance();

    void saveStartLocation(Location startLocation);

    Location getStartLocation();
}
