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
@RequestMapping("/card")
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
    public ResponseEntity<Card> findCardById(
            @PathVariable Long id
    ) {
        logger.info("Finding card by id: {}", id);
        return ResponseEntity.ok(cardService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> saveCard(
            @RequestBody Card card
    ) {
        logger.info("Saving card: {}", card);
        cardService.save(card);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCard(
            @PathVariable Long id,
            @RequestBody Card card
    ) {
        logger.info("Updating card: {}", card);
        cardService.update(card, id);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(
            @PathVariable Long id
    ) {
        logger.info("Deleting card by id: {}", id);
        cardService.delete(id);
        return ResponseEntity.ok().build();
    }
}
