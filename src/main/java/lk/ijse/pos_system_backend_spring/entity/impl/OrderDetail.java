package lk.ijse.pos_system_backend_spring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.pos_system_backend_spring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_details")
public class OrderDetail implements SuperEntity {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "item_code", nullable = false)
    private Item item;

    @Column(nullable = false)
    private int qty;

    @Column(nullable = false)
    private double unitPrice;
}
