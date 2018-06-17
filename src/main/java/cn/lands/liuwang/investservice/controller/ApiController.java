package cn.lands.liuwang.investservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lottery")
public class ApiController {

    @RequestMapping("/test")
    public String test() {
        return "ok";
    }
}
