package com.stock.app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
public class StockDTO {
    private int id;

    private String stockSymbol;

    @NotNull(message = "Field is required!")
    private float netProfit;

    @NotNull(message = "Field is required!")
    private float totalAssets;

    @NotNull(message = "Field is required!")
    private float revenue;

    @NotNull(message = "Field is required!")
    private float currentAssets;

    @NotNull(message = "Field is required!")
    private float currentDebt;

    @NotNull(message = "Field is required!")
    private float totalLiabilities;

    @NotNull(message = "Field is required!")
    private float stockPrice;

    @NotNull(message = "Field is required!")
    private float eps;

    private String label;
}
