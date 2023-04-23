package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class employeeController {

    @Autowired
    UserRepository userrep;

    //ログイン画面表示
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    //ログイン時のエラー画面
    @GetMapping("/error")
    public String error() {
        return "error";
    }

    //ログイン成功時の画面に遷移する
    @GetMapping("/employeeHome")
    public ModelAndView login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //SpringBootでのモデル、ビューを管理するクラスを生成
        ModelAndView mav = new ModelAndView();
        //ログインしたユーザー情報を取得
        User loginUser = userrep.findById(auth.getName());
        //遷移先のhtml名前を記載(templates配下から)
        mav.setViewName("employeeHome");
        //上記のビューに表示させるデータ名を「data」、取得したデータをセット
        mav.addObject("username",loginUser.getName());
        return mav;
    }

    @GetMapping("/employeeRegist")
    public String employeeRegist() {
        return "employeeRegist";
    }

    @GetMapping("/employeeSearch")
    public String employeeSearch() {
        return "employeeSearch";
    }

}
