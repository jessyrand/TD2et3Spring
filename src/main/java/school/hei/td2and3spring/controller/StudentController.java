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
    public ResponseEntity<?> getStudents(@RequestHeader(value = "Accept", defaultValue = "text/plain") String acceptHeader){
        try {
            if(acceptHeader == null || acceptHeader.isBlank()){
                return ResponseEntity
                        .status(400)
                        .body("L'entete Accept est requise");
            }
            if(!(acceptHeader.equalsIgnoreCase("application/json"))){
                return ResponseEntity
                        .status(501)
                        .body("Format non supporté.");
            }
            return ResponseEntity
                    .status(200)
                    .body(studentService.getAll());
        } catch (Exception e){
            return ResponseEntity
                    .status(500).body("Internal Server Error");
        }

    }
}