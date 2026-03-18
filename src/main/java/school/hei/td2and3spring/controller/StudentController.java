package school.hei.td2and3spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.td2and3spring.service.StudentService;

@RestController
public class StudentController {

    private StudentService studentService;

    @GetMapping("/welcome")
    public String welcome(@RequestParam String name){
        return "Welcome "+name+"!";
    }
}
