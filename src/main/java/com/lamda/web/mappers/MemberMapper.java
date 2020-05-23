package com.lamda.web.mappers;

import com.lamda.web.domains.MemberDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
   public MemberDTO retrive();
}
