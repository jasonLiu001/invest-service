package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.AwardDao;
import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.model.AwardInfo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AwardDaoImpl extends BaseDao implements AwardDao {
    /**
     * 查询开奖号码
     *
     */
    @Override
    public List<AwardInfo> findAwardInfoList(int pageSize, int pageIndex) {
        AwardInfo awardInfo = new AwardInfo();
        List<AwardInfo> list = new ArrayList<>();
        list.add(awardInfo);
        return list;
    }
}
