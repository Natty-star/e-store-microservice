package edu.miu.cs590.orderservice.repository;

import edu.miu.cs590.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
