package com.example.teamboard.controller;

import com.example.teamboard.dto.MemberDTO;
import com.example.teamboard.dto.PasswordDTO;
import com.example.teamboard.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signUp")
    public String signUp(MemberDTO memberDTO) {
        return "user/signUp";
    }

    @PostMapping("/signUp")
    public String signUpPost(@Valid MemberDTO memberDTO, BindingResult bindingResult) {

        log.info("회원가입 포스트 진입!");
        log.info("회원가입 포스트 진입!");

        log.info(memberDTO);

        //에러가 있으면~
        if (bindingResult.hasErrors()) {
            log.info("유효성 검사 에러 발생!");
            log.info(bindingResult.getAllErrors());

            return "user/signUp";
        }

        try {
            memberService.signUp(memberDTO);

        } catch (IllegalStateException e) {
            e.printStackTrace();
            return "user/signUp";

        }

        return "redirect:/user/singUp";


    }


    @GetMapping("/login")
    public String login() {
        log.info("로그인 페이지 진입!");
        log.info("로그인 페이지 진입!");
        log.info("로그인 페이지 진입!");
        return "user/login";
    }

    @GetMapping("/mypage")
    public String mypage(Principal principal, Model model) {

        log.info(principal.getName());
        log.info(principal.getName());
        log.info(principal.getName());
        log.info("mypage 진입!");
        log.info("mypage 진입!");
        log.info("mypage 진입!");
        MemberDTO memberDTO =
                memberService.mypage(principal.getName());

        model.addAttribute("memberDTO", memberDTO);


        return "user/mypage";
    }

    @PostMapping("/mypage")
    public String mypagePost(MemberDTO memberDTO, Principal principal) {

        log.info("mypagePost 진입!");
        log.info("mypagePost 진입!");
        log.info("mypagePost 진입!");
        log.info(principal.getName());
        log.info(principal.getName());

        log.info("memberDTO 받은거 " + memberDTO);


        return "user/mypage";

    }

    @PostMapping("/update")
    public String updatePost(MemberDTO memberDTO) {
        log.info("updatePost진입");
        log.info("updatePost진입");
        log.info("updatePost진입");
        log.info(memberDTO);
        log.info(memberDTO);
        log.info(memberDTO.getRole());

        memberService.update(memberDTO);

        log.info("수정된 memberDTO : " + memberDTO);
        log.info("수정된 memberDTO : " + memberDTO);
        log.info("수정된 memberDTO : " + memberDTO);
        return "redirect:/main";

    }

    @GetMapping("/changepw")
    public void changepw() {
        log.info("비밀번호 변경 페이지 진입");
        log.info("비밀번호 변경 페이지 진입");
        log.info("비밀번호 변경 페이지 진입");

    }

    @PostMapping("/changepw")
    public void changepwPost(PasswordDTO passwordDTO) {
        log.info("changepw 받은 값 : " +passwordDTO);
        log.info("changepw 받은 값 : " +passwordDTO);
        log.info("changepw 받은 값 : " +passwordDTO);
        log.info("changepw 받은 값 : " +passwordDTO);

    }
}
