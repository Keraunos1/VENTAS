package practice.app.ventas.bd;

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
    @Column(name = "reorderlever")
    private Integer reorderlever;
    @Column(name = "discontinued")
    private Boolean discontinued;
    @ManyToOne
    @JoinColumn(name = "supplierid")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
