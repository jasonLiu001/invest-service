package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.model.PlanInfo;

import java.util.List;

public interface PlanService {
    List<PlanInfo> findPlanInfoList(int pageIndex, int pageSize);
}
