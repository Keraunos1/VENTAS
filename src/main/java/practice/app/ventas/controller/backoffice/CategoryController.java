package practice.app.ventas.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import practice.app.ventas.model.bd.Category;
import practice.app.ventas.service.ICategoryService;

import java.util.List;

@Controller
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryController {
    private ICategoryService iCategoryService;
    @GetMapping("/list")
    public String listarCategorias(Model model){
        model.addAttribute("categorias",
                iCategoryService.listarCategorias());
        return "backoffice/category/frmcategory";
    }
    @GetMapping("/get")
    @ResponseBody
    public List<Category> listCategory(){
        return iCategoryService.listarCategorias();
    }
}
