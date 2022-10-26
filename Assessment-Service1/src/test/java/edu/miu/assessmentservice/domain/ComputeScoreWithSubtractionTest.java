package edu.miu.assessmentservice.domain;

import edu.miu.assessmentservice.domain.entity.Question;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.*;

public class ComputeScoreWithSubtractionTest {

    private Question question ;

    @Before
    public void setUp() throws Exception {
//        question = new Question();
//        ComputeScore calculator = new ComputeScoreWithSubtraction();
//        calculator.setQuestion(question);
//        question.setCalculator(calculator);
    }

    @After
    public void tearDown() throws Exception {
        question = null;
    }

    @Test
    public void computeScore1() {
        List<String> studentAnswers = Arrays.asList(new String[]{"A", "B"});
        List<String> correctAnswers = Arrays.asList(new String[]{"A", "B"});
        List<String> incorrectAnswers = Arrays.asList(new String[]{"C", "D"});
        incorrectAnswers.forEach(a -> question.getIncorrectAnswers().add(a));
        correctAnswers.forEach(a -> question.getCorrectAnswers().add(a));
        studentAnswers.forEach(a -> question.getStudentAnswers().add(a));
        question.setTotalScore(correctAnswers.size());

        assertThat(question.computeScore(), closeTo(Double.parseDouble("2.0"), 0.1));
    }
    @Test
    public void computeScore2() {
        List<String> studentAnswers = Arrays.asList(new String[]{"A"});
        List<String> correctAnswers = Arrays.asList(new String[]{"A", "B"});
        List<String> incorrectAnswers = Arrays.asList(new String[]{"C", "D"});
        incorrectAnswers.forEach(a -> question.getIncorrectAnswers().add(a));
        correctAnswers.forEach(a -> question.getCorrectAnswers().add(a));
        studentAnswers.forEach(a -> question.getStudentAnswers().add(a));
        question.setTotalScore(correctAnswers.size());

        assertThat(question.computeScore(), closeTo(Double.parseDouble("1.0"), 0.1));
    }
    @Test
    public void computeScore3() {
        List<String> studentAnswers = Arrays.asList(new String[]{"A", "C"});
        List<String> correctAnswers = Arrays.asList(new String[]{"A", "B"});
        List<String> incorrectAnswers = Arrays.asList(new String[]{"C", "D"});
        incorrectAnswers.forEach(a -> question.getIncorrectAnswers().add(a));
        correctAnswers.forEach(a -> question.getCorrectAnswers().add(a));
        studentAnswers.forEach(a -> question.getStudentAnswers().add(a));
        question.setTotalScore(correctAnswers.size());

        assertThat(question.computeScore(), closeTo(Double.parseDouble("1.0"), 0.1));
    }
    @Test
    public void computeScore4() {
        List<String> studentAnswers = new ArrayList<>();
        List<String> correctAnswers = Arrays.asList(new String[]{"A", "B"});
        List<String> incorrectAnswers = Arrays.asList(new String[]{"C", "D"});
        incorrectAnswers.forEach(a -> question.getIncorrectAnswers().add(a));
        correctAnswers.forEach(a -> question.getCorrectAnswers().add(a));
        studentAnswers.forEach(a -> question.getStudentAnswers().add(a));
        question.setTotalScore(correctAnswers.size());

        assertThat(question.computeScore(), closeTo(Double.parseDouble("0.0"), 0.1));
    }
    @Test
    public void computeScore5() {
        List<String> studentAnswers = Arrays.asList(new String[]{"A", "B", "C"});
        List<String> correctAnswers = Arrays.asList(new String[]{"A", "B"});
        List<String> incorrectAnswers = Arrays.asList(new String[]{"C", "D"});
        incorrectAnswers.forEach(a -> question.getIncorrectAnswers().add(a));
        correctAnswers.forEach(a -> question.getCorrectAnswers().add(a));
        studentAnswers.forEach(a -> question.getStudentAnswers().add(a));
        question.setTotalScore(correctAnswers.size());

        assertThat(question.computeScore(), closeTo(Double.parseDouble("1.0"), 0.1));
    }
}