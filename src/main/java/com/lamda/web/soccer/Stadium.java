package com.lamda.web.soccer;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "stadium")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stadiumNo;
    @Column(length = 10, nullable = false) private String stadiumId;
    @Column(length = 40, nullable = false) private String stadiumName;
    @Column(length = 10, nullable = false) private String hometeamId;
    @Column(length = 10, nullable = false) private String seatCount;
    @Column(length = 60, nullable = false) private String address;
    @Column(length = 10, nullable = false) private String ddd;
    @Column(length = 10, nullable = false) private String tel;
    @OneToMany(mappedBy = "stadium") public List<Team> teamList;
    @OneToMany(mappedBy = "stadium") public List<Schedule> scheduleList;

    @Builder
    public Stadium(String stadiumId,String stadiumName, String hometeamId, String seatCount, String address,
                   String ddd, String tel){
        this.stadiumId=stadiumId;
        this.stadiumName=stadiumName;
        this.hometeamId=hometeamId;
        this.seatCount=seatCount;
        this.address=address;
        this.ddd=ddd;
        this.tel=tel;
    }
}
