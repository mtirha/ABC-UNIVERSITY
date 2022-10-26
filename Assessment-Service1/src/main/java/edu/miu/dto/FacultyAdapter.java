package edu.miu.dto;


import edu.miu.assessmentservice.domain.entity.Faculty;

public class FacultyAdapter {

    public static Faculty toFaculty(FacultyDto facultyDto) {
        Faculty faculty = new Faculty();
        if(faculty != null){
            faculty.setId(facultyDto.getId());
            faculty.setFacultyNumber(facultyDto.getFacultyNumber());
            faculty.setFacultyName(facultyDto.getFacultyName());
        }
        return faculty;
    }
}
