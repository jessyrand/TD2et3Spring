package school.hei.td2and3spring.controller;

import org.springframework.web.bind.annotation.*;
import school.hei.td2and3spring.entity.Student;
import school.hei.td2and3spring.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name){
        return "Welcome "+name+"!";
    }

    @PostMapping("/students")
    public String createStudents(@RequestBody List<Student> students){
        List<Student> result = new ArrayList<>();

        for (Student student : students){
            result = studentService.save(student);
        }

        return result
                .stream()
                .map(s->s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.joining("\n"));
    }
}
