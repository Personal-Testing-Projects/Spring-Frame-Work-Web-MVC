package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
    private String id;
    private String name;
    private int qty;
    private BigDecimal unitPrice;
}
