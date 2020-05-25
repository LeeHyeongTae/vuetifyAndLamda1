package com.lamda.web.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/proxy")
public class ProxyController {
    @Autowired Crawler crawler;

    @GetMapping("/crawler")
    public ArrayList<HashMap<String, String>> crawler(){ return crawler.bugsMusic(); }
}
