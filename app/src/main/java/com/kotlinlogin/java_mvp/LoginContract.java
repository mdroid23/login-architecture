package com.kotlinlogin.java_mvp;

public interface LoginContract {

    String getUserName();
    String getPassword();

    void setUserNameError(int resId);
    void setPasswordError(int resId);

    void showLoginSuccess();
    void showLoginFailure();

}
