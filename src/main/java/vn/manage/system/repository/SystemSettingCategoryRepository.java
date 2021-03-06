package vn.manage.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.manage.system.models.SystemSettingCategory;

@Repository
public interface SystemSettingCategoryRepository extends JpaRepository<SystemSettingCategory, Integer> {
}
