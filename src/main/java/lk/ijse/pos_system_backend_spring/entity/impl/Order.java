package lk.ijse.pos_system_backend_spring.entity.impl;

import jakarta.persistence.*;
import lk.ijse.pos_system_backend_spring.dto.custom.impl.OrderDetailsDto;
import lk.ijse.pos_system_backend_spring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order implements SuperEntity {

    @Id
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private String orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderDetail> orderDetails;
}
