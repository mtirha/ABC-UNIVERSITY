package edu.miu.assessmentservice.domain;

import edu.miu.assessmentservice.domain.entity.Assessment;
import edu.miu.assessmentservice.domain.entity.Question;
import edu.miu.assessmentservice.domain.strategy.ComputeScore;
import edu.miu.assessmentservice.domain.strategy.ComputeScoreWithoutSubtraction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class AssessmentTest {

    private Assessment assessment ;
    private Question question1;
    private Question question2;

    @Before
    public void setUp() throws Exception {
        assessment = new Assessment();
        assessment.setQuestions(new ArrayList<>());

        question1 = new Question();
        ComputeScore calculator1 = new ComputeScoreWithoutSubtraction();
        calculator1.setQuestion(question1);
        question1.setCalculator(calculator1);

        question2 = new Question();
        ComputeScore calculator2 = new ComputeScoreWithoutSubtraction();
        calculator1.setQuestion(question2);
        question2.setCalculator(calculator2);
    }

    @After
    public void tearDown() throws Exception {
        assessment = null;
        question1 = null;
        question2 = null;
    }

    @Test
    public void computeScore1() {
        // QUESTION 1
        List<String> studentAnswers = Arrays.asList(new String[]{"A", "B"}); // 2/2
        List<String> correctAnswers = Arrays.asList(new String[]{"A", "B"});
        List<String> incorrectAnswers = Arrays.asList(new String[]{"C", "D"});
        incorrectAnswers.forEach(a -> question1.getIncorrectAnswers().add(a));
        correctAnswers.forEach(a -> question1.getCorrectAnswers().add(a));
        studentAnswers.forEach(a -> question1.getStudentAnswers().add(a));
        question1.setTotalScore(correctAnswers.size());
        question1.setStudentScore(question1.computeScore());
        assessment.getQuestions().add(question1);

        // QUESTION 2
        List<String> studentAnswers2 = Arrays.asList(new String[]{"A"}); // 1/2
        List<String> correctAnswers2 = Arrays.asList(new String[]{"A", "B"});
        List<String> incorrectAnswers2 = Arrays.asList(new String[]{"C", "D"});
        incorrectAnswers2.forEach(a -> question2.getIncorrectAnswers().add(a));
        correctAnswers2.forEach(a -> question2.getCorrectAnswers().add(a));
        studentAnswers2.forEach(a -> question2.getStudentAnswers().add(a));
        question2.setTotalScore(correctAnswers2.size());        ;
        question2.setStudentScore(question2.computeScore());
        assessment.getQuestions().add(question2);

        // ASSESSMENT GRADE
        assertThat(assessment.computeScore(), closeTo(Double.parseDouble("0.75"), 0.00001));
    }
    @Test
    public void computeScore2() {
        // QUESTION 1
        List<String> studentAnswers = Arrays.asList(new String[]{"A"}); // 1/2
        List<String> correctAnswers = Arrays.asList(new String[]{"A", "B"});
        List<String> incorrectAnswers = Arrays.asList(new String[]{"C", "D"});
        incorrectAnswers.forEach(a -> question1.getIncorrectAnswers().add(a));
        correctAnswers.forEach(a -> question1.getCorrectAnswers().add(a));
        studentAnswers.forEach(a -> question1.getStudentAnswers().add(a));
        question1.setTotalScore(correctAnswers.size());
        question1.setStudentScore(question1.computeScore());
        assessment.getQuestions().add(question1);

        // QUESTION 2
        List<String> studentAnswers2 = Arrays.asList(new String[]{"A"}); // 1/2
        List<String> correctAnswers2 = Arrays.asList(new String[]{"A", "B"});
        List<String> incorrectAnswers2 = Arrays.asList(new String[]{"C", "D"});
        incorrectAnswers2.forEach(a -> question2.getIncorrectAnswers().add(a));
        correctAnswers2.forEach(a -> question2.getCorrectAnswers().add(a));
        studentAnswers2.forEach(a -> question2.getStudentAnswers().add(a));
        question2.setTotalScore(correctAnswers2.size());        ;
        question2.setStudentScore(question2.computeScore());
        assessment.getQuestions().add(question2);

        // ASSESSMENT GRADE
        assertThat(assessment.computeScore(), closeTo(Double.parseDouble("0.5"), 0.00001));
    }
    @Test
    public void computeScore3() {
        // QUESTION 1
        List<String> studentAnswers = Arrays.asList(new String[]{"C", "D"}); // 0/2
        List<String> correctAnswers = Arrays.asList(new String[]{"A", "B"});
        List<String> incorrectAnswers = Arrays.asList(new String[]{"C", "D"});
        incorrectAnswers.forEach(a -> question1.getIncorrectAnswers().add(a));
        correctAnswers.forEach(a -> question1.getCorrectAnswers().add(a));
        studentAnswers.forEach(a -> question1.getStudentAnswers().add(a));
        question1.setTotalScore(correctAnswers.size());
        question1.setStudentScore(question1.computeScore());
        assessment.getQuestions().add(question1);

        // QUESTION 2
        List<String> studentAnswers2 = Arrays.asList(new String[]{"D"}); // 0/2
        List<String> correctAnswers2 = Arrays.asList(new String[]{"A", "B"});
        List<String> incorrectAnswers2 = Arrays.asList(new String[]{"C", "D"});
        incorrectAnswers2.forEach(a -> question2.getIncorrectAnswers().add(a));
        correctAnswers2.forEach(a -> question2.getCorrectAnswers().add(a));
        studentAnswers2.forEach(a -> question2.getStudentAnswers().add(a));
        question2.setTotalScore(correctAnswers2.size());        ;
        question2.setStudentScore(question2.computeScore());
        assessment.getQuestions().add(question2);

        // ASSESSMENT GRADE
        assertThat(assessment.computeScore(), closeTo(Double.parseDouble("0.0"), 0.00001));
    }
}