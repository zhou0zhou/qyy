package com.ccnu.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

@Table(name = "topic")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private String topic_title; // 话题标题
    private String topic_content; // 话题内容
    private int topic_likes; // 话题的点赞数
    private String publisher_account; // 发布者账号
    private String publish_time; // 话题发布时间
    private String poi_name; // 趣点名称
}
