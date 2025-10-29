package com.escola.projeto.backend.enums;

public enum Gender {
    MALE("Masculino"),
    FEMALE("Feminino"),
    OTHERS("Outros");

    private final String description;

    Gender(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
