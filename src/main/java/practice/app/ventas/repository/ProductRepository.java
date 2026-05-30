package practice.app.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.app.ventas.model.bd.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
