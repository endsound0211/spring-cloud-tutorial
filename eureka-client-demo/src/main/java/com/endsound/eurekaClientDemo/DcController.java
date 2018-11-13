package com.endsound.eurekaClientDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DcController {
    private static final Logger logger = LoggerFactory.getLogger(DcController.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc(HttpServletRequest request) throws InterruptedException {
        logger.info("eureka-client: TraceId={}, SpanId={}, ParentSpanId={}, Sampled={}, SpanName={}",
                request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"),
                request.getHeader("X-B3-ParentSpanId"),
                request.getHeader("X-B3-Sampled"),
                request.getHeader("X-Span-Name"));
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}
