package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.model.PlanInvestNumberInfo;

import java.util.List;

public interface PlanInvestNumbersService {
    List<PlanInvestNumberInfo> findInvestNumbersInfoList(int pageIndex, int pageSize, int planType);
}
