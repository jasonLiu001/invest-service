package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.dao.*;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
    @Autowired
    protected InvestDao investDao;

    @Autowired
    protected InvestTotalDao investTotalDao;

    @Autowired
    protected AwardDao awardDao;

    @Autowired
    protected PlanDao planDao;

    @Autowired
    protected PlanInvestNumbersDao planInvestNumbersDao;

    @Autowired
    protected PlanResultDao planResultDao;

    @Autowired
    protected SettingsDao settingsDao;
}
