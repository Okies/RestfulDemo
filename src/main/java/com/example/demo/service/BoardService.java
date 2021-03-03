package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;

import java.util.List;

public interface BoardService {

    List<BoardDTO> getBoards();

    BoardDTO getBoard(Long bid);

    BoardDTO register(BoardDTO dto);

    List<BoardDTO> delete(Long bid, String password);

    default BoardDTO entityToDto(Board entity) {

        BoardDTO dto = BoardDTO.builder()
                .bid(entity.getBid())
                .title(entity.getTitle())
                .content(entity.getContent())
                .createdId(entity.getCreatedId())
                .build();

        return dto;
    }

    default Board dtoToEntity(BoardDTO dto) {

        Board entity = Board.builder()
                .bid(dto.getBid())
                .title(dto.getTitle())
                .content(dto.getContent())
                .createdId(dto.getCreatedId())
                .password(dto.getPassword())
                .build();

        return entity;
    }
}
