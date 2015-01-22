package com.mycompany.mavenproject1.logging;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Log {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(length = 1000)
    private String text;

    protected Log() {
    }

    public Log(String text) {
        this.text = text;
    }
    
    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

}
