package kz.narxoz.springpandora2.Repository;

import kz.narxoz.springpandora2.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
