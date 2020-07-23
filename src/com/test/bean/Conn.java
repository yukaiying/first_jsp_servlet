package com.test.bean;

import java.util.Date;

public class Conn {
    private Integer id;
    private String title;
    private String content;
    private Date createTime;

    public Conn(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Conn() {
    }

    public Conn(Integer id, String title, String content, Date createTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
