package org.czocher.swingmvp.presenters.impl;

import java.awt.Component;
import java.awt.Container;
import java.util.logging.Logger;
import org.czocher.swingmvp.AppData;
import org.czocher.swingmvp.EventBusSingleton;
import org.czocher.swingmvp.models.User;
import org.czocher.swingmvp.models.UserRepository;
import org.czocher.swingmvp.presenters.LoginPresenter;
import org.czocher.swingmvp.views.LoginView;
import org.czocher.swingmvp.views.WelcomeView;

public class LoginPresenterImpl implements LoginPresenter {

    private UserRepository userRepository;
    private AppData appData;
    private LoginView view = LoginView.NULL;
    private static final Logger LOGGER = Logger.getLogger(LoginPresenterImpl.class.getName());
    
    public LoginPresenterImpl(LoginView view, AppData appData, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.appData = appData;
        
        this.view = view;
        this.view.setPresenter(this);
        this.view.show();
    }

    @Override
    public void onLogin() {
        User u = userRepository.getUserByUsername(view.getUsername());
        if (u != null && u.getPassword().equals(view.getPassword())) {
            appData.setLoggedInUser(u);
            EventBusSingleton.getInstance().post(WelcomeView.TAG);
        } else {
            view.showBadCredentianlsAlert();
        }
    }

    @Override
    public void go(Container container) {
        container.add((Component) view);
    }

}
