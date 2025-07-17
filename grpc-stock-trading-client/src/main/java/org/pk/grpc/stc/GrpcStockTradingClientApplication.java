package org.pk.grpc.stc;

import org.pk.grpc.stc.service.StockClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcStockTradingClientApplication {

    @Autowired
    private StockClientService stockClientService;

    public static void main(String[] args) {
        SpringApplication.run(GrpcStockTradingClientApplication.class, args);
    }

}
