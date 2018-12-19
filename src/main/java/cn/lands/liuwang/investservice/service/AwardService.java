package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.model.AwardInfo;
import cn.lands.liuwang.investservice.model.query.QueryListBase;

import java.io.IOException;
import java.util.List;

public interface AwardService {
    /**
     * 查询开奖号码
     */
    List<AwardInfo> findAwardInfoList(QueryListBase listParam);

    boolean saveAwardInfo(AwardInfo awardInfo);

    List<AwardInfo> getAwardInfoList(int source) throws IOException;
}
