package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    @Override
    public List<BoardDTO> getBoards() {

        return boardRepository.findAll().stream()
                .map(this::entityToDtoWithoutPassword)
                .collect(Collectors.toList());
    }

    @Override
    public BoardDTO getBoard(Long id) {
        Optional<Board> boardOptional = boardRepository.findById(id);

        if (boardOptional.isEmpty()) {
            throw new RuntimeException("not found");
        }

        return entityToDtoWithoutPassword(boardOptional.get());
    }

    @Override
    public BoardDTO register(BoardDTO boardDTO) {
        return entityToDtoWithoutPassword(boardRepository.save(dtoToEntity(boardDTO)));
    }

    @Override
    public void delete(Long id, String password) {
        Optional<Board> boardOptional = boardRepository.findById(id);

        if (boardOptional.isEmpty()) {
            throw new RuntimeException("not found");
        }

        Board board = boardOptional.get();

        if (!board.getPassword().equals(password)) {
            throw new RuntimeException("password not matched");
        }

        boardRepository.delete(board);
    }

    private BoardDTO entityToDtoWithoutPassword(Board board) {

        return BoardDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .createdId(board.getCreatedId())
                .build();
    }

    private Board dtoToEntity(BoardDTO dto) {

        return Board.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .content(dto.getContent())
                .createdId(dto.getCreatedId())
                .password(dto.getPassword())
                .build();
    }
}
