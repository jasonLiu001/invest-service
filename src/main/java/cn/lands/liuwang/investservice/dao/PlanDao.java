package cn.lands.liuwang.investservice.dao;

import cn.lands.liuwang.investservice.model.PlanInfo;

import java.util.List;

public interface PlanDao {
    List<PlanInfo> findPlanInfoList(int pageIndex, int pageSize);
}
