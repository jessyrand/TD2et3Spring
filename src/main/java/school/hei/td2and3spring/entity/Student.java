package school.hei.td2and3spring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Student {
    private String reference;
    private String firstName;
    private String lastName;
    private Integer age;
}
