package com.example.demo.controller;

import com.example.demo.dto.BoardDTO;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/boards")
@Slf4j
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public List<BoardDTO> getBoards() {

        return boardService.getBoards();
    }

    @GetMapping("/{bid}")
    public BoardDTO getBoard(@PathVariable Long bid) {

        return boardService.getBoard(bid);
    }

    @PostMapping
    public BoardDTO createBoard(@RequestBody BoardDTO board) {

        return boardService.register(board);
    }

    @DeleteMapping("/{bid}")
    public void deleteBoard(
            @PathVariable Long bid,
            @RequestParam String password
    ) {

        boardService.delete(bid, password);
    }
}
