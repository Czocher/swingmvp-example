package org.czocher.swingmvp.presenters.impl;

import java.awt.Component;
import javax.swing.JFrame;
import org.czocher.swingmvp.AppData;
import org.czocher.swingmvp.presenters.WelcomePresenter;
import org.czocher.swingmvp.views.WelcomeView;

public class WelcomePresenterImpl implements WelcomePresenter {

    private WelcomeView view = WelcomeView.NULL;
    private final AppData appData;

    public WelcomePresenterImpl(WelcomeView view, AppData appData) {
        this.view = view;
        this.view.setPresenter(this);
        this.view.show();
        this.appData = appData;
        
        this.view.setUsername(appData.getLoggedInUser().getUsername());
    }

    @Override
    public void go(JFrame container) {
        container.getContentPane().removeAll();
        container.add((Component) view);
    }

}
