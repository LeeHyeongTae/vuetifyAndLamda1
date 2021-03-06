package com.lamda.web.movie;

import com.lamda.web.mappers.MovieMapper;
import com.lamda.web.proxy.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;
    @Autowired MovieRepository movieRepository;
    @Autowired Crawler crawler;

    @GetMapping("/{searchWord}/{pageNumber}")
    public Map<?,?> list(@PathVariable("searchWord") String searchWord,
                        @PathVariable("pageNumber") String pageNumber){
        if(searchWord.equals("null")){
            pxy.println("검색어가 없음");
            pager.setSearchWord("");
        }else{
            pxy.println(("검색어 : "+searchWord));
            pager.setSearchWord(searchWord);
        }
        pxy.println("넘어온 페이지번호: "+pageNumber);
        pager.setNowPage(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        pager.paging();
        Function<Pager, List<MovieDTO>> f = p -> movieMapper.selectMovies(p);
        List<MovieDTO> l = f.apply(pager);
        for(MovieDTO m : l){
            pxy.println(m.toString());
        }
        box.clear();
        box.put("pager", pager);
        box.put("list", l);
      return box.get();
    }
    @GetMapping("/{seq}")
    public MovieDTO detail(@PathVariable String seq){
        return movieMapper.selectMovie(seq);
    }
}

