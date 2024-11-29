package com.project.inventory_service.projection;

import com.project.inventory_service.entities.Product;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "test",types = Product.class)
public interface ProjectionProduct {
    String getId();
    String getName();
}
