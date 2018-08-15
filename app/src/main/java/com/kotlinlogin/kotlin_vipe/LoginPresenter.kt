package com.kotlinlogin.kotlin_vipe

import android.text.TextUtils
import com.kotlinlogin.R
import com.kotlinlogin.java_mvvm.User

class LoginPresenter(var view: LoginContracts.View?): LoginContracts.Presenter, LoginContracts.InteractorOutput {

    var interactor: LoginContracts.Interactor? = LoginInteractor(this)

    override fun onDestroy() {
        view = null
        interactor = null
    }

    override fun onLoginButtonPressed(userName: String, password: String) {

        if (TextUtils.isEmpty(userName)) {
            view?.setUserError(R.string.err_username)
        } else if (TextUtils.isEmpty(password)) {
            view?.setPasswordError(R.string.err_password)
        } else{
            interactor?.login(userName, password)
        }

    }

    override fun onLoginSuccess(user: User) {
        view?.goToHomeScreen(user)
    }

    override fun onLoginError(message: String) {
        view?.showError(message)
    }
}