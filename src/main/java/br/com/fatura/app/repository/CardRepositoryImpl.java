package br.com.fatura.app.repository;

import br.com.fatura.app.entities.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CardRepositoryImpl {

    @Autowired
    private JdbcClient jdbcClient;

    public List<Card> findAll() {
        return jdbcClient
                .sql("SELECT * FROM cards")
                .query(Card.class)
                .list();
    }

    public Optional<Card> findById(Long id) {
        return jdbcClient
                .sql("SELECT * FROM cards WHERE id = ?")
                .param("id", id)
                .query(Card.class)
                .optional();
    }

    public Integer save(Card card) {
        return jdbcClient
                .sql("INSERT INTO cards (name) VALUES (?)")
                .param("name", card.getCardName())
                .update();
    }

    public Integer update(Card card, Long id) {
        return jdbcClient
                .sql("UPDATE cards SET name = ? WHERE id = ?")
                .param("name", card.getCardName())
                .param("id", id)
                .update();
    }

    public Integer deleteById(Long id) {
        return jdbcClient
                .sql("DELETE FROM cards WHERE id = ?")
                .param("id", id)
                .update();
    }
}
