package org.pk.grpc.stc.service;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.pk.grpc.sts.model.*;
import org.springframework.stereotype.Service;

@Service
public class StockClientService {

    @GrpcClient("stockService")
    StockServiceGrpc.StockServiceBlockingStub stockService;


    public StockList getStockList(String symbol) {
        return stockService.getStockList(StockListFilterRequest.newBuilder().setSymbol(symbol).build());
    }


    public Stock getStockDetails(String symbol) {
        return stockService.getStockDetails(StockDetailsRequest.newBuilder().setSymbol(symbol).build());
    }
}
