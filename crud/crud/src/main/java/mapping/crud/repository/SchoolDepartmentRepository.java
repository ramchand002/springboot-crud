package mapping.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mapping.crud.entity.SchoolDepartment;

public interface SchoolDepartmentRepository extends JpaRepository<SchoolDepartment, Long> {

}
