package com.naukma.intropoint;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;

@RestController
@Controller
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String test() {
        return "Hello I'm intro-point!";
    }

    @GetMapping("/user/random")
    public String writeUser() {
        Object user = restTemplate.getForObject("http://localhost:8002/utility/user-random", Object.class);
        String id = user.toString().split("id=")[1].split(",")[0];
        try {
            Converter.toJSON(id, user);
            return "File 'user" + id + ".json' is  created!";
        } catch (IOException e) {
            return "Something went wrong...";
        }
    }

    @GetMapping("/dog/random")
    public String writeDog() {
        Object dog = restTemplate.getForObject("http://localhost:8002/utility/dog-random", Object.class);
        String id = dog.toString().split("id=")[1].split(",")[0];
        try {
            Converter.toJSON(id, dog);
            return "File 'dog" + id + ".json' is  created!";
        } catch (IOException e) {
            return "Something went wrong...";
        }
    }

    @GetMapping("/user/{id}")
    public String readUser(@PathVariable String id) {
        String path = "user" + id + ".json";
        try {
            return "User: " + Converter.toJavaObject(path);
        } catch (IOException e) {
            return "User with id:" + id + " not found.";
        }
    }

    @GetMapping("/dog/{id}")
    public String readDog(@PathVariable String id) {
        String path = "dog" + id + ".json";
        try {
            return "Dog: " + Converter.toJavaObject(path);
        } catch (IOException e) {
            return "Dog with id:" + id + " not found.";
        }
    }
}
