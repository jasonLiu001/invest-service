package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.dao.InvestDao;
import cn.lands.liuwang.investservice.model.InvestInfo;
import cn.lands.liuwang.investservice.model.ProfitInfo;
import cn.lands.liuwang.investservice.model.ProfitType;
import cn.lands.liuwang.investservice.service.BaseService;
import cn.lands.liuwang.investservice.service.InvestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestServiceImpl extends BaseService implements InvestService {


    /**
     * 查询 所有/一定时间返回内 购买记录
     */
    @Override
    public List<InvestInfo> findInvestInfoList(int pageIndex, int pageSize, int planType, String beforeTimeStr, String createTimeStr) {
        return investDao.findInvestInfoList(pageIndex, pageSize, planType, beforeTimeStr, createTimeStr);
    }

    @Override
    public InvestInfo getInvestInfoByPeriod(int planType, String period) {
        return investDao.getInvestInfoByPeriod(planType, period);
    }

    /**
     * 查询特定时间内的 最大利润
     */
    @Override
    public List<InvestInfo> findInvestInfoListBeforeTime(int pageIndex, int pageSize, int planType, String beforeTimeStr) {
        return investDao.findInvestInfoListBeforeTime(pageIndex, pageSize, planType, beforeTimeStr);
    }

    /**
     * 查询每天全天最大利润
     */
    @Override
    public List<ProfitInfo> findInvestInfoListProfit(int pageIndex, int pageSize, int planType, int fixedProfit, ProfitType profitType) {
        return investDao.findInvestInfoListProfit(pageIndex, pageSize, planType, fixedProfit, profitType);
    }
}
