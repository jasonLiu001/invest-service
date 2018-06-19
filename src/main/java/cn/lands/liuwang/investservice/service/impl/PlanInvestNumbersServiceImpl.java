package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.model.PlanInvestNumberInfo;
import cn.lands.liuwang.investservice.service.BaseService;
import cn.lands.liuwang.investservice.service.PlanInvestNumbersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanInvestNumbersServiceImpl extends BaseService implements PlanInvestNumbersService {
    @Override
    public List<PlanInvestNumberInfo> findInvestNumbersInfoList(int pageIndex, int pageSize, int planType) {
        return planInvestNumbersDao.findInvestNumbersInfoList(pageIndex, pageSize, planType);
    }
}
