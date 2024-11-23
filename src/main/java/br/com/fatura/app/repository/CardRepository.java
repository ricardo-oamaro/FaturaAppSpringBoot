package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Card;
import br.com.fatura.app.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface CardRepository {

    Optional<Card> findById(Long id);

    List<Card> findAll();

    Integer save(Card card);

    Integer update(Card card, Long id);

    Integer delete(Long id);
}
