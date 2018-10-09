package com.kotlinlogin.kotlin_viper

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kotlinlogin.R
import com.kotlinlogin.Utils
import com.kotlinlogin.java_mvvm.User
import kotlinx.android.synthetic.main.layout_login.*

class LoginActivity : AppCompatActivity(), LoginContracts.View, LoginContracts.Router {

    val presenter: LoginContracts.Presenter? = LoginPresenter(this, this);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)

        btn_submit.setOnClickListener(View.OnClickListener {
            presenter?.onLoginButtonPressed(et_username.text.toString(),et_password.text.toString())
        })
    }

    override fun goToHomeScreen(user: User) {
        Utils.showToast(this@LoginActivity,"Welcome " + user.userName)
    }

    override fun setUserError(resId: Int) {
        et_username.error = getString(resId)
    }

    override fun setPasswordError(resId: Int) {
        et_password.error = getString(resId)
    }

    override fun showError(message: String) {
        Utils.showToast(this@LoginActivity,message)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onDestroy()
    }
}
