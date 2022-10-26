package edu.miu.registrarservice.service;


import edu.miu.dto.FacultyAdapter;
import edu.miu.dto.FacultyDto;
import edu.miu.dto.StudentAdapter;
import edu.miu.registrarservice.domain.CourseOffering;
import edu.miu.registrarservice.domain.Enrollment;
import edu.miu.registrarservice.domain.Faculty;
import edu.miu.registrarservice.domain.Student;
import edu.miu.registrarservice.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FacultyService implements IFacultyService {

	@Autowired
	private FacultyRepository faultyRepository;

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














