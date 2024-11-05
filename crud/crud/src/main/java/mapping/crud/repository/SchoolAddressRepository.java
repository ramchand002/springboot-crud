package mapping.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mapping.crud.entity.SchoolAddress;

public interface SchoolAddressRepository extends JpaRepository<SchoolAddress, Long> {

}
