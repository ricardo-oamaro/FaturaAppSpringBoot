package br.com.fatura.app.entities;

import br.com.fatura.app.dto.InvoiceRequestDto;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class InvoiceOld {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private Long cardId;
//    private Long customerId;
//
//    @Column(name = "invoice_date")
//    private LocalDate invoiceDate;
//
//    @Column(name = "invoice_description")
//    private String invoiceDescription;
//    private String customerName;
//    private String cardName;
//
//    @Enumerated(EnumType.STRING)
//    private Category category;
//    private BigDecimal amount;
//    private BigDecimal totalAmount;
//    private LocalDateTime insertDate;

//    @OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private List<Expense> expenses;



//
//    public InvoiceOld(InvoiceRequestDto invoiceRequestDto) {
//        this.cardId = invoiceRequestDto.cardId();
//        this.customerId = invoiceRequestDto.customerId();
//        this.invoiceDate = LocalDate.parse(invoiceRequestDto.invoiceDate());
//        this.invoiceDescription = invoiceRequestDto.invoiceDescription();
//        this.amount = new BigDecimal(invoiceRequestDto.amount());
//        this.category = Category.fromString(invoiceRequestDto.category());
//        this.insertDate = LocalDateTime.now();
//    }


}
