package br.com.fatura.app.entities;

public enum Category {

    ALIMENTACAO,
    EDUCACAO,
    SAUDE,
    TRANSPORTE,
    MORADIA,
    LAZER,
    OUTROS;

    public static Category fromString(String category) {
        try {
            return Category.valueOf(category.toUpperCase()); // Converte para maiúsculas
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Categoria inválida: " + category);
        }
    }

}
