package com.kotlinlogin.kotlin_vipe

import com.kotlinlogin.java_mvvm.User

class LoginInteractor (var output: LoginContracts.InteractorOutput?): LoginContracts.Interactor {

    override fun login(username: String, password: String) {
        if (!username.equals(password)) {
            output?.onLoginError("Invalid credential :(")
        } else {
            output?.onLoginSuccess(User(username,password))
        }
    }
}