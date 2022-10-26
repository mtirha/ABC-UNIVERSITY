package edu.miu.adminservice.service;

import edu.miu.adminservice.entity.Faculty;
import edu.miu.adminservice.integration.FacultySender;
import edu.miu.adminservice.repository.FacultyRepository;
import edu.miu.dto.FacultyAdapter;
import edu.miu.dto.FacultyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FacultyService implements IUserService<Faculty> {

	@Autowired
	private FacultyRepository faultyRepository;

	@Autowired
	private FacultySender facultySender;

	@Override
	public Faculty add(Faculty faculty) {
		String lastNumber = faultyRepository.findLastUserNumber();
		String  number = Faculty.GenerateNumber(lastNumber, "fac");
		faculty.setUserNumber(number);
		faultyRepository.save(faculty);

		FacultyDto facultyDto = FacultyAdapter.toFacultyDto(faculty);
		facultySender.send(facultyDto);

		return faculty;
	}
	@Override
	public Faculty update(String userNumber, Faculty faculty) {
		Faculty updated = faultyRepository.findByUserNumber(userNumber);
		if(faculty != null){
			updated.setDepartment(faculty.getDepartment());
			updated.setHiredDate(faculty.getHiredDate());
			updated.setSalary(faculty.getSalary());
			updated.setAddress(faculty.getAddress());
			updated.setEmail(faculty.getEmail());
			updated.setFirstName(faculty.getFirstName());
			updated.setPhone_number(faculty.getPhone_number());
			updated.setLastName(faculty.getLastName());
			faultyRepository.save(updated);

			FacultyDto facultyDto = FacultyAdapter.toFacultyDto(updated);
			facultySender.send(facultyDto);
		}
		return updated;
	}

	@Override
	public List<Faculty> getAll() {
		return faultyRepository.findAll();
	}

	@Override
	public Faculty getByUserNumber(String userNumber) {
		return faultyRepository.findByUserNumber(userNumber);
	}

}














