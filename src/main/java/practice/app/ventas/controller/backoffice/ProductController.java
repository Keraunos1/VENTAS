package practice.app.ventas.controller.backoffice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import practice.app.ventas.model.bd.Category;
import practice.app.ventas.model.bd.Product;
import practice.app.ventas.model.bd.Supplier;
import practice.app.ventas.model.dto.request.ProductRequest;
import practice.app.ventas.model.dto.response.ProductResponse;
import practice.app.ventas.service.IProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private IProductService iProductService;

    @GetMapping("")
    public String formProduct(Model model) {
        model.addAttribute("listproduct", iProductService.listProducts());
        return "backoffice/product/formproduct";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Product> listProducts() {
        return iProductService.listProducts();
    }
    @PostMapping("/register")
    @ResponseBody
    public ProductResponse registerProduct(@RequestBody  ProductRequest productRequest) {
        String mensaje = "Se registro el producto";
        boolean respuesta = true;
        try {
            Product product = new Product();
            if(productRequest.getProductid() > 0){
                product.setProductid(productRequest.getProductid());
            }
            product.setProductname(productRequest.getProductname());
            product.setUnitprice(productRequest.getUnitprice());
            product.setDiscontinued(productRequest.getDiscontinued());
            Category category = new Category();
            category.setCategoryid(productRequest.getCategoryid());
            product.setCategory(category);
            Supplier supplier = new Supplier();
            supplier.setSupplierid(productRequest.getSupplierid());
            product.setSupplier(supplier);
            iProductService.registerProduct(product);
        } catch (Exception ex) {
                mensaje = "Producto no registrado, error en la BD";
                respuesta = false;
        }
        return ProductResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }
}
