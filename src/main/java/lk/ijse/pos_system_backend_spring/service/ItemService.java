package lk.ijse.pos_system_backend_spring.service;

import lk.ijse.pos_system_backend_spring.dto.custom.ItemStatus;
import lk.ijse.pos_system_backend_spring.dto.custom.impl.ItemDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    void saveItem(ItemDto itemDto);
    ItemStatus getItemById(String itemCode);
    List<ItemDto> getAllItems();
    void updateItem(String itemCode, ItemDto itemDto);
    void deleteItem(String itemCode);
}
