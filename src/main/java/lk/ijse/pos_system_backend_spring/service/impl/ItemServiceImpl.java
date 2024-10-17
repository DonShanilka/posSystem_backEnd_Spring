package lk.ijse.pos_system_backend_spring.service.impl;


import lk.ijse.pos_system_backend_spring.customStatusCode.SelectedItemErrorStatus;
import lk.ijse.pos_system_backend_spring.dao.ItemDao;
import lk.ijse.pos_system_backend_spring.dto.custom.ItemStatus;
import lk.ijse.pos_system_backend_spring.dto.custom.impl.ItemDto;
import lk.ijse.pos_system_backend_spring.entity.impl.Item;
import lk.ijse.pos_system_backend_spring.exception.DataPersistException;
import lk.ijse.pos_system_backend_spring.service.ItemService;
import lk.ijse.pos_system_backend_spring.util.AppUtil;
import lk.ijse.pos_system_backend_spring.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDto dto) {
        dto.setItemCode(AppUtil.generateItemId());
        Item itemEntity = mapping.toItemEntity(dto);

        Item savedItem = itemDao.save(itemEntity);
        if (savedItem == null) {
            throw new DataPersistException("Item not saved");
        }
    }

    @Override
    public ItemStatus getItemById(String itemCode) {
        if (itemDao.existsById(itemCode)) {
            Item selectedItem = itemDao.getReferenceById(itemCode);
            return mapping.toItemDto(selectedItem);
        } else {
            return new SelectedItemErrorStatus(2, "Selected Item not found");
        }
    }

    @Override
    public List<ItemDto> getAllItems() {
        List<Item> allItems = itemDao.findAll();
        return mapping.asItemDto(allItems);
    }

    @Override
    public void updateItem(String itemCode, ItemDto itemDto) {

    }

    @Override
    public void deleteItem(String itemCode) {

    }
}
