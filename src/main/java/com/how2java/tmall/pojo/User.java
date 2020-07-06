package com.how2java.tmall.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String password;
    private String name;
    private String salt;

    @Transient
    private String anonymousName;


    public String getAnonymousName(){
        if(null != anonymousName)
            return anonymousName;
        if(null == name)
            anonymousName = null;
        else if(name.length() <= 1)
            anonymousName = "*";
        else if(name.length() == 2)
            anonymousName = name.substring(0,1) + "*";
        else{
            char[] cs = name.toCharArray();
            for(int i = 1; i < cs.length; i++){
                cs[i] = '*';
            }
            anonymousName = new String(cs);
        }
        return anonymousName;

    }

    public void setAnonymousName(String anonymousName){
        this.anonymousName = anonymousName;
    }



}
