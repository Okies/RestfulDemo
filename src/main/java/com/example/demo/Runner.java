package com.example.demo;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
public class Runner {

    BoardRepository boardRepository;

    @Autowired
    public void init(BoardRepository boardRepository) throws Exception {
        this.boardRepository = boardRepository;

        IntStream.rangeClosed(1, 10).forEach(i -> {
            Board board = Board.builder()
                    .title("Sample Title..." + i)
                    .content("Sample Content..." + i)
                    .createdId("Sample Createid..." + i)
                    .password("Sample Password..." + i)
                    .build();
            this.boardRepository.save(board);
        });
    }
}
