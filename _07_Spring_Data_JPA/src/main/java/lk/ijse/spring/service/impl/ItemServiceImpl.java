package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void saveItem(ItemDTO itemDTO) {
        if(itemRepo.existsById(itemDTO.getId())) {
            throw new RuntimeException("Item already exists!");
        }
        itemRepo.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        if(!itemRepo.existsById(itemDTO.getId())) {
            throw new RuntimeException("Item is not exists!");
        }
        itemRepo.save(modelMapper.map(itemDTO, Item.class));
    }

    @Override
    public void deleteItem(String id) {
        if (!itemRepo.existsById(id)) {
            throw new RuntimeException("Item is not exists!");
        }
        itemRepo.deleteById(id);
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() {
        List<Item> items = itemRepo.findAll();
        ArrayList<ItemDTO> itemDTOS = modelMapper.map(items, new TypeToken<ArrayList<ItemDTO>>(){}.getType());
        return itemDTOS;
    }
}
