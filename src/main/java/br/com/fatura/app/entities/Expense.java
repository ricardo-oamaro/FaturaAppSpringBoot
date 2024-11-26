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
@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "expense_date")
    private LocalDate expenseDate;

    @Column(name = "expense_description")
    private String expenseDescription;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "insert_date")
    private LocalDateTime insertDate;

//    @ManyToOne
//    @JoinColumn(name = "invoice_id", nullable = false)
//    private Invoice invoice;
}
