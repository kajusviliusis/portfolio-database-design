package org.example.portfoliotracker.repository;

import org.example.portfoliotracker.model.Portfolio;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PortfolioRepository {
    private final JdbcTemplate jdbc;

    public PortfolioRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<Portfolio> portfolioMapper = ((rs, rowNum) -> {
       Portfolio p = new Portfolio();
       p.setPortfolioId(rs.getLong("portfolio_id"));
       p.setUserId(rs.getLong("user_id"));
       p.setName(rs.getString("name"));
       return p;
    });

    public int createPortfolio(Portfolio portfolio) {
        String sql = "INSERT INTO PORTFOLIO (NAME) VALUES (?)";
        return jdbc.update(sql, portfolio.getName());
    }
    public Portfolio findById(Long id) {
        String sql = "SELECT * FROM PORTFOLIO WHERE ID = ?";
        return jdbc.queryForObject(sql, portfolioMapper, id);
    }
    public List<Portfolio> findAll() {
        String sql = "SELECT * FROM PORTFOLIO";
        return jdbc.query(sql, portfolioMapper);
    }
    public int deleteById(Long id) {
        String sql = "DELETE FROM PORTFOLIO WHERE ID = ?";
        return jdbc.update(sql, id);
    }
}
