package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class employeeController {

    //ログイン画面表示
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //ログイン画面から入力された内容をデータベースで確認
    //正しい場合employeeResultに遷移し、間違っている場合リダイレクトする
    @PostMapping("/loginForm")
    public String loginForm() {

        return "employeeResult";
    }


}
