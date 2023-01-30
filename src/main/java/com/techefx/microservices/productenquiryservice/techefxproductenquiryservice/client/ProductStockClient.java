package com.techefx.microservices.productenquiryservice.techefxproductenquiryservice.client;

import com.techefx.microservices.productenquiryservice.techefxproductenquiryservice.beans.ProductEnquiryBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="techefx-product-stock-service", url="localhost:8800")
@FeignClient(name="techefx-product-stock-service")
// If we are not using any load balancer or any kind of naming registry service so here we'll have to specify in url that where our "techefx-product-stock-service" is
// running along with the hostname and port. But if we have any load balancer like Ribbon or naming registry like Eureka naming server then we don't have to pass url option.
public interface ProductStockClient {

    @GetMapping("/check-product-stock/productName/{productName}/productAvailability/{productAvailability}")
    public ProductEnquiryBean checkProductStock(@PathVariable String productName,
                                              @PathVariable String productAvailability);

}
