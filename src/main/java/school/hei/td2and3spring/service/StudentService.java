package school.hei.td2and3spring.service;

import org.springframework.stereotype.Service;
import school.hei.td2and3spring.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    public List<Student> getAll(){
        return students;
    }

    public List<Student> save(Student student){
        students.add(student);
        return students;
    }
}