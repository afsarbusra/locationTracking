package com.example.locationtrackingapp.data.network;

import javax.inject.Inject;

public class EventBus implements IEventBus {

    @Inject
    public EventBus() {
    }

    @Override
    public org.greenrobot.eventbus.EventBus getBus() {
        return org.greenrobot.eventbus.EventBus.getDefault();
    }
}
