package mapping.crud.services.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapping.crud.dtos.schoolDepartmentDto;
import mapping.crud.dtos.schoolSaveUpdateDto;
import mapping.crud.entity.School;
import mapping.crud.entity.SchoolAddress;
import mapping.crud.entity.SchoolDepartment;
import mapping.crud.repository.SchoolAddressRepository;
import mapping.crud.repository.SchoolDepartmentRepository;
import mapping.crud.repository.SchoolRepository;
import mapping.crud.services.SchoolService;

@Service
public class SchoolServiceImpl implements SchoolService {
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private SchoolAddressRepository schoolAddressRepository;
	
	@Autowired
	private SchoolDepartmentRepository schoolDepartmentRepository;

	@Override
	public List<School> getSchools() {
		// TODO Auto-generated method stub
		List<School> ssList = schoolRepository.findAll();
		return ssList;
	}

	@Override
	public School getSchoolById(long id) {
		// TODO Auto-generated method stub
	    Optional<School> ssList =	schoolRepository.findById(id);
		return ssList.orElse(null);
	}

	@Override
	public School saveUpdateSchool(schoolSaveUpdateDto scl) {
		// TODO Auto-generated method stub
		School sc = new School();
		if (Objects.nonNull(scl.getId()) && scl.getId() > 0) {
			sc = schoolRepository.findById(scl.getId()).orElseThrow(null);
		}
		sc.setId(scl.getId());
		sc.setCreatedDate(scl.getCreatedDate());
		sc.setName(scl.getName());
		sc.setTypEnum(scl.getTypEnum());
		sc.setUpdatedDate(scl.getUpdatedDate());
  		School sccSchool = schoolRepository.save(sc);
  		saveSchoolAddress(scl, sccSchool);
		return sccSchool;
	}

	@Override
	public long deleteSchool(long id) {
		// TODO Auto-generated method stub
		schoolRepository.deleteById(id);
		return id;	
	}
	
	private SchoolAddress saveSchoolAddress(schoolSaveUpdateDto dto, School scc) { 
		SchoolAddress sd = new SchoolAddress();
		if (Objects.nonNull(scc.getAddress())) {
			sd = schoolAddressRepository.findById(scc.getAddress().getId()).orElseThrow(null);
		}
		if (sd != null) {
			sd.setAddress(dto.getAddress());
			sd.setCity(dto.getCity());
			sd.setState(dto.getState());
			sd.setSchool(scc);
			return schoolAddressRepository.save(sd);
		} else {
			SchoolAddress msa = new SchoolAddress();
			msa.setAddress(dto.getAddress());
			msa.setCity(dto.getCity());
			msa.setState(dto.getState());
			msa.setSchool(scc);
			return schoolAddressRepository.save(msa);
		}
	}

	@Override
	public SchoolDepartment saveSchoolDepartment(schoolDepartmentDto dto) {
		// TODO Auto-generated method stub
		School scc = schoolRepository.findById(dto.getSchoolId()).orElseThrow(null);
		SchoolDepartment obj = new SchoolDepartment();
		obj.setId(dto.getId());
		obj.setDetail(dto.getDetail());
		obj.setName(dto.getName());
		obj.setSchool(scc);
		return schoolDepartmentRepository.save(obj);
		//return null;
	}

}

