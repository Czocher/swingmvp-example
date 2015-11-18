package org.czocher.swingmvp;

import com.google.common.eventbus.EventBus;

public class Main {
    
    public static void main(String[] args) {
        EventBus eventBus = EventBusSingleton.getInstance();
        
        AppController controller = new AppController(eventBus);
        controller.go();
    }
}
