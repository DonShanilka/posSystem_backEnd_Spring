package lk.ijse.pos_system_backend_spring.entity.impl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.ijse.pos_system_backend_spring.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item implements SuperEntity {
    @Id
    @Column(name = "item_code")
    private String itemCode;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int qty;

    @Column(nullable = false)
    private double price;
}
