package practice.app.ventas.service;

import practice.app.ventas.model.bd.Product;

import java.util.List;

public interface IProductService {
    List<Product> listProducts();
    void registerProduct(Product product);
}
