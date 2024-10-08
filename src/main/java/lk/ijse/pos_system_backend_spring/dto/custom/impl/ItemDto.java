package lk.ijse.pos_system_backend_spring.dto.custom.impl;

import lk.ijse.pos_system_backend_spring.dto.custom.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto implements ItemStatus {
    private String itemCode;
    private String description;
    private String qty;
    private String Price;
}
