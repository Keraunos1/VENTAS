package practice.app.ventas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import practice.app.ventas.model.bd.Product;
import practice.app.ventas.repository.ProductRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ProductService implements IProductService{
    private ProductRepository productRepository;
    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public void registerProduct(Product product) {
        productRepository.save(product);
    }
}
