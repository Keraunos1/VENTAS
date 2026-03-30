package practice.app.ventas.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import practice.app.ventas.model.bd.Category;
import practice.app.ventas.repository.CategoryRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService implements ICategoryService{

    private CategoryRepository categoryRepository;
    @Override
    public List<Category> listarCategorias() {
        return categoryRepository.findAll();
    }
}
