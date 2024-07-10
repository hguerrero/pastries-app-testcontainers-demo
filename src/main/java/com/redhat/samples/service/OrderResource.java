package com.redhat.samples.service;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.redhat.samples.client.PastryAPIClient;
import com.redhat.samples.service.model.OrderInfo;
import com.redhat.samples.service.model.UnavailableProduct;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/api/orders")
public class OrderResource {

    @Inject
    @RestClient
    PastryAPIClient pastryRepository;

    @POST
    public Response order(OrderInfo info) {
        try {
            String pastryName = info.productQuantity().productName();
            String status = pastryRepository.getPastry(pastryName).status();

            if ("available".equals(status)) {
                return Response.status(Status.CREATED).entity(info).build();
            }
            else {
                return Response.status(422)
                .entity(new UnavailableProduct(pastryName, "Pastry %s is not available".formatted(pastryName)))
                .build();
            }

        } catch (Exception e) {
            Log.errorf(e, "Unexpected runtime exception: %s", e.getMessage());
            return Response.serverError().build();
        }
    }
}
