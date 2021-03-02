package com.example.demo.Controller;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@Log4j2
public class BoardController {

    @Autowired
    BoardRepository boardRepository;

    @GetMapping("/boards")
    public List<Board> getBoards() {

        return boardRepository.findAll();
    }

    @GetMapping("/boards/{bid}")
    public Board getBoard(@PathVariable Long bid) {

        return boardRepository.findByBid(bid);
    }

    @PostMapping("/board")
    public @ResponseBody List<Board> createBoard(@RequestBody Map<String, String> param) {

        String title = param.get("title");
        String content = param.get("content");
        String createdId = param.get("createdId");
        String password = param.get("password");

        Board board = Board.builder()
                .title(title)
                .content(content)
                .createdId(createdId)
                .password(password)
                .build();

        log.info(board);

        boardRepository.save(board);

        return boardRepository.findAll();
    }

    @DeleteMapping("/board/{bid}")
    public @ResponseBody List<Board> deleteBoard(@PathVariable Long bid, @RequestParam Map<String, String> param) {

        String password = param.get("password");

        boardRepository.deleteByBidAndPassword(bid, password);

        return boardRepository.findAll();
    }
}
