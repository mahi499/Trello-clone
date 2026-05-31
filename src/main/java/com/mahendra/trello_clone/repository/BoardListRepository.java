package com.mahendra.trello_clone.repository;

import com.mahendra.trello_clone.model.BoardList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BoardListRepository extends JpaRepository<BoardList, Long> {
    List<BoardList> findByBoardId(Long boardId);
}