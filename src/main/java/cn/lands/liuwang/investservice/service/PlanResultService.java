package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.model.PlanResultInfo;

import java.util.List;

public interface PlanResultService {
    List<PlanResultInfo> findPlanResultInfoList(int pageIndex, int pageSize, int planType);
}
