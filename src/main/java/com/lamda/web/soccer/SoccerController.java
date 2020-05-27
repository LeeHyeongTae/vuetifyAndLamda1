package com.lamda.web.soccer;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("/soccer")
public class SoccerController {

    @GetMapping("/database/{command}")
    public String database(@PathVariable String command){
        System.out.println(command);
        return command;
    }
}
