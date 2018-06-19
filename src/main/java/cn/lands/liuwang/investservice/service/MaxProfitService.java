package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.model.MaxProfitInfo;

import java.util.List;

public interface MaxProfitService {
    List<MaxProfitInfo> findMaxProfitInfoList(int pageIndex, int pageSize, int planType);
}
