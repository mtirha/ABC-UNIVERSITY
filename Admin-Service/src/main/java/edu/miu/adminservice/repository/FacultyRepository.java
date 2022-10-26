package edu.miu.adminservice.repository;


import edu.miu.adminservice.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Faculty findByUserNumber(String userNumber);

    @Query(value = "select max(user_number) from faculty", nativeQuery = true)
    String findLastUserNumber();

}
