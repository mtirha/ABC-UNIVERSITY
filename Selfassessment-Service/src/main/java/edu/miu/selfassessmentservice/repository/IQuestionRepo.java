package edu.miu.selfassessmentservice.repository;


import edu.miu.selfassessmentservice.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuestionRepo extends JpaRepository<Question, Long> {
    List<Question> getQuestionsByCategoryAndSubcategory(String cat, String subcat);
}