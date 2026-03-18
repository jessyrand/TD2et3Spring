package school.hei.td2and3spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.hei.td2and3spring.entity.Student;
import school.hei.td2and3spring.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam String name){
        if(name == null || name.isBlank()){
            return ResponseEntity
                    .status(400)
                    .body("Le parametre name est requis.");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("welcome " + name);
    }

    @PostMapping("/students")
    public ResponseEntity<?> createStudents(@RequestBody List<Student> students){
        try {
            for (Student student : students){
                studentService.save(student);
            }

            return ResponseEntity.status(201).body(studentService.getAll());

        } catch (Exception e){
            return ResponseEntity
                    .status(500).body("Internal Server Error");
        }

    }

    @GetMapping("/students")
    public String getStudents(@RequestHeader(value = "Accept", defaultValue = "text/plain") String acceptHeader){
        if(!acceptHeader.equalsIgnoreCase("text/plain")){
            return "Format non supporté.";
        }

        return studentService.getAll()
                .stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.joining("\n"));
    }
}
