package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveItem(@RequestBody ItemDTO itemDTO) {
        if(itemRepo.existsById(itemDTO.getId())) {
            throw new RuntimeException("Item already exists!");
        }
        itemRepo.save(modelMapper.map(itemDTO, Item.class));
        return new ResponseUtil("OK", itemDTO.getId() + " : successfully Added!",null);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        if(!itemRepo.existsById(itemDTO.getId())) {
            throw new RuntimeException("Item is not exists!");
        }
        itemRepo.save(modelMapper.map(itemDTO, Item.class));
        return new ResponseUtil("OK", itemDTO.getId() + " : successfully Updated!",null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteItem(@RequestParam("id") String id) {
        if (!itemRepo.existsById(id)) {
            throw new RuntimeException("Item is not exists!");
        }
        itemRepo.deleteById(id);
        return new ResponseUtil("OK", id + " : successfully Deleted!",null);
    }

    @GetMapping
    public ResponseUtil getAllItem() {
        List<Item> items = itemRepo.findAll();
        ArrayList<ItemDTO> itemDTOS = modelMapper.map(items, new TypeToken<ArrayList<ItemDTO>>(){}.getType());
        return new ResponseUtil("OK", "All Items", itemDTOS);
    }
}
