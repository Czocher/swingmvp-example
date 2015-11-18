package org.czocher.swingmvp;

import com.google.common.eventbus.EventBus;
import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        EventBus eventBus = EventBusSingleton.getInstance();
        
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        MainAppPresenter presenter = new MainAppPresenter(eventBus);
        presenter.go(frame);
    }
}
