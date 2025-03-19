package com.example.teamboard.service;

import com.example.teamboard.constant.Role;
import com.example.teamboard.dto.MemberDTO;
import com.example.teamboard.dto.PasswordDTO;
import com.example.teamboard.entity.Member;
import com.example.teamboard.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService , UserDetailsService {

    private ModelMapper modelMapper = new ModelMapper();
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;





    @Override

    public String signUp(MemberDTO memberDTO) {
        //signUp 진입시 이메일로 가입여부 확인 먼저!
        validateDuplicateMember(memberDTO.getEmail());

        Member member =
            modelMapper.map(memberDTO, Member.class);

        //Password Encoder 필요함
        member.setPassword(passwordEncoder.encode(memberDTO.getPassword()));
        //지금은 admin으로 해놨음
        member.setRole(Role.ADMIN);

        member =
            memberRepository.save(member);
        memberDTO =
            modelMapper.map(member, MemberDTO.class);

        return memberDTO.getName();
    }

    //회원가입 유효성 검사
    private void validateDuplicateMember(String email) {
        Member member =
            memberRepository.findByEmail(email);

        if (member != null) {
            log.info("이미 가입된 회원입니다.");
            throw new IllegalStateException("예외처리 :: 이미 가입된 회원입니다.");
        } else {
            log.info("가입되지 않은 회원입니다.");
        }
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //입력받은 email을 통해서 entity찾기
        Member member =
            memberRepository.findByEmail(email);
        if (member == null) {
            log.info("현재 입력하신 email로는 가입된 정보가 없습니다.");
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }
        log.info("로그인 시도하는 사람 : " + member);
        log.info("로그인 하는 사람의 권한 : " + member.getRole().name());
        String role = "";
        if (member.getRole().name().equals(Role.ADMIN.name())) {
            log.info("관리자 로그인 시도중...");
            role = member.getRole().name();
        } else {
            log.info("일반 유저 로그인 시도중");
            role = member.getRole().name();
        }
        UserDetails user =
                User.builder()
                        .username(member.getEmail())
                        .password(member.getPassword())
                        .roles(role)
                        .build();

        return user;
    }




    @Override
    public MemberDTO read(Long num) {

        Optional<Member> member =
            memberRepository.findById(num);
        MemberDTO memberDTO =
            modelMapper.map(member, MemberDTO.class);

        return memberDTO;



    }

    @Override
    public MemberDTO update(MemberDTO memberDTO) {
        Member member =
            memberRepository.findByEmail(memberDTO.getEmail());

        log.info("확인용"+member.getRole());
        log.info("확인용"+member.getRole());
        log.info("확인용"+member.getRole());
        log.info("확인용"+member.getRole());


        member.setAddr(memberDTO.getAddr());
        member.setName(memberDTO.getName());


        memberRepository.save(member);


        memberDTO =
            modelMapper.map(member, MemberDTO.class);


        return memberDTO;
    }

    @Override
    public void del(Long num) {


        memberRepository.deleteById(num);
    }

    @Override
    public MemberDTO mypage(String email) {
        Member member =
                memberRepository.findByEmail(email);

        MemberDTO memberDTO =
                modelMapper.map(member, MemberDTO.class);



        return memberDTO;
    }

    @Override
    public void changeP(PasswordDTO passwordDTO, Principal principal) {
        Member member =
            memberRepository.findByEmail(principal.getName());

        log.info((member.getPassword().equals(passwordDTO.getPassword())));
        log.info(member.getPassword());
        log.info(passwordDTO.getPassword());

        if (passwordEncoder.matches(passwordDTO.getPassword() , member.getPassword()) ) {
            log.info("password 변경 서비스 진입");
            log.info("저장 전 password : " + member.getPassword());
            member.setPassword(passwordEncoder.encode(passwordDTO.getNewpassword1()));
            memberRepository.save(member);
            log.info("저장 후 password : " + member.getPassword());
        } else {
            log.info("뭔가 잘못됨");
        }
        

    }
}
