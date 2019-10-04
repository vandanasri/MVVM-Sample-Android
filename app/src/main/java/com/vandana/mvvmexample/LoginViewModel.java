package com.vandana.mvvmexample;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;


public class LoginViewModel extends ViewModel {

    public MutableLiveData<String> loginStatus = new MutableLiveData<String>();;


    public void doLogin(String userName, String password ) {
        UserModel userModel = new UserModel(userName, password);
        final int code = userModel.checkUserValidity(userName,password);
        System.out.println("@Code "+code);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String msg;

                if(code==0) {
                    msg="Login Successful";
                }
                else{
                    msg="Login Fail";
                }
                System.out.println("@LOGIN: "+msg);

                loginStatus.postValue(msg);
            }
        }, 2000);
    }
}
