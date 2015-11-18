package org.czocher.swingmvp.presenters;

import java.awt.Container;
import java.util.logging.Logger;
import javax.swing.JFrame;

public interface LoginPresenter extends Presenter {

    static LoginPresenter NULL = new LoginPresenter() {

        private final Logger logger = Logger.getLogger(this.getClass().getName());

        @Override
        public void onLogin() {
            log();
        }

        @Override
        public void go(Container container) {
            log();
        }

        private void log() {
            logger.severe("NULL object used!");
        }

    };

    void onLogin();
}
