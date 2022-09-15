package com.example.gradcrud.Models;

public class Grade {
    public String name;
    public String subject;
    public String mark;

    public Grade(String name, String subject, String mark) {
        this.name = name;
        this.subject = subject;
        this.mark = mark;
    }

    public Grade() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
