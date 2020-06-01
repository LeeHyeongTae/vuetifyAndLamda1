package com.lamda.web.movie;

import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data @Lazy @Component @Entity
public class Movie {
    public Movie() { }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long movieNo;
    @Column(length = 4) private  String seq;
    @Column(length = 40) private  String title;
    @Column(length = 40) private  String date;

    @Builder
    public Movie(String seq,String title, String date) {
        this.seq = seq;
        this.title = title;
        this.date = date;}

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
