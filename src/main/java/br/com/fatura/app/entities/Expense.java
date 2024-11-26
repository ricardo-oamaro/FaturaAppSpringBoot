package br.com.fatura.app.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate expenseDate;
    private String expenseDescription;
    @Enumerated(EnumType.STRING)
    private Category category;
    private Double amount;
    private LocalDateTime insertDate;
}
