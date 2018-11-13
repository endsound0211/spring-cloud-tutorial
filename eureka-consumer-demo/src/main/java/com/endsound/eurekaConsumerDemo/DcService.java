package com.endsound.eurekaConsumerDemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DcService {


    @Autowired
    private DcClient dcClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer(){
        return dcClient.consumer();
    }

    public String fallback() {
        return "fallback";
    }
}
