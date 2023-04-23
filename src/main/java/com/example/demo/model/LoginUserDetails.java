package com.example.demo.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class LoginUserDetails extends User{

    //DBから取得したユーザー情報
    private final LoginUser loginUser;

    public LoginUserDetails(LoginUser loginUser, Collection<GrantedAuthority> authorities) {

        //認証されたユーザーの詳細情報を返す
        super(loginUser.getId(), loginUser.getPassword(),
                true, true, true, true, authorities);

        this.loginUser = loginUser;
    }

    public LoginUser getLoginUser() {
        return loginUser;
    }

}