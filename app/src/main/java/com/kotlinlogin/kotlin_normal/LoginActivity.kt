package com.kotlinlogin.kotlin_normal

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import com.kotlinlogin.R
import com.kotlinlogin.Utils
import kotlinx.android.synthetic.main.layout_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)


        btn_submit.setOnClickListener(View.OnClickListener {

            if (validation()) {
                Utils.showToast(this@LoginActivity,getString(R.string.str_success_login))
            }
        })
    }


    private fun validation(): Boolean {

        if (TextUtils.isEmpty(et_username.text.toString())) {
            et_username.error = getString(R.string.err_username)
            return false
        } else if (TextUtils.isEmpty(et_password.text.toString())) {
            et_password.error = getString(R.string.err_password)
            return false
        } else if (!et_username.text.toString().equals(et_password.text.toString())) {
            Utils.showToast(this@LoginActivity,getString(R.string.str_failed_login))
            return false
        }
        return true
    }
}
