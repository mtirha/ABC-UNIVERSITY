package edu.miu.selfassessmentservice.service;


import edu.miu.selfassessmentservice.domain.SelfAssessment;

public interface ISelfAssessmentService {
    public SelfAssessment getAssessmentById(Long id);
    public SelfAssessment generateAssessment(String category, String subcategory);
}
