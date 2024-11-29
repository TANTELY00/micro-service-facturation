package com.project.billing_service.projection;

import com.project.billing_service.entities.Bill;
import org.springframework.data.rest.core.config.Projection;

import javax.xml.crypto.Data;
import java.util.Date;

@Projection(name = "all" , types = Bill.class)
public interface BillProjection {

    Date getBillingDate();
    Long getCustomerId();

}
