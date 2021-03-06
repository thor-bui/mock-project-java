package vn.manage.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.manage.system.models.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findByNameIn(List<String> name);

	boolean existsByName(String name);
}
