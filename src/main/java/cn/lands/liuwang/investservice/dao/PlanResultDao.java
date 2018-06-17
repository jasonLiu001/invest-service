package cn.lands.liuwang.investservice.dao;

import cn.lands.liuwang.investservice.model.PlanResultInfo;

import java.util.List;

public interface PlanResultDao {
    List<PlanResultInfo> findPlanResultInfoList(int pageIndex, int pageSize);
}
