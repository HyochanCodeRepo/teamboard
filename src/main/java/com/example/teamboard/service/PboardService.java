package com.example.teamboard.service;

import com.example.teamboard.dto.PboardDTO;
import jakarta.validation.constraints.Email;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

public interface PboardService {

    //등록
    public void register(PboardDTO pboardDTO, Email email);

    //목록
    public Page<PboardDTO> pboardList(String email, Pageable pageable);

    //읽기,상세보기
    public PboardDTO read(Long pboardNum);

    //수정
    public PboardDTO update(PboardDTO pboardDTO);

    //삭제
    public Long del(Long pboardNum);




}
