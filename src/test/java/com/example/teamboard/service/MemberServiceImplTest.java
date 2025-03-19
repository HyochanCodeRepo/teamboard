package com.example.teamboard.service;

import com.example.teamboard.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Log4j2
class MemberServiceImplTest {

    @Autowired
    MemberService memberService;

    @Test
    public void signUpTest() {

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setAddr("경기도 부천");
        memberDTO.setName("어드민");
        memberDTO.setEmail("admin@a.a");
        memberDTO.setPassword("1234");
        memberService.signUp(memberDTO);


    }
    @Test
    public void readTest(){

        MemberDTO memberDTO =
            memberService.read(1L);

        log.info(memberDTO);

    }

    @Test
    public void updateTest(){
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberNum(1L);

        memberDTO.setAddr("경기도 어딘가");
        memberDTO.setPassword("123123");

        memberService.update(memberDTO);
    }

    @Test
    public void delTest(){

        memberService.del(1L);

    }



}