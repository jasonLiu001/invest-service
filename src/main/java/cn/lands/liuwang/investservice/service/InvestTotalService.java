package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.model.InvestTotalInfo;

import java.util.List;

public interface InvestTotalService {
    /**
     * 查询所有的投注记录
     */
    List<InvestTotalInfo> findInvestTotalInfoList(int pageIndex, int pageSize, int planType);
}