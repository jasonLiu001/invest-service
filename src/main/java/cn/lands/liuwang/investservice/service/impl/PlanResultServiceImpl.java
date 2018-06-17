package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.model.PlanResultInfo;
import cn.lands.liuwang.investservice.service.BaseService;
import cn.lands.liuwang.investservice.service.PlanResultService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanResultServiceImpl extends BaseService implements PlanResultService {
    @Override
    public List<PlanResultInfo> findPlanResultInfoList(int pageIndex, int pageSize) {
        return planResultDao.findPlanResultInfoList(pageIndex,pageSize);
    }
}
