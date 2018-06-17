package cn.lands.liuwang.investservice.dao;

import cn.lands.liuwang.investservice.model.AwardInfo;

import java.util.List;

/**
 * 开奖号码表
 */
public interface AwardDao {
    /**
     * 查询开奖号码
     */
    List<AwardInfo> findAwardInfoList(int pageIndex, int pageSize);
}
