package com.mahendra.trello_clone.service;

import com.mahendra.trello_clone.model.Board;
import com.mahendra.trello_clone.model.User;
import com.mahendra.trello_clone.repository.BoardRepository;
import com.mahendra.trello_clone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    public Board createBoard(String name, Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }
        Board board = new Board();
        board.setName(name);
        board.setUser(user);
        return boardRepository.save(board);
    }

    public List<Board> getBoardsByUser(Long userId) {
        return boardRepository.findByUserId(userId);
    }

    public String deleteBoard(Long boardId) {
        if (!boardRepository.existsById(boardId)) {
            return "Board not found!";
        }
        boardRepository.deleteById(boardId);
        return "Board deleted successfully!";
    }
}