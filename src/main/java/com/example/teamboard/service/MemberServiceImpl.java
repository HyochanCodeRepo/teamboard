package com.example.teamboard.service;

import com.example.teamboard.dto.MemberDTO;
import com.example.teamboard.entity.Member;
import com.example.teamboard.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private ModelMapper modelMapper = new ModelMapper();
    private final MemberRepository memberRepository;




    @Override

    public String signUp(MemberDTO memberDTO) {
        Member member =
            modelMapper.map(memberDTO, Member.class);

        //Password Encoder 필요함


        return null;
    }
}
