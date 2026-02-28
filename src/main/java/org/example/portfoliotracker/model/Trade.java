package org.example.portfoliotracker.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
    private Long tradeId;
    private Long portfolioId;
    private Long assetId;
    private String tradeType;
    private BigDecimal quantity;
    private BigDecimal price;
    private LocalDateTime tradeDate;
}
