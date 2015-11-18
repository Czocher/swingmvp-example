package org.czocher.swingmvp;

import com.google.common.eventbus.EventBus;

public class EventBusSingleton {

    private static EventBus eventBus;

    private EventBusSingleton() {

    }

    public static EventBus getInstance() {
        if (eventBus == null) {
            eventBus = new EventBus();
        }
        return eventBus;
    }
}
