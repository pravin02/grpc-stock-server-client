package org.pk.grpc.stc;

import java.time.ZonedDateTime;

public record StockPriceDto(String symbol, double price, ZonedDateTime time) {
}
