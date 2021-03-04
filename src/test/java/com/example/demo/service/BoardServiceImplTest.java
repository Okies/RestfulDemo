package com.example.demo.service;

import com.example.demo.dto.BoardDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class BoardServiceImplTest {
    @Autowired
    BoardServiceImpl boardService;


    @Test
    void getBoards() {
        List<BoardDTO> boards = boardService.getBoards();
        assertFalse(boards.isEmpty());
        assertEquals(5, boards.size());
    }

    @Test
    void getBoard() {
    }

    @Test
    void register() {
    }

    @Test
    void delete() {
    }
}