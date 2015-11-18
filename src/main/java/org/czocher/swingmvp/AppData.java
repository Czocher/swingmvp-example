package org.czocher.swingmvp;

import com.google.common.eventbus.EventBus;
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

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

}
