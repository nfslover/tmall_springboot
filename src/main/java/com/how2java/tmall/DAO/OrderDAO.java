package com.how2java.tmall.DAO;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDAO extends JpaRepository<Order, Integer>{

}
