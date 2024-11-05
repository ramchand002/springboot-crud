package mapping.crud.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mapping.crud.enums.DepartmentEnum;
import mapping.crud.enums.SchoolEnum;

@Entity
@Table(name = "school_department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties("school")

public class SchoolDepartment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	@Enumerated(EnumType.STRING)
	private DepartmentEnum name;
	
	@Column(name = "detail")
	private String detail;
	
	@ManyToOne
	@JoinColumn(name = "school_id", referencedColumnName = "id", nullable = false)
	private School school;

}
