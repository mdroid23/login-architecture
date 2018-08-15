package com.kotlinlogin.kotlin_mvp

interface LoginContractView {

    fun getUserName(): String
    fun getPassword(): String

    fun setUserError(resId: Int)
    fun setPasswordError(resId: Int)

    fun showLoginSuccess()
    fun showLoginFailure()

}