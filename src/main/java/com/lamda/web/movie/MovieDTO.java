package com.lamda.web.movie;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MovieDTO {
    String movieSeq, rank, title, rankDate;
}