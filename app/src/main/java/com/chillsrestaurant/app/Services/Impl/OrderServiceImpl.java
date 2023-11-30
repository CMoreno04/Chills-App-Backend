package com.chillsrestaurant.app.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.chillsrestaurant.app.repositories.MenuItemRepository;
import com.chillsrestaurant.app.repositories.OrderMenuItemRepository;
import com.chillsrestaurant.app.repositories.OrderRepository;
import com.chillsrestaurant.app.repositories.UserRepository;
import com.chillsrestaurant.app.services.OrderService;

import jakarta.transaction.Transactional;

/**
 * Service implementation for managing orders.
 * Provides functionalities to add, update, delete, and list orders.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderMapper orderMapper;
    private final OrderMenuItemRepository orderMenuItemRepository;
    private final MenuItemRepository menuItemRepository;

    /**
     * Constructs an instance of OrderServiceImpl with necessary dependencies.
     *
     * @param orderRepository         Repository for accessing and manipulating
     *                                order data.
     * @param userRepository          Repository for accessing user data.
     * @param orderMapper             Mapper to convert DTOs to Order entities.
     * @param menuItemRepository      Repository for accessing menu item data.
     * @param orderMenuItemRepository Repository for accessing order menu item data.
     */
    public OrderServiceImpl(
            OrderRepository orderRepository,
            UserRepository userRepository,
            OrderMapper orderMapper,
            MenuItemRepository menuItemRepository,
            OrderMenuItemRepository orderMenuItemRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.orderMapper = orderMapper;
        this.menuItemRepository = menuItemRepository;
        this.orderMenuItemRepository = orderMenuItemRepository;
    }

    /**
     * Retrieves all orders.
     *
     * @return A list of responses containing order details.
     */
    @Override
    public List<OrderResponse> findAllOrders() {
        List<OrderResponse> orderResponseList = new ArrayList<>();
        this.orderRepository.findAll().forEach(order -> orderResponseList.add(new OrderResponse(order)));
        return orderResponseList;
    }

    /**
     * Adds a new order based on the provided DTO.
     *
     * @param newOrder DTO containing new order details.
     * @return A list of responses containing updated order details.
     */
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

    /**
     * Deletes an existing order.
     *
     * @param order The order entity to be deleted.
     * @return A list of responses containing the current orders after deletion.
     */
    @Override
    @Transactional
    public List<OrderResponse> deleteOrder(Order order) {
        try {
            this.orderRepository.delete(order);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            System.err.println(e.getMessage());
            // Handle specific exceptions as required
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            // Handle other exceptions
        }
        return this.findAllOrders();
    }

    /**
     * Updates an existing order based on the provided DTO.
     *
     * @param updateOrder DTO containing updated order details.
     * @return A list of responses containing the updated orders.
     */
    @Override
    public List<OrderResponse> updateOrder(EditOrderDTO updateOrder) {
        try {
            Order updatedOrder = this.orderRepository.findById(updateOrder.getNumber())
                    .orElseThrow(() -> new IllegalArgumentException("Order not found"));
            updatedOrder.setStatus(this.mapStringToStatus(updateOrder.getStatus()));
            updatedOrder.setOrderMenuItems(
                    this.editOrderMenuItems(updatedOrder.getOrderMenuItems(), updateOrder.getItems()));

            this.orderRepository.saveAndFlush(updatedOrder);
        } catch (IllegalArgumentException | OptimisticLockingFailureException e) {
            System.err.println(e.getMessage());
            // Handle specific exceptions as required
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            // Handle other exceptions
        }
        return this.findAllOrders();
    }

    private List<OrderMenuItem> editOrderMenuItems(List<OrderMenuItem> orderItems,
            List<OrderMenuItemDto> inOrderMenuItemDtos) {
        Map<Long, OrderMenuItemDto> dtoMap = inOrderMenuItemDtos.stream()
                .collect(Collectors.toMap(OrderMenuItemDto::getId, dto -> dto));

        orderItems.forEach(item -> {
            OrderMenuItemDto dto = dtoMap.get(item.getId());
            if (dto != null) {
                item.updateFromDto(dto);
            }
        });

        return orderItems;
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
                return OrderStatus.CANCELLED;
            case "PENDING PAYMENT":
                return OrderStatus.PENDING_PAYMENT;
            default:
                throw new IllegalArgumentException("Invalid status string: " + statusString);
        }
    }
}
