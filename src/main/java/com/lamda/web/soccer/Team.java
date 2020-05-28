package com.lamda.web.soccer;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "team")
public class Team {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamNo;
    @Column(length = 10, nullable = false) private String teamId;
    @Column(length = 10, nullable = false) private String regionName;
    @Column(length = 40, nullable = false) private String teamName;
    @Column(length = 50, nullable = false) private String eTeamName;
    @Column(length = 10, nullable = false) private String origYyyy;
    @Column(length = 10, nullable = false) private String zipCode1;
    @Column(length = 10, nullable = false) private String zipCode2;
    @Column(length = 80, nullable = false) private String address;
    @Column(length = 10, nullable = false) private String ddd;
    @Column(length = 10, nullable = false) private String fax;
    @Column(length = 50, nullable = false) private String homepage;
    @Column(length = 10, nullable = false) private String owner;
    @OneToMany(mappedBy = "team") private List<Player> playerList;
    @ManyToOne(fetch = FetchType.LAZY)
    @NotNull @JoinColumn(name = "stadium_id") private Stadium stadium;

    @Builder
    public Team(String teamId, String regionName, String teamName, String eTeamName,
                String origYyyy, String zipCode1, String zipCode2, String address,
                String ddd, String fax, String homepage, String owner){
        this.teamId = teamId;
        this.regionName = regionName;
        this.teamName = teamName;
        this.eTeamName = eTeamName;
        this.origYyyy = origYyyy;
        this.zipCode1 = zipCode1;
        this.zipCode2 = zipCode2;
        this.address = address;
        this.ddd = ddd;
        this.fax = fax;
        this.homepage = homepage;
        this.owner = owner;
    }
}
