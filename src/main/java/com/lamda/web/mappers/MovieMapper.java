package com.lamda.web.mappers;

import com.lamda.web.movie.MovieDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieMapper {
    public void insertMovie(MovieDTO movie);
    public void updateMovie(MovieDTO movie);
    public void deleteMovie(MovieDTO movie);
    public MovieDTO selectMovies();
    public int countMovies();
}
