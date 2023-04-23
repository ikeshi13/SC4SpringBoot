package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee", schema="public")
public class User {
    //ユーザーID
    @Id
    private String id;
    //パスワード
    private String password;
    //名前
    private String name;
    //メールアドレス
    private String mail;
    //プログラミング言語
    private String programinglanguage;
    //コメント
    private String comment;
    //作成日
    private String createdate;
    //更新日
    private String updatedate;
    //削除フラグ（論理削除）
    private String deleteflg;
}
