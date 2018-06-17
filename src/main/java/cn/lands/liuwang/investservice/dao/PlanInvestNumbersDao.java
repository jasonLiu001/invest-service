package cn.lands.liuwang.investservice.dao;

import cn.lands.liuwang.investservice.model.PlanInvestNumberInfo;

import java.util.List;

public interface PlanInvestNumbersDao {
    List<PlanInvestNumberInfo> findInvestNumbersInfoList(int pageIndex, int pageSize);
}
