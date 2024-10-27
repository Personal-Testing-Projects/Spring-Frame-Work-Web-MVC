package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
