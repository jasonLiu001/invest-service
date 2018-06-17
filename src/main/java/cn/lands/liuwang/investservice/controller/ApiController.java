package cn.lands.liuwang.investservice.controller;

import cn.lands.liuwang.investservice.service.AwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lottery")
public class ApiController {

    @Autowired
    AwardService awardService;

    @RequestMapping("/test")
    public String test() {
        return awardService.findAwardInfoList(1, 1).toString();
    }
}
