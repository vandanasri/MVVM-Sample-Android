package com.vandana.mvvmexample;

public class UserModel {

    private String username;
    private String password;

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int checkUserValidity(String username, String password){
        if (username.trim().equals("")||password.trim().equals("")){
            return -1;
        }else{
            return 0;
        }

    }
}
