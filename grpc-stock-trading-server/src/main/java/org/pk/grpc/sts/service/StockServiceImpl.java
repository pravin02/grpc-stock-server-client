package org.pk.grpc.sts.service;

import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.protobuf.ProtoUtils;
import io.grpc.stub.StreamObserver;
import org.pk.grpc.sts.DummyStockList;
import org.pk.grpc.sts.model.*;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class StockServiceImpl extends StockServiceGrpc.StockServiceImplBase {

    @Override
    public void getStockList(StockListFilterRequest request, StreamObserver<StockList> responseObserver) {
        responseObserver.onNext(DummyStockList.listOfStocks());
        responseObserver.onCompleted();
    }

    @Override
    public void getStockDetails(StockDetailsRequest request, StreamObserver<Stock> responseObserver) {
        var stock = DummyStockList.listOfStocks().getStocksList().stream().filter(s -> s.getSymbol().equals(request.getSymbol()));
        stock.findFirst().ifPresentOrElse(s -> {
            responseObserver.onNext(s);
            responseObserver.onCompleted();
        }, () -> {
            Metadata.Key<ErrorResponse> key = ProtoUtils.keyForProto(ErrorResponse.getDefaultInstance());

            Metadata metadata = new Metadata();
            metadata.put(key, ErrorResponse.newBuilder().setError("Stock not found").build());
            responseObserver.onError(Status.NOT_FOUND.withDescription("Stock not found").asRuntimeException(metadata));
        });
    }
}
