package com.example.teamboard.service;

import com.example.teamboard.dto.BoardDTO;
import com.example.teamboard.entity.Board;
import com.example.teamboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override
    public void register(BoardDTO boardDTO) {
        Board board = modelMapper.map(boardDTO, Board.class);
        boardRepository.save(board);
    }

    @Override
    public Page<BoardDTO> list(Pageable pageable) {
        Page<Board> boardPage = boardRepository.findAll(pageable);
        Page<BoardDTO> boardDTOPage = boardPage.map(boardList -> modelMapper.map(boardList, BoardDTO.class));

        return boardDTOPage;
    }

    @Override
    public BoardDTO read(Long boardNum) {
        Board board = boardRepository.findById(boardNum).get();
        BoardDTO boardDTO = modelMapper.map(board, BoardDTO.class);
        return boardDTO;
    }

    @Override
    public void del(Long boardNum) {
        boardRepository.deleteById(boardNum);
    }
}
