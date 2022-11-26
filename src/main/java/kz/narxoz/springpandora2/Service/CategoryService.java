package kz.narxoz.springpandora2.Service;
import kz.narxoz.springpandora2.Entity.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("CategoryService")
public interface CategoryService {

    List<Category> findAllCategory();

    Category saveCategory(Category category);

    Category findCategory(Long id);

    void deleteCategory(Long id);


}
