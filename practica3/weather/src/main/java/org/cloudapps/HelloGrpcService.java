package org.cloudapps;

import io.quarkus.grpc.GrpcService;

import io.smallrye.mutiny.Uni;

import org.cloudapps.grpc.*;

@GrpcService
public class HelloGrpcService implements HelloGrpc {

    @Override
    public Uni<HelloReply> sayHello(HelloRequest request) {
        System.out.println("Request received from client:\n" + request);

        return Uni.createFrom().item(null);
    }

}
