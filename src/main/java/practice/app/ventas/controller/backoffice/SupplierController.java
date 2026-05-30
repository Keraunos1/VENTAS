package practice.app.ventas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import practice.app.ventas.model.bd.Supplier;
import practice.app.ventas.service.ISupplierService;

import java.util.List;

@Controller
@RequestMapping("/supplier")
@AllArgsConstructor
public class SupplierController {
    private ISupplierService iSupplierService;
    @GetMapping("/get")
    @ResponseBody
    public List<Supplier> listSuppliers(){
        return iSupplierService.listSuppliers();
    }
}
