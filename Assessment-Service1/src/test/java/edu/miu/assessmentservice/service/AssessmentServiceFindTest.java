package edu.miu.assessmentservice.service;

import edu.miu.assessmentservice.domain.entity.Assessment;
import edu.miu.assessmentservice.domain.enums.AssessmentType;
import edu.miu.assessmentservice.dto.AssessmentDto;
import edu.miu.assessmentservice.repository.IAssessmentRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class AssessmentServiceFindTest {

    private static Assessment assessment ;

    @InjectMocks
    private AssessmentService assessmentService;

    @Mock
    private IAssessmentRepository assessmentRepository;

    @Before
    public void setUp() throws Exception {
        String assessmentNumber = "ASS202200001";
        assessment = new Assessment("FPP QUIZ 1", AssessmentType.QUIZ, 0.25, 2);
        assessment.setAssessNumber(assessmentNumber);
        List<Assessment> assessments = new ArrayList<>();
        assessments.add(assessment);
        Mockito.when(assessmentRepository.findByAssessNumber(assessmentNumber)).thenReturn(assessments);
    }
    @After
    public void tearDown() throws Exception {
        assessment = null;
    }

    @Test
    public void findByAssessNumber() {
        String assessmentNumber = "ASS202200001";
        List<AssessmentDto> foundDtos = assessmentService.findByAssessNumber(assessmentNumber);
        assertEquals(foundDtos.get(0).getAssessNumber(), assessmentNumber);
    }


}