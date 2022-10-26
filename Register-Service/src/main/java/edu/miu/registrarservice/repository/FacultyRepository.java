package edu.miu.registrarservice.repository;



import edu.miu.registrarservice.domain.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByFacultyNumber(String facultyNumber);
}
