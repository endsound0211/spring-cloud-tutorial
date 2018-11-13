package com.endsound.eurekaConsumerDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class DcController {
    private static final Logger logger = LoggerFactory.getLogger(DcController.class);

    @Autowired
    private DcService dcService;

    @GetMapping("/consumer")
    public String dc(HttpServletRequest request) {
        logger.info("eureka-consumer: TraceId={}, SpanId={}, ParentSpanId={}, Sampled={}, SpanName={}",
                request.getHeader("X-B3-TraceId"),
                request.getHeader("X-B3-SpanId"),
                request.getHeader("X-B3-ParentSpanId"),
                request.getHeader("X-B3-Sampled"),
                request.getHeader("X-Span-Name"));
        return dcService.consumer();
    }
}
