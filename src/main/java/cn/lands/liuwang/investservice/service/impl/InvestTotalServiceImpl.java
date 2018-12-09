package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.model.InvestTotalInfo;
import cn.lands.liuwang.investservice.service.BaseService;
import cn.lands.liuwang.investservice.service.InvestTotalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvestTotalServiceImpl extends BaseService implements InvestTotalService {
    /**
     * 查询所有的投注记录
     */
    @Override
    public List<InvestTotalInfo> findInvestTotalInfoList(int pageIndex, int pageSize, int planType, String beforeTimeStr, String createDateStr) {
        return investTotalDao.findInvestTotalInfoList(pageIndex, pageSize, planType, beforeTimeStr, createDateStr);
    }

    /**
     * 根据期号查询购买号码
     */
    @Override
    public InvestTotalInfo getInvestTotalInfoByPeriod(int planType, String period) {
        return investTotalDao.getInvestTotalInfoByPeriod(planType, period);
    }
}
