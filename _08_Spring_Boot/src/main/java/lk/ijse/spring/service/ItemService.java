package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemDTO;

import java.util.ArrayList;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem(ItemDTO itemDTO);
    void deleteItem(String id);
    ArrayList<ItemDTO> getAllItem();
}
