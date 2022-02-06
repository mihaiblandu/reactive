package com.learnreactiveprogramming.domain;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Product {

    @NonNull
    private String productId;
    @NonNull
    private Review review;
    private Inventory inventory;
}