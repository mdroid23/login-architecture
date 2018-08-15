package com.kotlinlogin.java_mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kotlinlogin.R;

public class LoginActivity extends AppCompatActivity implements LoginContract {

    private EditText editUserName, editPassword;
    private Button btnLogin;

    private LoginPresenter loginInteractor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        init();
        loginInteractor = new LoginPresenter(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginInteractor.onLoginClick();
            }
        });
    }

    private void init() {
        editUserName = (EditText) findViewById(R.id.et_username);
        editPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_submit);

    }

    @Override
    public String getUserName() {
        return editUserName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return editPassword.getText().toString().trim();
    }

    @Override
    public void setUserNameError(int resId) {
        editUserName.setError(getString(resId));
    }

    @Override
    public void setPasswordError(int resId) {
        editPassword.setError(getString(resId));
    }

    @Override
    public void showLoginSuccess() {
        showToast(getString(R.string.str_success_login));
    }

    @Override
    public void showLoginFailure() {
        showToast(getString(R.string.str_failed_login));
    }

    /**
     * @param message : for display purpose
     */
    private void showToast(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
