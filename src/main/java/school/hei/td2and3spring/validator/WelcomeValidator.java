package school.hei.td2and3spring.validator;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class WelcomeValidator {

    public void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Le paramètre name est requis."
            );
        }
    }
}
