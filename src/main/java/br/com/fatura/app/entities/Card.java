package br.com.fatura.app.entities;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Card {
    private Long id;
    private String cardName;
}
