package com.lamda.web.movie;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data @Lazy @Component @Entity(name = "movie")
public class Movie {
    public Movie() { }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long movieNo;
    @Column(length = 4, nullable = false) private  String seq;
    @Column(length = 40, nullable = false) private  String title;

    @Builder
    public Movie(String seq,String title) {
        this.seq = seq;
        this.title = title; }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public Long getMovieNo() {
        return movieNo;
    }

    public void setMovieNo(Long movieNo) {
        this.movieNo = movieNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
