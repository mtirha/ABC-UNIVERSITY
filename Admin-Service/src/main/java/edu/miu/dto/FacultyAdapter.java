package edu.miu.dto;

import edu.miu.adminservice.entity.Faculty;

public class FacultyAdapter {

    public static FacultyDto toFacultyDto(Faculty faculty) {
        FacultyDto facultyDto = new FacultyDto();
        if(faculty != null){
            facultyDto.setId(faculty.getId());
            facultyDto.setFacultyNumber(faculty.getUserNumber());
            facultyDto.setFacultyName(faculty.getFirstName() + ", " + faculty.getLastName());
        }
        return facultyDto;
    }
}
