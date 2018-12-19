package cn.lands.liuwang.investservice.dao;

import cn.lands.liuwang.investservice.model.query.QueryListBeforeTime;
import cn.lands.liuwang.investservice.model.stats.CorrectWrongCountInfo;

import java.util.List;

public interface StatDao {
    List<CorrectWrongCountInfo> getTotalCorrectAndWrongCount(QueryListBeforeTime queryListBeforeTime);
}
