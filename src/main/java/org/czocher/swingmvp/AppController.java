package org.czocher.swingmvp;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.czocher.swingmvp.models.UserRepository;
import org.czocher.swingmvp.presenters.impl.LoginPresenterImpl;
import org.czocher.swingmvp.presenters.impl.WelcomePresenterImpl;
import org.czocher.swingmvp.views.LoginView;
import org.czocher.swingmvp.views.WelcomeView;
import org.czocher.swingmvp.views.impl.LoginViewImpl;
import org.czocher.swingmvp.views.impl.WelcomeViewImpl;

class AppController {

    private static final Logger LOGGER = Logger.getLogger(AppController.class.getName());
    
    private final UserRepository userRepository;
    private final AppData appData;
    private final JFrame frame;
    private final EventBus eventBus;
    
    private LoginView loginView = LoginView.NULL;
    private WelcomeView welcomeView = WelcomeView.NULL;

    AppController(EventBus eventBus) {
        this.eventBus = eventBus;
        
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        appData = new AppData(eventBus);
        userRepository = new UserRepository();
        bind();
    }

    private void bind() {
        eventBus.register(this);
    }

    @Subscribe
    public void onViewChange(String newView) {
        switch (newView) {
            case LoginView.TAG:
                if (loginView == LoginView.NULL) {
                    loginView = new LoginViewImpl();
                }
                new LoginPresenterImpl(loginView, userRepository).go(frame.getContentPane());
                break;
            case WelcomeView.TAG:
                if (welcomeView == WelcomeView.NULL) {
                    welcomeView = new WelcomeViewImpl();
                }
                new WelcomePresenterImpl(welcomeView, appData).go(frame.getContentPane());
                break;
            default:
                LOGGER.log(Level.WARNING, "Unknown view tag: {0}", newView);
        }
        frame.pack();
        frame.setVisible(true);
    }

    void go() {
        onViewChange(LoginView.TAG);
    }

}
