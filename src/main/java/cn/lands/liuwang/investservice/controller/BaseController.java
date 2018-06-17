package cn.lands.liuwang.investservice.controller;

import cn.lands.liuwang.investservice.service.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected AwardService awardService;

    @Autowired
    protected InvestService investService;

    @Autowired
    protected MaxProfitService maxProfitService;

    @Autowired
    protected PlanService planService;

    @Autowired
    protected PlanResultService planResultService;

    @Autowired
    protected PlanInvestNumbersService planInvestNumbersService;
}
