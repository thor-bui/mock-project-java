package vn.manage.system.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;
import vn.manage.system.domain.CategoryRequestDto;

import javax.persistence.*;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", unique = true)
	private String name;

	@Column(name = "description")
	private String description;

	public Category(CategoryRequestDto request) {
		BeanUtils.copyProperties(request, this);
	}
}
