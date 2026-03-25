package school.hei.td2and3spring.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import school.hei.td2and3spring.entity.Student;

import java.util.List;

@Component
public class StudentValidator {

    public void validate(List<Student> newStudents) {

        if (newStudents == null || newStudents.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La liste des étudiants ne peut pas être vide"
            );
        }

        for (Student newStudent : newStudents) {

            if (newStudent.getReference() == null || newStudent.getReference().isBlank()) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "NewStudent.reference cannot be null"
                );
            }
            if (newStudent.getFirstName() == null || newStudent.getFirstName().isBlank()) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "NewStudent.firstname cannot be null"
                );
            }
            if (newStudent.getLastName() == null || newStudent.getLastName().isBlank()) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "NewStudent.lastname cannot be null"
                );
            }
            if (newStudent.getAge() == null || newStudent.getAge().equals(0)) {
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST,
                        "NewStudent.age cannot be null"
                );
            }
        }
    }
}