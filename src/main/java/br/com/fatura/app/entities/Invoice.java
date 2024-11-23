package br.com.fatura.app.entities;

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

    private Long id;
    private String invoiceDate;
    private String invoiceDescription;
    private BigDecimal amount;
    private LocalDate insertDate;
}
