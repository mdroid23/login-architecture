package com.kotlinlogin.java_mvvm;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kotlinlogin.R;
import com.kotlinlogin.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private EditText editUserName, editPassword;
    private Button btnLogin;
    private User loginModel;
    private LoginViewModel loginViewModel;

    private ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(LoginActivity.this, R.layout.activity_login);
        loginBinding.setViewModel(new LoginViewModel(this));

    }

    @BindingAdapter({"toastString"})
    public static void runMe(Button button, String message) {
        if (message != null)
            Toast.makeText(button.getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @BindingAdapter({"userNameError"})
    public static void userError(EditText editUserName, String message) {
        if (editUserName != null)
            editUserName.setError(message);
    }

    @BindingAdapter({"passwordError"})
    public static void passwordError(EditText editPassword, String message) {
        if (editPassword != null)
            editPassword.setError(message);
    }

}
