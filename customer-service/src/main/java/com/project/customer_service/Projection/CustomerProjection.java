package com.project.customer_service.Projection;

import com.project.customer_service.entities.Customer;
import org.springframework.data.rest.core.config.Projection;


// FOR SPECIFY THE CUSTOMER ATTRIBUTS FOR VIEW
// http://localhost:8081/customers/1?projection=all
@Projection(name = "all", types = Customer.class)
public interface CustomerProjection {
    String getName();
}
