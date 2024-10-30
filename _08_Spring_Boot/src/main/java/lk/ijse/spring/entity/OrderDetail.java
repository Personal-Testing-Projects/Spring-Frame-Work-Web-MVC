package lk.ijse.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(OrderItem_PK.class)
public class OrderDetail {
    @Id
    private String oid;
    @Id
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;

    //Out-Verse
    @ManyToOne
    @JoinColumn(name = "oid",referencedColumnName = "oid",insertable = false,updatable = false)
    private Orders orders;

    //Out-verse
    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "id",insertable = false,updatable = false)
    private Item items;
}