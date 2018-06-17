package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.model.InvestInfo;

import java.util.List;

public interface InvestService {
    /**
     * 查询投注记录
     */
    List<InvestInfo> findInvestInfoList(int pageIndex, int pageSize);
}
