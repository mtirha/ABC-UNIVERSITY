package edu.miu.assessmentservice.service;


import edu.miu.dto.FacultyDto;
import edu.miu.assessmentservice.domain.entity.Faculty;
import org.springframework.stereotype.Service;


@Service
public interface IFacultyService {

	Faculty handleRecord(FacultyDto facultyDto);

}














