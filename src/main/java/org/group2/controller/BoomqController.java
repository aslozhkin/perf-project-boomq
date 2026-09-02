package org.group2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BoomqController {

    @GetMapping
    public String boomqStub(@RequestParam(value = "param") String param) {
        return param + "testResponse";
    }
}
