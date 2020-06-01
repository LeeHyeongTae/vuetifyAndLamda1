package com.lamda.web.movie;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long movieSeq;
    @Column(length = 4) private  String rank;
    @Column(length = 40) private  String title;
    @Column(length = 40) private  String rankDate;
}
