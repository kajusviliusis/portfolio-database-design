package org.example.portfoliotracker.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {
    private Long portfolioId;
    private Long userId;
    private String name;
    private LocalDateTime createdAt = LocalDateTime.now();
}
