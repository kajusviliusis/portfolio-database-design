package org.example.portfoliotracker.service;

import org.example.portfoliotracker.model.Trade;
import org.example.portfoliotracker.repository.TradeRepository;
import org.springframework.stereotype.Service;

@Service
public class TradeService {
    private final TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public Trade getTradeById(Long id) {
        return tradeRepository.findById(id);
    }

    public Trade getTradeByPortfolioId(Long portfolioId) {
        return tradeRepository.findByPortfolioId(portfolioId);
    }

    public Trade getTradeByAssetId(Long assetId) {
        return tradeRepository.findByAssetId(assetId);
    }

    public void createTrade(Trade trade) {
        tradeRepository.createTrade(trade);
    }

    public void deleteTrade(Long id) {
        tradeRepository.deleteById(id);
    }
}

