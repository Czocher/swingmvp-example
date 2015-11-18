package org.czocher.swingmvp.presenters.impl;

import java.awt.Component;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.czocher.swingmvp.EventBusSingleton;
import org.czocher.swingmvp.models.User;
import org.czocher.swingmvp.models.UserRepository;
import org.czocher.swingmvp.presenters.LoginPresenter;
import org.czocher.swingmvp.views.LoginView;
import org.czocher.swingmvp.views.WelcomeView;

public class LoginPresenterImpl implements LoginPresenter {

    private UserRepository userRepository;
    private LoginView view = LoginView.NULL;
    private static final Logger LOGGER = Logger.getLogger(LoginPresenterImpl.class.getName());
    
    public LoginPresenterImpl(LoginView view, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.view = view;
        this.view.setPresenter(this);
        this.view.show();
    }

    @Override
    public void onLogin() {
        User u = userRepository.getUserByUsername(view.getUsername());
        if (u != null && u.getPassword().equals(view.getPassword())) {
            EventBusSingleton.getInstance().post(u);
            EventBusSingleton.getInstance().post(WelcomeView.TAG);
        } else {
            view.showBadCredentianlsAlert();
        }
    }

    @Override
    public void go(JFrame container) {
        container.add((Component) view);
    }

}
