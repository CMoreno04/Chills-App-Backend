package com.chillsrestaurant.app.entities;

import java.util.Objects;
import com.chillsrestaurant.app.entities.dto.OrderDTO.OrderMenuItemDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity representing an OrderMenuItem in Chills Restaurant application.
 * It links an order to a specific menu item, along with quantity and additional
 * notes.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "order_menu_item")
public class OrderMenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_item_id", nullable = false)
    private MenuItem menuItem;

    @Column(nullable = false)
    private Integer quantity;

    @Column(length = 255)
    private String notes;

    /**
     * Updates this OrderMenuItem entity with data from the given DTO.
     * Only modifiable fields like quantity and notes are updated.
     *
     * @param dto The OrderMenuItemDto containing the new data.
     */
    public void updateFromDto(OrderMenuItemDto dto) {
        if (dto.getQuantity() != null) {
            this.quantity = dto.getQuantity();
        }
        if (dto.getNotes() != null) {
            this.notes = dto.getNotes();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof OrderMenuItem))
            return false;
        OrderMenuItem that = (OrderMenuItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrderMenuItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", notes='" + notes + '\'' +
                '}';
    }
}
