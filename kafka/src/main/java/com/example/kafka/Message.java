package com.example.kafka;


import java.util.Date;

public class Message {
    private Long id;
    private String msg;
    private Date sendDate;

    public Long getId() {
        return id;
    }

    public Message setId(Long id) {
        this.id = id;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Message setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public Message setSendDate(Date sendDate) {
        this.sendDate = sendDate;
        return this;
    }
}
