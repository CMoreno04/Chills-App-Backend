package com.chillsrestaurant.app.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.chillsrestaurant.app.entities.Order;
import com.chillsrestaurant.app.entities.OrderMenuItem;
import com.chillsrestaurant.app.entities.OrderStatus;
import com.chillsrestaurant.app.entities.User;
import com.chillsrestaurant.app.entities.dto.EditOrderDTO;
import com.chillsrestaurant.app.entities.dto.OrderDTO;
import com.chillsrestaurant.app.entities.dto.OrderDTO.OrderMenuItemDto;
import com.chillsrestaurant.app.entities.mapper.OrderMapper;
import com.chillsrestaurant.app.entities.response.OrderResponse;
import com.chillsrestaurant.app.repositories.OrderMenuItemRepository;
import com.chillsrestaurant.app.repositories.OrderRepository;
import com.chillsrestaurant.app.repositories.UserRepository;
import com.chillsrestaurant.app.services.OrderService;

import jakarta.transaction.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;
    private final OrderMenuItemRepository orderMenuItemRepository;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            UserRepository userRepository,
            OrderMapper orderMapper,
            OrderMenuItemRepository orderMenuItemRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
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
    public List<OrderResponse> addAnOrder(OrderDTO newOrder) {
        try {
            User customer = this.userRepository.findById(newOrder.getCustomer().getId()).get();

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
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

        return this.findAllOrders();

    }

    @Override
    @Transactional
    public List<OrderResponse> deleteOrder(Order order) {
        try {
            this.orderRepository.delete(order);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return this.findAllOrders();
    }

    @Override
    public List<OrderResponse> updateOrder(EditOrderDTO updateOrder) {
        try {

            Order updatedOrder = this.orderRepository.findById(updateOrder.getNumber()).get();

            updatedOrder.setStatus(this.mapStringToStatus(updateOrder.getStatus()));

            updateOrder.setOwner(updateOrder.getOwner());

            updatedOrder.setOrderMenuItems(this.editOrderMenuItems(updateOrder.getItems()));

            this.orderRepository.saveAndFlush(updatedOrder);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            System.err.println(e.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return this.findAllOrders();
    }

    private List<OrderMenuItem> editOrderMenuItems(List<OrderMenuItemDto> inOrderMenuItemDtos) {

        List<OrderMenuItem> outOrderMenuItems = new ArrayList<>();

        inOrderMenuItemDtos.forEach(item -> outOrderMenuItems.add(new OrderMenuItem(item)));

        return outOrderMenuItems;
    }

    private OrderStatus mapStringToStatus(String statusString) {
        switch (statusString.toUpperCase()) {
            case "IN PROGRESS":
                return OrderStatus.IN_PROGRESS;
            case "PENDING":
                return OrderStatus.PENDING;
            case "COMPLETED":
                return OrderStatus.COMPLETED;
            case "CANCELED":
                return OrderStatus.CANCELED;
            case "PENDING PAYMENT":
                return OrderStatus.PENDING_PAYMENT;
            default:
                throw new IllegalArgumentException("Invalid status string: " + statusString);
        }
    }

}
