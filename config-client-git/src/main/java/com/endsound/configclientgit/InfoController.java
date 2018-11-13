package com.endsound.configclientgit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @Value("${info.profile}")
    private String infoProfile;

    @GetMapping("/info/profile")
    public String infoProfile(){
        return infoProfile;
    }
}
