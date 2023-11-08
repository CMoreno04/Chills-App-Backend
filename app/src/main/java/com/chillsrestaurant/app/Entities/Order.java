package com.chillsrestaurant.app.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date submitTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order", // This should match the name of the property in OrderMenuItem
            cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY // Consider using LAZY fetch type
                                                                                    // for performance
    )
    private List<OrderMenuItem> orderMenuItems;

    private String details;

    // Utility method to add order menu item and set bi-directional relationship
    public void addOrderMenuItem(OrderMenuItem orderMenuItem) {
        orderMenuItems.add(orderMenuItem);
        orderMenuItem.setOrder(this);
    }

    // Utility method to remove order menu item and unset bi-directional relationship
    public void removeOrderMenuItem(OrderMenuItem orderMenuItem) {
        orderMenuItems.remove(orderMenuItem);
        orderMenuItem.setOrder(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
               "id=" + id +
               ", submitTime=" + submitTime +
               ", status=" + status +
               ", details='" + details + '\'' +
               '}';
    }
}
