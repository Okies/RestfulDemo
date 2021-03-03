package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardRepository boardRepository;

    @Override
    public List<BoardDTO> getBoards() {

        return boardRepository.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public BoardDTO getBoard(Long bid) {

        return entityToDto(boardRepository.findByBid(bid));
    }

    @Override
    public BoardDTO register(BoardDTO dto) {
        return entityToDto(boardRepository.save(dtoToEntity(dto)));
    }

    @Override
    public List<BoardDTO> delete(Long bid, String password) {

        boardRepository.deleteByBidAndPassword(bid, password);

        return boardRepository.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
