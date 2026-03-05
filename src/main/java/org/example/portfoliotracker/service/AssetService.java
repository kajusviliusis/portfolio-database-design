package org.example.portfoliotracker.service;

import org.example.portfoliotracker.model.Asset;
import org.example.portfoliotracker.repository.AssetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    private final AssetRepository assetRepository;

    public AssetService(AssetRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public Asset getAssetById(Long id) {
        return assetRepository.findById(id);
    }

    public Asset getAssetBySymbol(String symbol) {
        return assetRepository.findBySymbol(symbol);
    }

    public void createAsset(Asset asset) {
        assetRepository.createAsset(asset);
    }
}

