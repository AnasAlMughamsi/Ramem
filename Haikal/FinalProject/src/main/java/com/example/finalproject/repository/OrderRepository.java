package com.example.finalproject.repository;

import com.example.finalproject.model.MyOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<MyOrder, Integer> {

    MyOrder findOrdersById(Integer id);

}
