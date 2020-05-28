package com.lamda.web.soccer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {//은닉화, 상속, 추상화, 다형성 완성본

}
