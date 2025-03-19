package com.example.teamboard.controller;

import com.example.teamboard.dto.PboardDTO;
import com.example.teamboard.entity.Pboard;
import com.example.teamboard.service.PboardService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/pboard")
public class PboardController {
    private final PboardService pboardService;

    //등록get
    @GetMapping("/register")
    public String registerGet(PboardDTO pboardDTO){
        return "pboard/register";
    }

    //등록post
    @PostMapping("/register")
    public String register(PboardDTO pboardDTO, Principal principal){
        log.info("pboardPost 진입!");
        log.info("pboardPost 진입!");
        log.info(principal.getName());
        log.info(principal.getName());

        log.info("pboardDTO 받은거 " + pboardDTO);

        pboardService.register(pboardDTO);
        return "redirect:list";
    }

    //목록
    @GetMapping("/list")
    public String list(Model model,@PageableDefault(size = 10, page = 0, sort = "pboardNum", direction = Sort.Direction.ASC) Pageable pageable){

        Page<PboardDTO> pboardDTOList = pboardService.pboardList(pageable);
        model.addAttribute("pboardDTOList", pboardDTOList);
        return "pboard/list";
    }

    //상세보기
    @GetMapping("/read/{pboardNum}")
    public String read(PboardDTO pboardDTO, @PathVariable (name="pboardNum") Long pboardNum){

        return "pboard/read";
    }

    //수정
    @GetMapping("/update/{pboardNum}")
    public String update(@PathVariable(name = "pboardNum") Long pboardNum, Model model){
        log.info("수정" + pboardNum);
        PboardDTO pboardDTO = pboardService.read(pboardNum);
        model.addAttribute("pboardDTO", pboardDTO);
        return "pboard/update";
    }
    @PostMapping("/update/{pboardNum}")
    public String updatePost(PboardDTO pboardDTO, @PathVariable(name = "pboardNum") Long pboardNum){
        pboardService.register(pboardDTO);
        return "redirect:/pboard/read/" + pboardNum;
    }


    //삭제
    @GetMapping("/del/{pboardNum}")
    public String delPost(@PathVariable(name = "pboardNum")Long pboardNum){
        log.info("삭제 포스트 진입 : " + pboardNum);

        pboardService.del(pboardNum);

        return "redirect:/pboard/list";
    }



}
