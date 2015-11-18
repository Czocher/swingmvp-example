package org.czocher.swingmvp;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.czocher.swingmvp.models.User;

public class AppData {

    private final EventBus eventBus;
    private User loggedInUser;

    public AppData(EventBus eventBus) {
        this.eventBus = eventBus;
        bind();
    }

    private void bind() {
        eventBus.register(this);
    }

    @Subscribe
    public void onUserLoggin(User user) {
        loggedInUser = user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

}
