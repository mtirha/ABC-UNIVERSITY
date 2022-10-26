package edu.miu.dto;


import edu.miu.registrarservice.domain.Faculty;

public class FacultyAdapter {

    public static Faculty toFaculty(FacultyDto facultyDto) {
        Faculty faculty = new Faculty();
        if(facultyDto != null){
            faculty.setId(facultyDto.getId());
            faculty.setFacultyNumber(facultyDto.getFacultyNumber());
            faculty.setFacultyName(facultyDto.getFacultyName());
        }
        return faculty;
    }
    public static FacultyDto toFacultyDto(Faculty faculty) {
        FacultyDto facultyDto = new FacultyDto();
        if(faculty != null){
            facultyDto.setId(faculty.getId());
            facultyDto.setFacultyNumber(faculty.getFacultyNumber());
            facultyDto.setFacultyName(faculty.getFacultyName());
        }
        return facultyDto;
    }
}
