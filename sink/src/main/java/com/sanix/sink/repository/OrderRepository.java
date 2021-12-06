package com.sanix.sink.repository;

import com.sanix.sink.model.Order;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Order>findById(Long id);
}
