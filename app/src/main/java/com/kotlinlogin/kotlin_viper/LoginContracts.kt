package com.kotlinlogin.kotlin_viper

import com.kotlinlogin.java_mvvm.User

class LoginContracts {

    interface View {
        fun setUserError(resId: Int)
        fun setPasswordError(resId: Int)
        fun showError(message: String)
    }

    interface Interactor {
        fun login(username: String, password: String)
    }
    interface InteractorOutput {
        fun onLoginSuccess(user: User)
        fun onLoginError(message: String)
    }

    interface Presenter {
        fun onDestroy()
        fun onLoginButtonPressed(username: String, password: String)
    }

    interface Router {
        fun goToHomeScreen(user: User) // Now the router handles it
    }

}