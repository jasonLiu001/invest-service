package cn.lands.liuwang.investservice.dao;

import cn.lands.liuwang.investservice.model.MaxProfitInfo;

import java.util.List;

/**
 * 最大利润表
 */
public interface MaxProfitDao {
    /**
     * 查询最大利润列表
     */
    List<MaxProfitInfo> findMaxProfitInfoList(int pageIndex, int pageSize, int planType);
}
