package org.czocher.swingmvp.views.impl;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.czocher.swingmvp.presenters.LoginPresenter;
import org.czocher.swingmvp.views.LoginView;

public class LoginViewImpl extends JPanel implements LoginView {

    private JTextField usernameBox;
    private JPasswordField passwordBox;
    private JButton loginButton;
    private LoginPresenter presenter = LoginPresenter.NULL;

    public LoginViewImpl() {
        createWidgets();
        registerListeners();
    }

    private void createWidgets() {
        setLayout(new BorderLayout(0, 0));

        JPanel headerPanel = new JPanel();
        add(headerPanel, BorderLayout.NORTH);

        JLabel titleLabel = new JLabel("Login Form");
        headerPanel.add(titleLabel);

        JPanel mainPanel = new JPanel();
        add(mainPanel, BorderLayout.CENTER);

        JLabel usernameLabel = new JLabel("Username");
        mainPanel.add(usernameLabel);

        usernameBox = new JTextField();
        usernameBox.setColumns(10);
        mainPanel.add(usernameBox);

        JLabel passwordLabel = new JLabel("Password");
        mainPanel.add(passwordLabel);

        passwordBox = new JPasswordField();
        passwordBox.setColumns(10);
        mainPanel.add(passwordBox);

        JPanel footerPanel = new JPanel();
        add(footerPanel, BorderLayout.SOUTH);

        loginButton = new JButton("Login");
        footerPanel.add(loginButton);
    }

    private void registerListeners() {
        loginButton.addActionListener((ActionEvent e) -> {
            presenter.onLogin();
        });
    }

    @Override
    public String getUsername() {
        return usernameBox.getText();
    }

    @Override
    public void setUsername(String username) {
        this.usernameBox.setText(username);
    }

    @Override
    public String getPassword() {
        return String.valueOf(passwordBox.getPassword());
    }

    @Override
    public void setPassword(String password) {
        this.passwordBox.setText(password);
    }

    @Override
    public void show() {
        super.setVisible(true);
    }

    @Override
    public void hide() {
        super.setVisible(false);
    }

    @Override
    public LoginPresenter getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(LoginPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public LoginView getConcrete() {
        return this;
    }

    @Override
    public void showBadCredentianlsAlert() {
        JOptionPane.showMessageDialog(null, "Bad Credentials!", "Error", JOptionPane.ERROR_MESSAGE);
    }

}
