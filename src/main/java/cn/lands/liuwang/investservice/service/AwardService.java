package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.model.AwardInfo;

import java.io.IOException;
import java.util.List;

public interface AwardService {
    /**
     * 查询开奖号码
     */
    List<AwardInfo> findAwardInfoList(int pageIndex, int pageSize);

    boolean saveAwardInfo(AwardInfo awardInfo);

    List<AwardInfo> getAwardInfoList() throws IOException;
}
