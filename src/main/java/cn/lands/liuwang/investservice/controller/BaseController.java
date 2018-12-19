package cn.lands.liuwang.investservice.controller;

import cn.lands.liuwang.investservice.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {

    @Autowired
    protected AwardService awardService;

    @Autowired
    protected InvestService investService;

    @Autowired
    protected InvestTotalService investTotalService;

    @Autowired
    protected PlanService planService;

    @Autowired
    protected PlanResultService planResultService;

    @Autowired
    protected PlanInvestNumbersService planInvestNumbersService;

    @Autowired
    protected SettingsService settingsService;

    @Autowired
    protected UserService userService;

    @Autowired
    protected StatService statService;

    protected final Logger logger = LogManager.getLogger(this.getClass());
}
