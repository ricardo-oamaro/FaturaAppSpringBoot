package br.com.fatura.app.services;

import br.com.fatura.app.entities.Card;
import br.com.fatura.app.entities.Invoice;
import br.com.fatura.app.repository.CardRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CardService {

    @Autowired
    private CardRepositoryImpl cardRepository;

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public Card findById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public void save(Card invoice) {
        var save = cardRepository.save(invoice);
        Assert.state(save == 1, "Error saving invoice");
    }

    public void update(Card invoice, Long id) {
        var update = cardRepository.update(invoice, id);
        if (update == 0) {
            throw new RuntimeException("Error updating invoice");
        }
    }

    public void delete(Long id){
        var delete = cardRepository.deleteById(id);
        if (delete == 0) {
            throw new RuntimeException("Error deleting invoice");
        }
    }
}
