package com.nadine.school;

import com.nadine.school.client.StudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;
    private final StudentClient studentClient;

    public void SaveSchool(School school){
        repository.save(school);
    }

    public List<School> findAllSchool(){
        return repository.findAll();
    }


    public FullShcoolResponse findAllSchoolsWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId).
                orElse(
                        School.builder().
                                name("NOT_FOUND").
                                email("NOT_FOUND").
                                build());
        var students = studentClient.findAllStudentsBySchool(schoolId); //find all students from student micro-service
        return FullShcoolResponse.builder().
                name(school.getName()).
                email(school.getEmail()).
                students(students).
                build();
    }
}
