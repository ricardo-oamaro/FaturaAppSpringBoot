package br.com.fatura.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


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

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;
    @Column(name = "invoice_description")
    private String invoiceDescription;
    private BigDecimal amount;
    private LocalDate insertDate;
}
