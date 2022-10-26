package edu.miu.assessmentservice.controller;


import edu.miu.assessmentservice.domain.entity.Assessment;
import edu.miu.assessmentservice.domain.entity.Question;
import edu.miu.assessmentservice.domain.enums.AssessmentType;
import edu.miu.assessmentservice.domain.factory.AssessmentFactory;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class AssessmentControllerRestAssuredTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8083);
        RestAssured.baseURI = "http://localhost/";
        RestAssured.basePath = "assessments";
    }

    @Test
    public void testfindByAssessNumber() {

        Question question1 = new Question();
        Question question2 = new Question();
        Question question3 = new Question();
        List<Question> questions = Arrays.asList(question1, question2, question3);
        Assessment assessment = AssessmentFactory.assessmentFactory("FPP QUIZ 1", AssessmentType.QUIZ, 0.25, questions,2);
        given()
                .contentType("application/json")
                .body(assessment)
                .when().post("/CS22001/QUIZ1/QUIZ/0.25").then()
                .statusCode(200);
        // test getting the Customer
        given()
                .when()
                .get("/ASS202200001")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("title", equalTo("FPP QUIZ 1"))
                .body("assessmentType", equalTo(AssessmentType.QUIZ))
                .body("percentage", equalTo(0.25));
        // cleanup
        given()
                .when()
                .delete("/ASS202200001");
    }


}

