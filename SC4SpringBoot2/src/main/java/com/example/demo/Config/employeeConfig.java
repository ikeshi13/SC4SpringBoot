package com.example.demo.Config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class employeeConfig {

    //passwordをエンコードする為のエンコーダー
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //ここからログイン、ログアウトなどの設定
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.formLogin(login -> login  //フォーム認証の設定記述開始
                .loginProcessingUrl("/login")  //ユーザー名、パスワードの送信先URL
                .loginPage("/login")  //ログイン画面のURL
                .defaultSuccessUrl("/userinfolist")  //ログイン成功後の遷移先URL
                .failureUrl("/login?error")  //ログイン失敗時のリダイレクト先URL
                .usernameParameter("empId")  //パラメータ名
                .passwordParameter("password")  //パラメータ名
                .permitAll()  //ログイン画面は未ログインでもアクセス可能

            ).logout(logout -> logout  //ログアウトの設定記述開始
                    .logoutSuccessUrl("/login")  //ログアウト成功後の遷移先URL

            ).authorizeHttpRequests(authz -> authz  //URLごとの認可設定記述開始
                    .requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                        .permitAll()  //"/css/**"などはログインなしでもアクセス可能
                    .requestMatchers("/login").permitAll()  //ログインなしでもアクセス可能なURLの設定
                    .requestMatchers("/registuser").permitAll()
                    .requestMatchers("/register").permitAll()
                    .requestMatchers("/result").permitAll()
                    .requestMatchers("/userinfolist").hasRole("ADMIN") //"/userinfolist"はROLE_ADMINのみアクセス可能
                    .anyRequest().authenticated()
            );
        http.csrf().disable();
        return http.build();
    }


}