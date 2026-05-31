package com.mahendra.trello_clone.controller;

import com.mahendra.trello_clone.model.BoardList;
import com.mahendra.trello_clone.service.BoardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lists")
public class BoardListController {

    @Autowired
    private BoardListService boardListService;

    @PostMapping
    public BoardList createList(@RequestParam String name,
                                @RequestParam Long boardId) {
        return boardListService.createList(name, boardId);
    }

    @GetMapping
    public List<BoardList> getLists(@RequestParam Long boardId) {
        return boardListService.getListsByBoard(boardId);
    }

    @DeleteMapping("/{id}")
    public String deleteList(@PathVariable Long id) {
        return boardListService.deleteList(id);
    }
}