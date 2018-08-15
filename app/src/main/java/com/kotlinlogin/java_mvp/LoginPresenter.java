package com.kotlinlogin.java_mvp;

import android.text.TextUtils;

import com.kotlinlogin.R;

public class LoginPresenter {

    private LoginContract loginView;

    LoginPresenter(LoginContract loginView) {
        this.loginView = loginView;
    }

    public void onLoginClick() {

        String userName = loginView.getUserName();
        String password = loginView.getPassword();

        if (TextUtils.isEmpty(userName)) {
            loginView.setUserNameError(R.string.err_username);
        } else if (TextUtils.isEmpty(password)) {
            loginView.setPasswordError(R.string.err_password);
        } else if (userName.equals(password)) {
            loginView.showLoginSuccess();
        } else {
            loginView.showLoginFailure();
        }
    }


}
