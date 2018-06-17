package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.dao.AwardDao;
import cn.lands.liuwang.investservice.dao.InvestDao;
import cn.lands.liuwang.investservice.dao.MaxProfitDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {
    @Autowired
    protected InvestDao investDao;

    @Autowired
    protected AwardDao awardDao;

    @Autowired
    protected MaxProfitDao maxProfitDao;
}
