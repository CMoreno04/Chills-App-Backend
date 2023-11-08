package com.chillsrestaurant.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.chillsrestaurant.app.entities.Customer;
import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.entities.OrderMenuItem;
import com.chillsrestaurant.app.entities.OrderResponse;
import com.chillsrestaurant.app.entities.dto.OrderDTO;
import com.chillsrestaurant.app.entities.mapper.OrderMapper;
import com.chillsrestaurant.app.repositories.CustomerRepository;
import com.chillsrestaurant.app.repositories.OrderMenuItemRepository;
import com.chillsrestaurant.app.repositories.OrderRepository;
import com.chillsrestaurant.app.services.OrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final OrderMapper orderMapper;
    private final OrderMenuItemRepository orderMenuItemRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository,
            OrderMapper orderMapper, OrderMenuItemRepository orderMenuItemRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.orderMapper = orderMapper;
        this.orderMenuItemRepository = orderMenuItemRepository;
    }

    @Override
    public List<OrderResponse> findAllOrders() {

        List<OrderResponse> orderResponseList = new ArrayList<>();

        this.orderRepository.findAll().forEach(order -> orderResponseList.add(new OrderResponse(order)));

        return orderResponseList;
    }

    @Override
    @Transactional
    public List<Order> addAnOrder(OrderDTO newOrder) {

        Customer customer = customerRepository.findById(newOrder.getCustomer().getId()).get();

        Order order = this.orderMapper.orderDtoToOrder(newOrder);

        order.setCustomer(customer);

        List<OrderMenuItem> menuitems = order.getOrderMenuItems();

        order.setOrderMenuItems(new ArrayList<>());

        final Order orderPersisted = this.orderRepository.save(order);

        menuitems.forEach(menuItem -> {
            menuItem.setOrder(orderPersisted);
            menuItem.setId(null);
        });

        this.orderMenuItemRepository.saveAll(menuitems);

        List<Order> orders = this.orderRepository.findAll();

        return orders;
    }

    @Override
    @Transactional
    public boolean deleteOrder(Order order) {
        try {
            this.orderRepository.delete(order);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
