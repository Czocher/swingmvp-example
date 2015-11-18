package org.czocher.swingmvp.views.impl;

import javax.swing.JLabel;
import javax.swing.JPanel;
import org.czocher.swingmvp.presenters.WelcomePresenter;
import org.czocher.swingmvp.views.WelcomeView;

public class WelcomeViewImpl extends JPanel implements WelcomeView {
    
    private JLabel welcomeLabel;
    private static String welcomeText = "Hello ";
    private String username;
    private WelcomePresenter presenter = WelcomePresenter.NULL;

    public WelcomeViewImpl() {
        createWidgets();
    }

    private void createWidgets() {
        welcomeLabel = new JLabel(welcomeText + username);
        add(welcomeLabel);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
        welcomeLabel.setText(welcomeText + username);
    }

    @Override
    public WelcomePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(WelcomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public WelcomeView getConcrete() {
        return this;
    }

    @Override
    public void show() {
        setVisible(true);
    }

    @Override
    public void hide() {
        setVisible(false);
    }

}
