package com.ccnu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private String comment_topictitle;
    private String comment_content;
    private int comment_likes;
    private String comment_account;
    public String tostring(){
        return "内容: "+comment_content+"<br>用户: "+comment_account;
    }
}

