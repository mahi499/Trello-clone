package com.mahendra.trello_clone.controller;

import com.mahendra.trello_clone.model.Card;
import com.mahendra.trello_clone.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public Card createCard(@RequestParam String title,
                           @RequestParam String description,
                           @RequestParam Long listId) {
        return cardService.createCard(title, description, listId);
    }

    @GetMapping
    public List<Card> getCards(@RequestParam Long listId) {
        return cardService.getCardsByList(listId);
    }

    @DeleteMapping("/{id}")
    public String deleteCard(@PathVariable Long id) {
        return cardService.deleteCard(id);
    }
}