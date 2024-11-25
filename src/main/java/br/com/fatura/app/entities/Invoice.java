package br.com.fatura.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cardId;
    private Long customerId;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @Column(name = "invoice_description")
    private String invoiceDescription;
    private String customerName;
    private String cardName;
    private BigDecimal amount;
    private BigDecimal totalAmount;
    private LocalDateTime insertDate;

    //TODO: Implementar categorias
}
