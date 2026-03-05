package org.example.portfoliotracker.repository;

import org.example.portfoliotracker.model.Asset;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssetRepository {
    private final JdbcTemplate jdbc;

    public AssetRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final RowMapper<Asset> assetMapper = ((rs, rowNum) -> {
       Asset a = new Asset();
       a.setAssetId(rs.getLong("assetId"));
       a.setSymbol(rs.getString("symbol"));
       a.setName(rs.getString("name"));
       a.setAssetType(rs.getString("assetType"));
       return a;
    });

    public int createAsset(Asset asset) {
        String sql = "INSERT INTO assets VALUES (?, ?, ?)";
        return  jdbc.update(sql, asset.getSymbol(), asset.getName(), asset.getAssetType());
    }

    public Asset findById(Long assetId) {
        String sql = "SELECT * FROM assets WHERE assetId = ?";
        return jdbc.queryForObject(sql, assetMapper, assetId);
    }
    public List<Asset> findAll() {
        String sql = "SELECT * FROM assets";
        return jdbc.query(sql, assetMapper);
    }

    public Asset findBySymbol(String symbol) {
        String sql = "SELECT * FROM assets WHERE symbol = ?";
        return jdbc.queryForObject(sql, assetMapper, symbol);
    }


}
