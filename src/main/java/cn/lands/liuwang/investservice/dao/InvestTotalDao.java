package cn.lands.liuwang.investservice.dao;

import cn.lands.liuwang.investservice.model.InvestTotalInfo;

import java.util.List;

public interface InvestTotalDao {
    /**
     * 查询所有的投注记录
     */
    List<InvestTotalInfo> findInvestTotalInfoList(int pageIndex, int pageSize, int planType, String beforeTimeStr, String createDateStr);

    /**
     * 根据期号查询购买号码
     */
    InvestTotalInfo getInvestTotalInfoByPeriod(int planType, String period);
}
