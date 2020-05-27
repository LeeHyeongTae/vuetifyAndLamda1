package com.lamda.web.soccer;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleNo;
    @Column(length = 10, nullable = false) private String scheDate;
    @Column(length = 10, nullable = false) private String gubun;
    @Column(length = 10, nullable = false) private String hometeamId;
    @Column(length = 10, nullable = false) private String awayteamId;
    @Column(length = 10, nullable = false) private String homeScore;
    @Column(length = 10, nullable = false) private String awayScore;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id") private Stadium stadium;

    @Builder
    public Schedule(String scheDate, String stadiumId, String gubun, String hometeamId, String awayteamId,
                    String homeScore, String awayScore){
        this.scheDate=scheDate;
        this.gubun=gubun;
        this.hometeamId=hometeamId;
        this.awayteamId=awayteamId;
        this.homeScore=homeScore;
        this.awayScore=awayScore;
    }

    public void test() {

    }
}
