package mapping.crud.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.experimental.var;
import mapping.crud.dtos.schoolDepartmentDto;
import mapping.crud.dtos.schoolSaveUpdateDto;
import mapping.crud.entity.School;
import mapping.crud.entity.SchoolDepartment;
import mapping.crud.services.SchoolService;

@RestController
@RequestMapping("/api/school")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;

	@Value("${myname.file.code}")
	private String myValString;
	
	@GetMapping("list")
	public List<School> getSchools() {
		List<School> list = schoolService.getSchools();
		return list;
	}
	
	@GetMapping("{id}")
	public School getSchools(@PathVariable Long id) {
		System.out.println(myValString);
		School list = schoolService.getSchoolById(id);
		return list;
	}
	
	@PostMapping("save")
	public School saveUpdate(@RequestBody schoolSaveUpdateDto scl) {
		School sc = schoolService.saveUpdateSchool(scl);
		return sc;
	}
	
	
	@DeleteMapping("delete/{md}")
	public long deleteSchool(@PathVariable Long md) {
		long ids = schoolService.deleteSchool(md);
		return ids;
	}
	
	@GetMapping("ss")
	public School getSchoolsPar(@RequestParam Long id, @RequestParam String type) {
		System.out.println(id + "   " +  type);
		School list = schoolService.getSchoolById(id);
		return list;
	}
	
	@PostMapping("department")
	public SchoolDepartment saveSchoolDep(@RequestBody schoolDepartmentDto dto) {
		return schoolService.saveSchoolDepartment(dto);
	}
}
