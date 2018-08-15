package com.kotlinlogin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.layout_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)

        btnNormal.setOnClickListener(View.OnClickListener {
            startNextActivity(com.kotlinlogin.kotlin_normal.LoginActivity::class.java)
        })

        btnMvpLogin.setOnClickListener(View.OnClickListener {
            startNextActivity(com.kotlinlogin.java_mvp.LoginActivity::class.java)
        })

        btnMvpKLogin.setOnClickListener(View.OnClickListener {
            startNextActivity(com.kotlinlogin.kotlin_mvp.LoginActivity::class.java)
        })

        btnMvpKLogin.setOnClickListener(View.OnClickListener {
            startNextActivity(com.kotlinlogin.kotlin_mvp.LoginActivity::class.java)
        })

        btnMvvmLogin.setOnClickListener(View.OnClickListener {
            startNextActivity(com.kotlinlogin.java_mvvm.LoginActivity::class.java)
        })

        btnVipeLogin.setOnClickListener(View.OnClickListener {
            startNextActivity(com.kotlinlogin.kotlin_vipe.LoginActivity::class.java)
        })

        btnViperLogin.setOnClickListener(View.OnClickListener {
            startNextActivity(com.kotlinlogin.kotlin_viper.LoginActivity::class.java)
        })

    }

    fun <T> startNextActivity(cls: Class<T>) {
        val intent = Intent(this, cls)
        startActivity(intent)
    }

}
