package com.sanix.sink.logic;

import com.sanix.sink.model.Order;
import com.sanix.sink.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderLogic {

    private final OrderRepository orderRepository;

    public Order add(Order order){
        return orderRepository.save(order);
    }

    @Transactional
    public boolean performUpdate(Long buyOrderId, Long sellOrderId, int amount){
        Order buyOrder=orderRepository.findById(buyOrderId).orElseThrow();
        Order sellOrder=orderRepository.findById(sellOrderId).orElseThrow();
        int buyAvailableCount=buyOrder.getProductCount()-buyOrder.getRealizedCount();
        int sellAvailableCount=sellOrder.getProductCount()-sellOrder.getRealizedCount();
        if(buyAvailableCount >= amount && sellAvailableCount >= amount){
            buyOrder.setRealizedCount(buyOrder.getRealizedCount()+amount);
            sellOrder.setRealizedCount(sellOrder.getRealizedCount()+amount);
            orderRepository.save(buyOrder);
            orderRepository.save(sellOrder);
            return true;
        }else {
            return false;
        }
    }

}
