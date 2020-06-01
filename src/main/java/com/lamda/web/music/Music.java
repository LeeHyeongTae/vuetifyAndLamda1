package com.lamda.web.music;

import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;


@ToString
@NoArgsConstructor
@Setter
@Getter
@Entity
@Lazy
public class Music {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long musicNo;
    @Column(length = 4) private  String seq;
    @Column(length = 50) private  String title;
    @Column(length = 80) private  String artist;
    @Column(length = 200) private  String thumbnail;
}
