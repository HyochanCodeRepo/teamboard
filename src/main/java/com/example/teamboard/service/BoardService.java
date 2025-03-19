package com.example.teamboard.service;


import com.example.teamboard.dto.BoardDTO;
import com.example.teamboard.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {
    public void register(BoardDTO boardDTO);
    public Page<BoardDTO> list(Pageable pageable);
    public BoardDTO read(Long boardNum);

}
