package org.example.portfoliotracker.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    private Long assetId;
    private String symbol;
    private String name;
    private String assetType;
}
