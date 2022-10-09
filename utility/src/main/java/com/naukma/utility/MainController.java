package com.naukma.utility;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utility")
public class MainController {

    @GetMapping("/")
    public String test() {
        return "Hello I'm Utility!";
    }

    @GetMapping("/user-random")
    public Object generateRandomUser() throws Exception {
        return UtilityService.createRandomUser();
    }

    @GetMapping("/dog-random")
    public Object generateRandomDog() throws Exception {
        return UtilityService.createRandomDog();
    }
}
