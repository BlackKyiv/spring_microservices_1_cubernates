package com.naukma.intropoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller("/app")
public class MainController {

    @GetMapping("/")
    public String test() {
        return "Hello!";
    }
}
