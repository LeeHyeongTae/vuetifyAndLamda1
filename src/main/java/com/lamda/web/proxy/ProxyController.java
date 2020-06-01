package com.lamda.web.proxy;

import com.lamda.web.movie.Movie;
import com.lamda.web.movie.MovieRepository;
import com.lamda.web.music.Music;
import com.lamda.web.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/proxy")
public class ProxyController{
    @Autowired Box<Object> box;
    @Autowired Crawler crawler;
    @Autowired Proxy pxy;
    @Autowired FileUploader uploader;
    @Autowired MusicRepository musicRepository;
    @Autowired MovieRepository movieRepository;

    @GetMapping("/bugsmusic/{searchWord}")
    public HashMap<String, Object> bugsmusic(@PathVariable String searchWord){
        pxy.println("넘어온 키워드: "+searchWord);
        box.clear();
        if(musicRepository.count() ==0) crawler.bugsMusic();
        List<Music> list = musicRepository.findAll();
        box.put("list", list);
        box.put("count", list.size());
        return box.get();
    }

    @GetMapping("/movie/{searchWord}")
    public HashMap<String, Object> movie(@PathVariable String searchWord){
        pxy.println("넘어온 키워드 :"+searchWord);
        box.clear();
        if(movieRepository.count() == 0) crawler.naverMovie();
        List<Movie> list = movieRepository.findAll();
        box.put("list", list);
        box.put("count", list.size());
        return box.get();
    }
}
