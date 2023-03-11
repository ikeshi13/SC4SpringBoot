package com.example.demo.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.LoginMapper;
import com.example.demo.model.LoginUser;
import com.example.demo.model.LoginUserDetails;

@Service
public class LoginUserDetailsService implements UserDetailsService{

    @Autowired
    LoginMapper loginMapper;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String empId)
            throws UsernameNotFoundException{
        //DBからユーザー情報を取得
        LoginUser loginUser = Optional.ofNullable(loginMapper.findUser(empId))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new LoginUserDetails (loginUser, getAuthorities(loginUser));
    }

    //認証が通ったユーザーに権限の範囲を設定する
    private Collection<GrantedAuthority> getAuthorities(LoginUser empId){
        return AuthorityUtils.createAuthorityList("ROLE_ADMIN");
    }

}
