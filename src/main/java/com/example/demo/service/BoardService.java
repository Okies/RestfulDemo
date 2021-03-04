package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

import java.util.List;

public interface BoardService {

    List<BoardDTO> getBoards();

    BoardDTO getBoard(Long bid);

    BoardDTO register(BoardDTO dto);

    void delete(Long bid, String password);

}
