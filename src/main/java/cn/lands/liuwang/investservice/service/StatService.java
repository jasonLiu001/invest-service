package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.model.query.QueryListBeforeTime;
import cn.lands.liuwang.investservice.model.stats.CorrectWrongCountInfo;

import java.util.List;

/**
 * 统计服务
 */
public interface StatService {
    List<CorrectWrongCountInfo> getTotalCorrectAndWrongCount(QueryListBeforeTime queryListBeforeTime);
}
