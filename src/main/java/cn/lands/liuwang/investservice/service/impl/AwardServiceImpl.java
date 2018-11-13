package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.dao.AwardDao;
import cn.lands.liuwang.investservice.model.AwardInfo;
import cn.lands.liuwang.investservice.service.AwardService;
import cn.lands.liuwang.investservice.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardServiceImpl extends BaseService implements AwardService {
    /**
     * 查询开奖号码
     */
    @Override
    public List<AwardInfo> findAwardInfoList(int pageIndex, int pageSize) {
        return awardDao.findAwardInfoList(pageIndex, pageSize);
    }

    @Override
    public boolean saveAwardInfo(AwardInfo awardInfo) {
        return awardDao.saveAwardInfo(awardInfo);
    }
}
