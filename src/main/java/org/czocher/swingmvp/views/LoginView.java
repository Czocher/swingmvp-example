package org.czocher.swingmvp.views;

import java.util.logging.Logger;
import org.czocher.swingmvp.presenters.LoginPresenter;

public interface LoginView extends View<LoginView, LoginPresenter> {

    static final Logger LOGGER = Logger.getLogger(LoginView.class.getName());

    static String TAG = "login";

    static LoginView NULL = new LoginView() {

        @Override
        public String getUsername() {
            log();
            return null;
        }

        @Override
        public void setUsername(String username) {
            log();
        }

        @Override
        public String getPassword() {
            log();
            return null;
        }

        @Override
        public void setPassword(String password) {
            log();
        }

        @Override
        public void show() {
            log();
        }

        @Override
        public void hide() {
            log();
        }

        @Override
        public LoginPresenter getPresenter() {
            log();
            return null;
        }

        @Override
        public void setPresenter(LoginPresenter presenter) {
            log();
        }

        @Override
        public LoginView getConcrete() {
            log();
            return null;
        }

        @Override
        public void showBadCredentianlsAlert() {
            log();
        }

        private void log() {
            LOGGER.severe("NULL object used!");
        }

    };

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);
    
    void showBadCredentianlsAlert();

}
