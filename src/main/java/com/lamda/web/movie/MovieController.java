package com.lamda.web.movie;

import com.lamda.web.mappers.MovieMapper;
import com.lamda.web.proxy.Box;
import com.lamda.web.proxy.IFunction;
import com.lamda.web.proxy.Pager;
import com.lamda.web.proxy.Proxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired Pager pager;
    @Autowired MovieMapper movieMapper;
    @Autowired Proxy pxy;
    @Autowired Box<Object> box;

    @GetMapping("/list/{pageNumber}/{searchWord}")
    public List<MovieDTO> list(@PathVariable("pageNumber") String pageNumber,
                               @PathVariable("searchWord") String searchWord){
        if(searchWord.equals("")){
            pxy.println("검색어가 없음");
        }else{
            pxy.println(("검색어 : "+searchWord));
        }
        pager.setNowPage(pxy.integer(pageNumber));
        pager.setBlockSize(5);
        pager.setPageSize(5);
        IFunction<Pager, List<MovieDTO>> f = p -> movieMapper.selectMovies(p);
        List<MovieDTO> l = f.apply(pager);
        pxy.print(l.get(0).toString());
      return l;
    }
}

