package practice.app.ventas.model.bd;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productid;
    @Column(name = "productname")
    private String productname;
    @Column(name = "quantityperunit")
    private String quantityperunit;
    @Column(name = "unitprice")
    private Double unitprice;
    @Column(name = "unitsinstock")
    private Integer unitsinstock;
    @Column(name = "unitsonorder")
    private Integer unitsonorder;
    @Column(name = "reorderlevel")
    private Integer reorderlevel;
    @Column(name = "discontinued")
    private Boolean discontinued;
    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;
}
