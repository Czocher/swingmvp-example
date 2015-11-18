package org.czocher.swingmvp.presenters;

import java.awt.Container;
import java.util.logging.Logger;
import javax.swing.JFrame;

public interface WelcomePresenter extends Presenter {

    static Logger LOGGER = Logger.getLogger(WelcomePresenter.class.getName());
    public static WelcomePresenter NULL = new WelcomePresenter() {

        @Override
        public void go(Container container) {
            log();
        }

        private void log() {
            LOGGER.severe("NULL object used!");
        }


    };
}
