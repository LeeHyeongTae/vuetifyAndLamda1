package com.lamda.web.soccer;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "Stadium")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleNo;
    @Column(length = 10, nullable = false)
    private String stadiumId;
    @Column(length = 40, nullable = false)
    private String stadiumName;
    @Column(length = 10, nullable = false)
    private String hometeamId;
    @Column(length = 10, nullable = false)
    private String seatCount;
    @Column(length = 60, nullable = false)
    private String address;
    @Column(length = 10, nullable = false)
    private String ddd;
    @Column(length = 10, nullable = false)
    private String tel;
    @Builder
    public Stadium(String stadiumId,String stadiumName, String hometeamId, String seatCount, String address,
                   String ddd, String tel){
        this.stadiumId=stadiumId;
        this.stadiumName=stadiumName;
        this.seatCount=seatCount;
        this.address=address;
        this.ddd=ddd;
        this.tel=tel;
    }
}
