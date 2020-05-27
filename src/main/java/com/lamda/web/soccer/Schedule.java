package com.lamda.web.soccer;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleNo;
    @Column(length = 10, nullable = false)
    private String scheDate;
    @Column(length = 10, nullable = false)
    private String stadiumId;
    @Column(length = 10, nullable = false)
    private String gubun;
    @Column(length = 10, nullable = false)
    private String hometeamId;
    @Column(length = 10, nullable = false)
    private String awayteamId;
    @Column(length = 10, nullable = false)
    private String homeScore;
    @Column(length = 10, nullable = false)
    private String awayScore;

    @Builder
    public Schedule(String scheDate, String stadiumId, String gubun, String hometeamId, String awayteamId,
                    String homeScore, String awayScore){
        this.scheDate=scheDate;
        this.stadiumId=stadiumId;
        this.gubun=gubun;
        this.hometeamId=hometeamId;
        this.awayteamId=awayteamId;
        this.homeScore=homeScore;
        this.awayScore=awayScore;
    }
}
