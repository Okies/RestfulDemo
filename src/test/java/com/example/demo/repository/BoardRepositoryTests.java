package com.example.demo.repository;

import com.example.demo.dto.BoardDTO;
import com.example.demo.entity.Board;
import com.example.demo.service.BoardServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    BoardServiceImpl boardServiceImpl;

    @Test
    public void testInsertDummies() {

        IntStream.rangeClosed(1, 10).forEach(i -> {
            Board board = Board.builder()
                    .title("Sample Title..." + i)
                    .content("Sample Content..." + i)
                    .createdId("Sample Createid..." + i)
                    .password("Sample Password..." + i)
                    .build();
            boardRepository.save(board);
        });
    }

    @Transactional
    @Test
    public void testDelete() {
        List<BoardDTO> list = boardServiceImpl.delete(1L, "Sample Password...1");

        for (BoardDTO dto : list) {
            System.out.println(dto);
        }
    }
}
