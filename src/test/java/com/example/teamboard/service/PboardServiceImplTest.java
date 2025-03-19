package com.example.teamboard.service;

import com.example.teamboard.dto.PboardDTO;
import com.example.teamboard.entity.Pboard;
import com.example.teamboard.repository.PboardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.security.Principal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Log4j2
class PboardServiceImplTest {

    @Autowired
    PboardService pboardService;
    PboardRepository pboardRepository;

//    @Test
//    public void registerTest(){
//
//
//        for (int i =0; i<50; i++){
//            PboardDTO pboardDTO = new PboardDTO();
//            pboardDTO.setPboardTitle("제목");
//            pboardDTO.setPboardContent("내용");
//
//            pboardService.register(pboardDTO, principal);
//        }
//
//
//
//    }




}