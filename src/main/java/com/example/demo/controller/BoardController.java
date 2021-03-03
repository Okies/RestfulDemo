package com.example.demo.controller;

import com.example.demo.dto.BoardDTO;
import com.example.demo.repository.BoardRepository;
import com.example.demo.service.BoardServiceImpl;
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
    BoardServiceImpl boardServiceImpl;

    @GetMapping("/boards")
    public List<BoardDTO> getBoards() {

        return boardServiceImpl.getBoards();
    }

    @GetMapping("/boards/{bid}")
    public BoardDTO getBoard(@PathVariable Long bid) {

        return boardServiceImpl.getBoard(bid);
    }

    @PostMapping("/board")
    public @ResponseBody BoardDTO createBoard(@RequestBody Map<String, String> param) {

        //이부분 어케 고칠지 고민
        String title = param.get("title");
        String content = param.get("content");
        String createdId = param.get("createdId");
        String password = param.get("password");

        BoardDTO dto = BoardDTO.builder()
                .title(title)
                .content(content)
                .createdId(createdId)
                .password(password)
                .build();

        log.info(dto);

        return boardServiceImpl.register(dto);
    }

    @DeleteMapping("/board/{bid}")
    public @ResponseBody List<BoardDTO> deleteBoard(@PathVariable Long bid, @RequestParam Map<String, String> param) {

        return boardServiceImpl.delete(bid, param.get("password"));
    }
}
