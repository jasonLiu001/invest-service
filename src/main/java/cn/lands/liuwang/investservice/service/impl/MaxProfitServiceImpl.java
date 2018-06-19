package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.model.MaxProfitInfo;
import cn.lands.liuwang.investservice.service.BaseService;
import cn.lands.liuwang.investservice.service.MaxProfitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaxProfitServiceImpl extends BaseService implements MaxProfitService {

    @Override
    public List<MaxProfitInfo> findMaxProfitInfoList(int pageIndex, int pageSize, int planType) {
        return maxProfitDao.findMaxProfitInfoList(pageIndex, pageSize, planType);
    }
}
