package com.lamda.web.soccer;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "player")
public class Player {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerNo;
    @Column(length = 10, nullable = false) private String playerId;
    @Column(length = 20, nullable = false) private String playerName;
    @Column(length = 40, nullable = false) private String ePlayerName;
    @Column(length = 30, nullable = false) private String nickname;
    @Column(length = 10, nullable = false) private String joinYyyy;
    @Column(length = 10, nullable = false) private String position;
    @Column(length = 10, nullable = false) private String backNo;
    @Column(length = 20, nullable = false) private String nation;
    @Column(length = 20, nullable = false) private String birthDate;
    @Column(length = 10, nullable = false) private String solar;
    @Column(length = 10, nullable = false) private String height;
    @Column(length = 10, nullable = false) private String weight;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull @JoinColumn(name="team_id") private Team team;

    @Builder
    public Player(String playerId, String playerName, String ePlayerName, String nickname,
                  String joinYyyy, String position, String backNo, String nation, String birthDate,
                  String solar, String height, String weight, String teamId){
        this.playerId = playerId;
        this.playerName = playerName;
        this.ePlayerName = ePlayerName;
        this.nickname = nickname;
        this.joinYyyy = joinYyyy;
        this.position = position;
        this.backNo = backNo;
        this.nation = nation;
        this.birthDate =birthDate;
        this.solar=solar;
        this.height=height;
        this.weight=weight;
    }
}
