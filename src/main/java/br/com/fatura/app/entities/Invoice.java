package br.com.fatura.app.entities;

import br.com.fatura.app.dto.InvoiceRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "invoices")
public class Invoice {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "card_id")
    private Card cardId;

//    @OneToOne
//    @JoinColumn(name = "customer_id")
//    private Customer customerId;
//
//    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Expense> expenses;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @Column(name = "invoice_description")
    private String invoiceDescription;

    @Transient
    private String customerName;

    @Transient
    private String cardName;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "insert_date")
    private LocalDateTime insertDate;



    public Invoice(InvoiceRequestDto invoiceRequestDto) {
        this.invoiceDate = LocalDate.parse(invoiceRequestDto.invoiceDate());
        this.invoiceDescription = invoiceRequestDto.invoiceDescription();
        this.amount = new BigDecimal(invoiceRequestDto.amount());
        this.category = Category.fromString(invoiceRequestDto.category());
        this.insertDate = LocalDateTime.now();
    }


}
