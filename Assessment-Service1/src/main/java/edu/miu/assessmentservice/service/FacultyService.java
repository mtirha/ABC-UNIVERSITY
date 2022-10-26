package edu.miu.assessmentservice.service;


import edu.miu.dto.FacultyAdapter;
import edu.miu.dto.FacultyDto;
import edu.miu.assessmentservice.domain.entity.Faculty;
import edu.miu.assessmentservice.repository.IFacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacultyService implements IFacultyService {

	@Autowired
	private IFacultyRepository faultyRepository;

	@Override
	public Faculty handleRecord(FacultyDto facultyDto) {
		Faculty faculty = FacultyAdapter.toFaculty(facultyDto);
		Faculty updated = faultyRepository.findByFacultyNumber(faculty.getFacultyNumber());
		if(updated != null){
			updated.setFacultyName(faculty.getFacultyName());
			faultyRepository.save(updated);
		}
		else
			faultyRepository.save(faculty);
		return faculty;
	}

}














