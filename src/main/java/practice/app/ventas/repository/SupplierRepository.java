package practice.app.ventas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import practice.app.ventas.model.bd.Supplier;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
