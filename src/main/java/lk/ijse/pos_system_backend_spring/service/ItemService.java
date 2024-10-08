package lk.ijse.pos_system_backend_spring.service;

import lk.ijse.pos_system_backend_spring.dto.custom.impl.ItemDto;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDto itemDto);
    ItemDto getItemById(String itemCode);
    List<ItemDto> getAllItems();
    void updateItem(String itemCode, ItemDto itemDto);
    void deleteItem(String itemCode);
}
