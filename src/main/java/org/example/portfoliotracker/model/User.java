package org.example.portfoliotracker.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String username;
    private String email;
    private LocalDateTime createdAt = LocalDateTime.now();
}
