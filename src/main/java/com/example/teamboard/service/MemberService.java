package com.example.teamboard.service;

import com.example.teamboard.dto.MemberDTO;
import com.example.teamboard.dto.PasswordDTO;
import com.example.teamboard.entity.Member;

import java.security.Principal;

public interface MemberService {

    public String signUp(MemberDTO memberDTO);

    public MemberDTO read(Long num);

    public MemberDTO update(MemberDTO memberDTO);

    public void del(Long num);


//    public MemberDTO mypage(String email, Principal principal);

    public MemberDTO mypage(String email);

    public void changeP(PasswordDTO passwordDTO, Principal principal);


}
