package com.redhat.samples.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record OrderInfo(String customerId, ProductQuantity productQuantity, Double price) {
}
