package com.kotlinlogin.java_mvvm;

import android.text.TextUtils;

import org.jetbrains.annotations.NotNull;

public class User {

    @NotNull
    private String userName;
    @NotNull
    private String password;

    public User(@NotNull String userName, @NotNull String password) {
        this.userName = userName;
        this.password = password;
    }

    @NotNull
    public String getUserName() {
        return userName;
    }

    public void setUserName(@NotNull String userName) {
        this.userName = userName;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public boolean isInputDataValid() {


        return !TextUtils.isEmpty(getUserName()) && getPassword().length() > 5;
    }
}
