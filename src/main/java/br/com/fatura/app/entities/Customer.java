package br.com.fatura.app.entities;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Customer {

    private Long id;
    private String name;
}
