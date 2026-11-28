package practice.app.ventas.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.app.ventas.model.bd.pk.OrderDetailId;

@Data
@Entity
@Table(name = "orderdetails")
@NoArgsConstructor

public class OrderDetail {
    @EmbeddedId
    private OrderDetailId orderDetailId;
    @Column(name = "unitprice")
    private Double unitprice;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "discount")
    private Double discount;
}
