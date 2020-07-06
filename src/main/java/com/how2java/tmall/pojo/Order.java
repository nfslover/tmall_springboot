package com.how2java.tmall.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.how2java.tmall.service.OrderService;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "order_")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    private String orderCode;
    private String address;
    private String post;
    private String receiver;
    private String userMessage;
    private Date createDate;
    private Date payDate;
    private Date deliveryDate;
    private Date confirmDate;
    private String status;

    @Transient
    private List<OrderItem> orderItems;
    @Transient
    private float total;
    @Transient
    private int totalNumber;
    @Transient
    private String statusDesc;

    private String getStatusDesc(String statusDesc){
        if(null != statusDesc)
            return statusDesc;
        String desc;
        switch (status){
            case OrderService.waitPay:
                desc = "待付";
                break;
            case OrderService.waitDelivery:
                desc = "待发";
                break;
            case OrderService.waitConfirm:
                desc = "待收";
                break;
            case OrderService.waitReview:
                desc = "等评";
                break;
            case OrderService.finish:
                desc = "完成";
                break;
            case OrderService.delete:
                desc = "删除";
                break;
            default:
                desc = "未知";
        }
        statusDesc = desc;
        return statusDesc;
    }


}
