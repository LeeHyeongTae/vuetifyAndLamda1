package com.lamda.web.music;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class MusicDTO {
    private  String seq;
    private  String title;
    private  String artist;
    private  String thumbnail;
}
