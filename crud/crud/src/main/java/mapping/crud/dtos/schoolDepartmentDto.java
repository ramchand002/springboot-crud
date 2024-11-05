package mapping.crud.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import mapping.crud.entity.School;
import mapping.crud.enums.DepartmentEnum;
import mapping.crud.enums.SchoolEnum;

@Getter
@Setter
public class schoolDepartmentDto {

	private Long id;
	private DepartmentEnum name;	
	private String detail;
	private Long schoolId;
}
