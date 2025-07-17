package org.pk.grpc.sts;

import org.pk.grpc.sts.model.*;

import java.util.random.RandomGenerator;


public class DummyStockList {

    public static StockList listOfStocks() {
        return StockList
                .newBuilder()
                .addStocks(getStock1())
                .addStocks(getStock2())
                .addStocks(getStock3())
                .build();
    }

    private static Stock getStock1() {

        var subSector = SubSector
                .newBuilder()
                .setSector(Sector.newBuilder().setSector("Financial Services").build())
                .setSubSector("NBFC")
                .build();

        var detail = StockDetails.newBuilder()
                .setSymbol("SHRFIN")
                .setSecurity("Shriram Finance")
                .setISIN("INE721A01047")
                .setNseScriptName("SHRIRAMFIN")
                .setBseScriptCode("511218")
                .setClassification("Midcap")
                .setSubSector(subSector)
                .build();

        return Stock
                .newBuilder()
                .setSymbol("SHRFIN")
                .setPrice(RandomGenerator.getDefault().nextDouble(100, 200))
                .setDetails(detail)
                .build();
    }

    private static Stock getStock2() {

        var subSector = SubSector
                .newBuilder()
                .setSector(Sector.newBuilder().setSector("Financial Services").build())
                .setSubSector("NBFC")
                .build();

        var detail = StockDetails.newBuilder()
                .setSymbol("SBI")
                .setSecurity("State Bank Of India")
                .setISIN("INE721A010445")
                .setNseScriptName("SBI")
                .setBseScriptCode("5112328")
                .setClassification("LargeCap")
                .setSubSector(subSector)
                .build();

        return Stock
                .newBuilder()
                .setSymbol("SBI")
                .setPrice(RandomGenerator.getDefault().nextDouble(700, 900))
                .setDetails(detail)
                .build();
    }

    private static Stock getStock3() {

        var subSector = SubSector
                .newBuilder()
                .setSector(Sector.newBuilder().setSector("Consumer Goods").build())
                .setSubSector("Jewellery & watches")
                .build();

        var detail = StockDetails.newBuilder()
                .setSymbol("Titan")
                .setSecurity("Titan")
                .setISIN("INE72111234345")
                .setNseScriptName("Titan")
                .setBseScriptCode("5112328")
                .setClassification("LargeCap")
                .setSubSector(subSector)
                .build();

        return Stock
                .newBuilder()
                .setSymbol("SBI")
                .setPrice(RandomGenerator.getDefault().nextDouble(3000, 3500))
                .setDetails(detail)
                .build();
    }
}
