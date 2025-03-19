package com.example.teamboard.controller;

import com.example.teamboard.dto.BoardDTO;
import com.example.teamboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model, Pageable pageable) {
        Page<BoardDTO> boardDTOList = boardService.list(pageable);
        model.addAttribute("boardDTOList", boardDTOList);
        return "/board/list";
    }

    @GetMapping("/register")
    public String register(BoardDTO boardDTO) {
        return "/board/register";
    }

    @PostMapping("/register")
    public String registerPost(BoardDTO boardDTO){
        boardService.register(boardDTO);
        return "redirect:/board/list";
    }

    @GetMapping("/read/{boardNum}")
    public String read(@PathVariable("boardNum") Long boardNum, Model model) {
        BoardDTO boardDTO = boardService.read(boardNum);
        model.addAttribute("boardDTO", boardDTO);
        return "/board/read";
    }
}
