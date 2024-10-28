package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrderDetailDTO;
import lk.ijse.spring.dto.OrderDto;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetail;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.util.ResponseUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class PurchaseOrderController {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    public ResponseUtil purchaseOrder(@RequestBody OrderDto orderDto) {
        Orders orders = modelMapper.map(orderDto, Orders.class);
        if(orderRepo.existsById(orderDto.getOid())) {
            throw new RuntimeException("Order already exists!");
        }
        orderRepo.save(orders);
        for (OrderDetail orderDetail : orders.getOrderDetails()) {
            Item item = itemRepo.findById(orderDetail.getItemCode()).get();
            item.setQty(item.getQty() - orderDetail.getQty());
            itemRepo.save(item);
        }
        return new ResponseUtil("OK", "Order Successfully Added!", null);
    }
}
