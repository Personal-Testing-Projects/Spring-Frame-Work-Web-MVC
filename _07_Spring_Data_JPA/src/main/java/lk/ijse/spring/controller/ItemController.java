package lk.ijse.spring.controller;

import lk.ijse.spring.dto.ItemDTO;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemService itemService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseUtil saveItem(@RequestBody ItemDTO itemDTO) {
        return new ResponseUtil("OK", itemDTO.getId() + " : successfully Added!",null);
    }

    @PutMapping
    public ResponseUtil updateItem(@RequestBody ItemDTO itemDTO) {
        return new ResponseUtil("OK", itemDTO.getId() + " : successfully Updated!",null);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil deleteItem(@RequestParam("id") String id) {
        return new ResponseUtil("OK", id + " : successfully Deleted!",null);
    }

    @GetMapping
    public ResponseUtil getAllItem() {
        return new ResponseUtil("OK", "All Items", itemService.getAllItem());
    }
}
