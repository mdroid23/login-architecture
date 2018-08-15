package com.kotlinlogin.kotlin_vipe

import com.kotlinlogin.java_mvvm.User

class LoginContracts {

    interface View {
        fun goToHomeScreen(user: User)
        fun setUserError(resId: Int)
        fun setPasswordError(resId: Int)
        fun showError(message: String)
    }

    interface Presenter {
        fun onDestroy()
        fun onLoginButtonPressed(username: String, password: String)
    }

    interface Interactor {
        fun login(username: String, password: String)
    }

    interface InteractorOutput {
        fun onLoginSuccess(user: User)
        fun onLoginError(message: String)
    }

}