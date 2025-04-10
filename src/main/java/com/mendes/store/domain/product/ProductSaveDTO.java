package com.mendes.store.domain.product;


import jakarta.annotation.Nonnull;

public record ProductSaveDTO(
        @Nonnull
        String name,

        @Nonnull
        String description,

        @Nonnull
        Double price


) {
}
