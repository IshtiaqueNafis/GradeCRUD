package com.example.gradcrud.Models;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Grade {
    @NotBlank(message = "name can not be blank")
    private String name;

    @NotBlank(message = "subject can not be blank")
    private String subject;
    @NotBlank(message = "mark can not be blank")
    private String mark;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Grade() {
        this.id = UUID.randomUUID().toString();
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
