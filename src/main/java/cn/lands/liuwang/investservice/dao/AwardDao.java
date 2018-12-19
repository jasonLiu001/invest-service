package cn.lands.liuwang.investservice.dao;

import cn.lands.liuwang.investservice.model.AwardInfo;
import cn.lands.liuwang.investservice.model.query.QueryListBase;

import java.util.List;

/**
 * 开奖号码表
 */
public interface AwardDao {
    /**
     * 查询开奖号码
     */
    List<AwardInfo> findAwardInfoList(QueryListBase listParam);

    boolean saveAwardInfo(AwardInfo awardInfo);
}
