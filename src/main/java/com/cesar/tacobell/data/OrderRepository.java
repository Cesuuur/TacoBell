package com.cesar.tacobell.data;

import com.cesar.tacobell.Order.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long>{

}