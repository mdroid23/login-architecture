package com.kotlinlogin.java_mvvm;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.kotlinlogin.BR;
import com.kotlinlogin.R;

public class LoginViewModel extends BaseObservable {

    private User user;
    private Context context;

    @Bindable
    public String toastString = null;
    @Bindable
    public String userNameError = null;
    @Bindable
    public String passwordError = null;

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
        notifyPropertyChanged(BR.userNameError);
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
        notifyPropertyChanged(BR.passwordError);
    }

    private void setToastString(String toastString) {
        this.toastString = toastString;
        notifyPropertyChanged(BR.toastString);
    }

    public LoginViewModel(Context context) {
        this.context = context;
        user = new User("", "");
    }

    public void afterUserTextChanged(CharSequence s) {
        user.setUserName(s.toString());
    }

    public void afterPasswordTextChanged(CharSequence s) {
        user.setPassword(s.toString());
    }

    public void onLoginClicked() {

        if (TextUtils.isEmpty(user.getUserName())) {
            setUserNameError(context.getString(R.string.err_username));
        } else if (TextUtils.isEmpty(user.getPassword())) {
            setPasswordError(context.getString(R.string.err_password));
        } else if (!user.getUserName().equals(user.getPassword())) {
            setToastString(context.getString(R.string.str_failed_login));
        } else {
            setToastString(context.getString(R.string.str_success_login));
        }
    }
}
