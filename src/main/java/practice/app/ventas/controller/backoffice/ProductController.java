package practice.app.ventas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import practice.app.ventas.model.bd.Product;
import practice.app.ventas.service.IProductService;

import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {
    private IProductService iProductService;
    @GetMapping("")
    public String formProduct(Model model){
        model.addAttribute("listproduct", iProductService.listProducts());
        return "backoffice/product/formproduct";
    }
    @GetMapping("/list")
    @ResponseBody
    public List<Product> listProducts(){
        return iProductService.listProducts();
    }
    public void registerProduct(){

    }
}
