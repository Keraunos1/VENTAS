package practice.app.ventas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import practice.app.ventas.model.bd.Supplier;
import practice.app.ventas.repository.SupplierRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class SupplierService implements ISupplierService{
    private SupplierRepository supplierRepository;
    @Override
    public List<Supplier> listSuppliers() {
        return supplierRepository.findAll();
    }
}
