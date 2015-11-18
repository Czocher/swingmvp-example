package org.czocher.swingmvp.views;

import java.util.logging.Logger;
import org.czocher.swingmvp.presenters.WelcomePresenter;

public interface WelcomeView extends View<WelcomeView, WelcomePresenter> {

    final Logger LOGGER = Logger.getLogger(WelcomeView.class.getName());

    public static WelcomeView NULL = new WelcomeView() {

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
        public WelcomePresenter getPresenter() {
            log();
            return null;
        }

        @Override
        public void setPresenter(WelcomePresenter presenter) {
            log();
        }

        @Override
        public WelcomeView getConcrete() {
            log();
            return null;
        }

        @Override
        public void show() {
            log();
        }

        @Override
        public void hide() {
            log();
        }

        private void log() {
            LOGGER.severe("NULL object used!");
        }
    };

    public static String TAG = "welcome";

    String getUsername();

    void setUsername(String username);
}
