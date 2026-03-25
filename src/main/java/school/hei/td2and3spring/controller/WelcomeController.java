package school.hei.td2and3spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.hei.td2and3spring.service.WelcomeService;

@RestController
public class WelcomeController {

    private final WelcomeService welcomeService;

    public WelcomeController(WelcomeService welcomeService) {
        this.welcomeService = welcomeService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome(@RequestParam String name) {
        String response = welcomeService.getWelcomeMessage(name);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
