package edu.miu.registrarservice.service;


import edu.miu.dto.FacultyDto;
import edu.miu.registrarservice.domain.Faculty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface IFacultyService {

	Faculty handleRecord(FacultyDto facultyDto);

}














