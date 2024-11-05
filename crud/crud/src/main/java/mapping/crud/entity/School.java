package mapping.crud.entity;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mapping.crud.enums.SchoolEnum;

@Entity
@Table(name = "school")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class School {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private SchoolEnum typEnum;
	
	@Column(name = "create_date")
	private LocalDateTime CreatedDate;
	
	@Column(name = "update_date")
	private LocalDateTime UpdatedDate;
	
	@OneToOne(mappedBy = "school", cascade = CascadeType.ALL)
	private SchoolAddress address;
	
	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
	private Set<SchoolDepartment> schoolDepartments;
}
