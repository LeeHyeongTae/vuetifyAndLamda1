package com.lamda.web.mappers;

import com.lamda.web.movie.MovieDTO;
import com.lamda.web.proxy.Pager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieMapper {
    int insertMovie(MovieDTO movie);
//  void updateMovie(MovieDTO movie);
//  void deleteMovie(String rank);
    List<MovieDTO> selectMovies(Pager pager);
    int countMovies();
    MovieDTO selectMovie(String p);
}
