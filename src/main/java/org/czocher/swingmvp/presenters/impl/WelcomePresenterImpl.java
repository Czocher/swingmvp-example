package org.czocher.swingmvp.presenters.impl;

import java.awt.Component;
import java.awt.Container;
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
    public void go(Container container) {
        container.removeAll();
        container.add((Component) view);
    }

}
