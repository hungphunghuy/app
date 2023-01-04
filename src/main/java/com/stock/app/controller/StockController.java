package com.stock.app.controller;

import com.stock.app.dto.StockDTO;
import com.stock.app.response.BaseResponse;
import com.stock.app.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StockController {
    private final StockService stockService;

    @GetMapping
    public BaseResponse<List<StockDTO>> getStocks() {
        return BaseResponse.<List<StockDTO>>builder().data(stockService.findAll()).message("Get list stocks successfully!").build();
    }

    @PostMapping("/reviews")
    public BaseResponse<String> reviewStock(@RequestBody @Valid StockDTO stockDTO) {
        return BaseResponse.<String>builder().data(stockService.labelingStock(stockDTO)).message("reviews stock successfully!").build();
    }
}
