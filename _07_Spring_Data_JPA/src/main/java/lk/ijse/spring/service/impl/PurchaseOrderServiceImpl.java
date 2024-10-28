package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.OrderDto;
import lk.ijse.spring.entity.Item;
import lk.ijse.spring.entity.OrderDetail;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.service.PurchaseOrderSevice;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderSevice {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public void savePurchaseOrder(OrderDto orderDto) {
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
    }
}
