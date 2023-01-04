package com.stock.app.service;

import com.stock.app.dto.StockDTO;
import com.stock.app.model.Stock;
import com.stock.app.repository.RuleRepository;
import com.stock.app.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository stockRepository;

    private final RuleRepository ruleRepository;

    public List<StockDTO> findAll() {
        List<Stock> stocks = stockRepository.findAll();
        if (CollectionUtils.isEmpty(stocks)) {
            return new ArrayList<>();
        }
        List<StockDTO> stockDTOS = stocks
                .stream()
                .map(Stock::stockDTO)
                .collect(Collectors.toList());
        stockDTOS.forEach(stockDTO -> stockDTO.setLabel(labelingStock(stockDTO)));

        return stockDTOS;
    };

    public String labelingStock(StockDTO stock) {
        float netProfit = stock.getNetProfit();
        float stockPrice = stock.getStockPrice();
        float revenue = stock.getRevenue();
        float currentAssets = stock.getCurrentAssets();
        float totalLiabilities = stock.getTotalLiabilities();
        float currentDebt = stock.getCurrentDebt();
        float totalAssets = stock.getTotalAssets();
        float eps = stock.getEps();

        float returnOnAsset = netProfit / totalAssets;
        float totalAssetsRatio = revenue / totalAssets;
        float liquidityRatio = currentAssets / currentDebt;
        float debtRatio = totalLiabilities / totalAssets;
        float financialMarketPos = stockPrice / eps;

        boolean profitability = returnOnAsset >= 1;
        boolean activity = totalAssetsRatio >= 1;
        boolean liquidity = liquidityRatio >= 1;
        boolean debt = debtRatio >= 1;
        boolean market = financialMarketPos >= 1;

        return ruleRepository.findByIndexs(profitability, activity, liquidity, debt, market).get(0);
    }
}
