package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetailDTO {
    private String oid;
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;
}
