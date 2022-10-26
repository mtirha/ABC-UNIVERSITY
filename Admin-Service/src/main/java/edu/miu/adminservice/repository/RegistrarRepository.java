package edu.miu.adminservice.repository;


import edu.miu.adminservice.entity.Registrar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface RegistrarRepository extends JpaRepository<Registrar, Long> {

    Registrar findByUserNumber(String userNumber);

    @Query(value = "select max(user_number) from registrar", nativeQuery = true)
    String findLastUserNumber();
}
