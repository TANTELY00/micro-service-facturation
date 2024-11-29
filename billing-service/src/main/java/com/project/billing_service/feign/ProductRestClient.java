package com.project.billing_service.feign;

import com.project.billing_service.DTOs.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping(path = "/products/{id}")
    public Product getProductById(String id);

    @GetMapping(path = "/products")
    public PagedModel<Product> getProducts();
}
