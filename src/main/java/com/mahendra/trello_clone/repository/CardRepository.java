package com.mahendra.trello_clone.repository;

import com.mahendra.trello_clone.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findByBoardListId(Long listId);
}