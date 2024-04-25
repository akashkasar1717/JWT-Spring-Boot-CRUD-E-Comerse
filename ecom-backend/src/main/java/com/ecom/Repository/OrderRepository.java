package com.ecom.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.Model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
