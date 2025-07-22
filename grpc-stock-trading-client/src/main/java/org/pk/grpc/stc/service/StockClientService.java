package org.pk.grpc.stc.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.pk.grpc.stc.StockPriceDto;
import org.pk.grpc.sts.model.*;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StockClientService {

    @GrpcClient("stockService")
    StockServiceGrpc.StockServiceBlockingStub stockServiceStub;


    public StockList getStockList(String symbol) {
        return stockServiceStub.getStockList(StockListFilterRequest.newBuilder().setSymbol(symbol).build());
    }


    public Stock getStockDetails(String symbol) {
        return stockServiceStub.getStockDetails(StockDetailsRequest.newBuilder().setSymbol(symbol).build());
    }

    public List<StockPriceDto> getStockLivePrice(String symbol) {
        List<StockPriceDto> list = new ArrayList<>();
        Iterator<StockPrice> iterator = stockServiceStub.getStockLivePrice(StockDetailsRequest.newBuilder().setSymbol(symbol).build());
        while (iterator.hasNext()) {
            StockPrice sp = iterator.next();
            list.add(new StockPriceDto(sp.getSymbol(), sp.getPrice(), ZonedDateTime.parse(sp.getLastPriceChanged())));
        }
        return list;
    }
}
