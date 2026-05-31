package com.mahendra.trello_clone.service;

import com.mahendra.trello_clone.model.Board;
import com.mahendra.trello_clone.model.BoardList;
import com.mahendra.trello_clone.repository.BoardListRepository;
import com.mahendra.trello_clone.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardListService {

    @Autowired
    private BoardListRepository boardListRepository;

    @Autowired
    private BoardRepository boardRepository;

    public BoardList createList(String name, Long boardId) {
        Board board = boardRepository.findById(boardId).orElse(null);
        if (board == null) {
            return null;
        }
        BoardList list = new BoardList();
        list.setName(name);
        list.setBoard(board);
        return boardListRepository.save(list);
    }

    public List<BoardList> getListsByBoard(Long boardId) {
        return boardListRepository.findByBoardId(boardId);
    }

    public String deleteList(Long listId) {
        if (!boardListRepository.existsById(listId)) {
            return "List not found!";
        }
        boardListRepository.deleteById(listId);
        return "List deleted successfully!";
    }
}