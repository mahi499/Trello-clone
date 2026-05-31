package com.mahendra.trello_clone.service;

import com.mahendra.trello_clone.model.BoardList;
import com.mahendra.trello_clone.model.Card;
import com.mahendra.trello_clone.repository.BoardListRepository;
import com.mahendra.trello_clone.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private BoardListRepository boardListRepository;

    public Card createCard(String title, String description, Long listId) {
        BoardList boardList = boardListRepository.findById(listId).orElse(null);
        if (boardList == null) {
            return null;
        }
        Card card = new Card();
        card.setTitle(title);
        card.setDescription(description);
        card.setBoardList(boardList);
        return cardRepository.save(card);
    }

    public List<Card> getCardsByList(Long listId) {
        return cardRepository.findByBoardListId(listId);
    }

    public String deleteCard(Long cardId) {
        if (!cardRepository.existsById(cardId)) {
            return "Card not found!";
        }
        cardRepository.deleteById(cardId);
        return "Card deleted successfully!";
    }
}