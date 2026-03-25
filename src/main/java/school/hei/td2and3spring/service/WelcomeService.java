package school.hei.td2and3spring.service;

import org.springframework.stereotype.Service;
import school.hei.td2and3spring.validator.WelcomeValidator;

@Service
public class WelcomeService {

    private final WelcomeValidator welcomeValidator;

    public WelcomeService(WelcomeValidator welcomeValidator) {
        this.welcomeValidator = welcomeValidator;
    }

    public String getWelcomeMessage(String name) {
        welcomeValidator.validate(name);
        return "welcome " + name;
    }
}