package com.mahendra.trello_clone.controller;

import com.mahendra.trello_clone.model.Board;
import com.mahendra.trello_clone.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping
    public Board createBoard(@RequestParam String name,
                             @RequestParam Long userId) {
        return boardService.createBoard(name, userId);
    }

    @GetMapping
    public List<Board> getBoards(@RequestParam Long userId) {
        return boardService.getBoardsByUser(userId);
    }

    @DeleteMapping("/{id}")
    public String deleteBoard(@PathVariable Long id) {
        return boardService.deleteBoard(id);
    }
}