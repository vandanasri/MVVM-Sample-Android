package com.vandana.mvvmexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editUserName;
    private EditText editPassword;
    private Button   btnLogin;
    private ProgressBar progressBar;
    LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginResult();
            }
        });


        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginViewModel.loginStatus.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String str) {
                progressBar.setVisibility(View.INVISIBLE);
                System.out.println("onChanged: "+str);
                Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT).show();

            }
        });

    }


    private void loginResult(){

        progressBar.setVisibility(View.VISIBLE);
        String userName = editUserName.getText().toString();
        String password = editPassword.getText().toString();

        loginViewModel.doLogin(userName, password);
    }



    private void initUI(){
        editUserName = findViewById(R.id.et_name);
        editPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.bt_submit);
        progressBar = findViewById(R.id.progress_login);
        progressBar.setVisibility(View.INVISIBLE);
    }





}
