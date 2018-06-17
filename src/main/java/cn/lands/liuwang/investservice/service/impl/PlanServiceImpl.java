package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.model.PlanInfo;
import cn.lands.liuwang.investservice.service.BaseService;
import cn.lands.liuwang.investservice.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl extends BaseService implements PlanService {
    @Override
    public List<PlanInfo> findPlanInfoList(int pageIndex, int pageSize) {
        return planDao.findPlanInfoList(pageIndex,pageSize);
    }
}
