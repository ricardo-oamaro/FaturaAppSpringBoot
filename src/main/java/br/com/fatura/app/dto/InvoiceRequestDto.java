package br.com.fatura.app.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record InvoiceRequestDto(
        Long cardId,
        Long customerId,
        String invoiceDate,
        String invoiceDescription,
        String category,
        String amount

) {
}
