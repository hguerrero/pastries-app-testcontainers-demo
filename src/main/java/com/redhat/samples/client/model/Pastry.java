package com.redhat.samples.client.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Pastry(String name, String description, String size, double price, String status) {
}
