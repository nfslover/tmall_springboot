package com.how2java.tmall.pojo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;


@Entity
@Table(name="category")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    int id;
    String name;

    @Transient
    List<Product> products;
    @Transient
    List<List<Product>> productsByRow;

    @Override
    public String toString(){
        return "Category [id=" + id + ", name=" + name + "]";
    }



}
