package mapping.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mapping.crud.entity.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {

}
