package edu.miu.assessmentservice.repository;



import edu.miu.assessmentservice.domain.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IFacultyRepository extends JpaRepository<Faculty, Long> {
    Faculty findByFacultyNumber(String facultyNumber);
}
