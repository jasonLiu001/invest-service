package cn.lands.liuwang.investservice.dao;

import cn.lands.liuwang.investservice.model.InvestInfo;

import java.util.List;

/**
 * 投注记录表
 */
public interface InvestDao {
    /**
     * 查询投注记录
     */
    List<InvestInfo> findInvestInfoList(int pageIndex, int pageSize, int planType);
}
