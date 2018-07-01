package cn.lands.liuwang.investservice.dao;

import cn.lands.liuwang.investservice.model.InvestInfo;
import cn.lands.liuwang.investservice.model.ProfitInfo;
import cn.lands.liuwang.investservice.model.ProfitType;

import java.util.List;

/**
 * 投注记录表
 */
public interface InvestDao {
    /**
     * 查询投注记录
     */
    List<InvestInfo> findInvestInfoList(int pageIndex, int pageSize, int planType);

    /**
     * 根据期号查询购买号码
     */
    InvestInfo getInvestInfoByPeriod(int planType, String period);

    /**
     * 查询 每天 特定时间点 以前最新记录
     *
     * @param beforeTimeStr 时间点 格式：02:00:00
     */
    List<InvestInfo> findInvestInfoListBeforeTime(int pageIndex, int pageSize, int planType, String beforeTimeStr);

    /**
     * 查询每天全天最大利润
     */
    List<ProfitInfo> findInvestInfoListProfit(int pageIndex, int pageSize, int planType, int fixedProfit, ProfitType profitType);
}
