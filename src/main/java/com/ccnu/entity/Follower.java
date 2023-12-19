package com.ccnu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
@Data
@Table(name = "follower")
@AllArgsConstructor
@NoArgsConstructor
public class Follower {
    private String useraccount;
    private String followeraccount;
    public String tostring(){
        return followeraccount;
    }
}
