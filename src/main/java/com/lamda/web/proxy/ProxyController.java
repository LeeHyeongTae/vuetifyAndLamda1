package com.lamda.web.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/proxy")
public class ProxyController{
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired Proxy pxy;

    @PostMapping("/bugsmusic")
    public HashMap<String, Object> bugsmusic(@RequestBody String searchWord){
        pxy.println("넘어온 키워드: "+searchWord);
        box.clear();
        ArrayList<HashMap<String, String>> list = crawler.bugsMusic();
        box.put("list", list);
        pxy.println("***********************");
        pxy.println("조회한 수: "+list.size());
        box.put("count", list.size());
        return box.get();
    }

    @GetMapping("/crawler")
    public ArrayList<HashMap<String, String>> crawler(){
        return crawler.bugsMusic();
    }
}
