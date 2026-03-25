package school.hei.td2and3spring.service;

import org.springframework.stereotype.Service;
import school.hei.td2and3spring.entity.Student;
import school.hei.td2and3spring.validator.StudentValidator;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final StudentValidator studentValidator;
    private List<Student> studentsInMemory = new ArrayList<>();

    public StudentService(StudentValidator studentValidator) {;
        this.studentValidator = studentValidator;
    }

    public List<Student> getAll(){
        return studentsInMemory;
    }

    public List<Student> saveStudents(List<Student> newStudents){
        studentValidator.validate(newStudents);
        studentsInMemory.addAll(newStudents);
        return studentsInMemory;
    }
}