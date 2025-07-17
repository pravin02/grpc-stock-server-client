package org.pk.grpc.stc.controller;

import org.pk.grpc.stc.service.StockClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/stocks")
public class StockPriceController {

    @Autowired
    private StockClientService stockClientService;

    @GetMapping
    public String getStockList(@RequestParam("symbol") String symbol) {
        return String.valueOf(stockClientService.getStockList(symbol));
    }

    @GetMapping("/{symbol}")
    public String getStockDetails(@PathVariable("symbol") String symbol) {
        return String.valueOf(stockClientService.getStockDetails(symbol));
    }
}
