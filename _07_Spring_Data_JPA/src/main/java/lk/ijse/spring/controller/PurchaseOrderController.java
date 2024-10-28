package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrderDto;
import lk.ijse.spring.service.PurchaseOrderSevice;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/purchase")
@CrossOrigin
public class PurchaseOrderController {
    @Autowired
    private PurchaseOrderSevice purchaseOrderSevice;
    @PostMapping
    public ResponseUtil purchaseOrder(@RequestBody OrderDto orderDto) {
        purchaseOrderSevice.savePurchaseOrder(orderDto);
        return new ResponseUtil("OK", "Order Successfully Added!", null);
    }
}
