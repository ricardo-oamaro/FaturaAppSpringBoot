package br.com.fatura.app.controller;

import br.com.fatura.app.entities.Card;
import br.com.fatura.app.services.CardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cards")
public class CardController {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

    @Autowired
    private CardService cardService;

    @RequestMapping
   public ResponseEntity<List<Card>> findAllCards() {
        logger.info("Listing all cards");
        return ResponseEntity.ok(cardService.findAll());
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Card> findCardById(Long id) {
        logger.info("Finding card by id: {}", id);
        return ResponseEntity.ok(cardService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveCard(Card card) {
        logger.info("Saving card: {}", card);
        cardService.save(card);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCard(Card card, Long id) {
        logger.info("Updating card: {}", card);
        cardService.update(card, id);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(Long id) {
        logger.info("Deleting card by id: {}", id);
        cardService.delete(id);
        return ResponseEntity.ok().build();
    }
}
