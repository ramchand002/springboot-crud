package mapping.crud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mapping.crud.dtos.schoolDepartmentDto;
import mapping.crud.dtos.schoolSaveUpdateDto;
import mapping.crud.entity.School;
import mapping.crud.entity.SchoolDepartment;

@Service
public interface SchoolService {
  List<School> getSchools();
  School getSchoolById(long id);
  School saveUpdateSchool(schoolSaveUpdateDto scl);
  long deleteSchool(long id);
  SchoolDepartment saveSchoolDepartment(schoolDepartmentDto dto);
}
