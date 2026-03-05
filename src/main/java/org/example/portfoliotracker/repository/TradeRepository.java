package org.example.portfoliotracker.repository;

import org.example.portfoliotracker.model.Trade;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TradeRepository {
    private final JdbcTemplate jdbc;

    public TradeRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<Trade> tradeMapper = ((rs, rowNum) -> {
        Trade t = new Trade();
        t.setTradeId(rs.getLong("trade_id"));
        t.setPortfolioId(rs.getLong("portfolio_id"));
        t.setAssetId(rs.getLong("asset_id"));
        t.setTradeType(rs.getString("trade_type"));
        t.setQuantity(rs.getBigDecimal("quantity"));
        t.setPrice(rs.getBigDecimal("price"));
        return t;
    });

    public int createTrade(Trade trade) {
        String sql = "INSERT INTO TRADE (PORTFOLIO_ID, ASSET_ID, TRADE_TYPE, QUANTITY, PRICE) VALUES (?, ?, ?, ?, ?)";
        return jdbc.update(sql, trade.getPortfolioId(), trade.getAssetId(), trade.getTradeType(), trade.getQuantity(), trade.getPrice());
    }

    public Trade findById(Long id) {
        String sql = "SELECT * FROM TRADE WHERE ID = ?";
        return jdbc.queryForObject(sql, tradeMapper, id);
    }

    public Trade findByPortfolioId(Long portfolioId) {
        String sql = "SELECT * FROM TRADE WHERE PORTFOLIO_ID = ?";
        return jdbc.queryForObject(sql, tradeMapper, portfolioId);
    }

    public Trade findByAssetId(Long assetId) {
        String sql = "SELECT * FROM TRADE WHERE ASSET_ID = ?";
        return jdbc.queryForObject(sql, tradeMapper, assetId);
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM TRADE WHERE ID = ?";
        return jdbc.update(sql, id);
    }


}
