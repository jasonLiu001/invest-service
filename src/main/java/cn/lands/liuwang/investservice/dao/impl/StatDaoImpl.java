package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.StatDao;
import cn.lands.liuwang.investservice.model.query.QueryListBeforeTime;
import cn.lands.liuwang.investservice.model.stats.CorrectWrongCountInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StatDaoImpl extends BaseDao implements StatDao {

    @Override
    public List<CorrectWrongCountInfo> getTotalCorrectAndWrongCount(QueryListBeforeTime queryListBeforeTime) {
        List<CorrectWrongCountInfo> correctCountInfo = rewardJdbcTemplate.query("SELECT COUNT(1) AS correctCount,t.`planType` FROM invest_total t WHERE t.`investTime`>? AND t.`investTime`<? AND t.`status`=1 AND t.`isWin`=1 GROUP BY t.`planType`", new Object[]{queryListBeforeTime.getStartTimeStr(), queryListBeforeTime.getEndTimeStr()}, new BeanPropertyRowMapper<>(CorrectWrongCountInfo.class));
        List<CorrectWrongCountInfo> inCorrectCountInfo = rewardJdbcTemplate.query("SELECT COUNT(1) AS correctCount,t.`planType` FROM invest_total t WHERE t.`investTime`>? AND t.`investTime`<? AND t.`status`=1 AND t.`isWin`=0 GROUP BY t.`planType`", new Object[]{queryListBeforeTime.getStartTimeStr(), queryListBeforeTime.getEndTimeStr()}, new BeanPropertyRowMapper<>(CorrectWrongCountInfo.class));
        List<CorrectWrongCountInfo> list = new ArrayList<>();

        for (int i = 0; i < correctCountInfo.size(); i++) {
            CorrectWrongCountInfo correctModel = correctCountInfo.get(i);
            CorrectWrongCountInfo inCorrectModel = inCorrectCountInfo.get(i);
            CorrectWrongCountInfo countInfo = new CorrectWrongCountInfo();
            countInfo.setPlanType(correctModel.getPlanType());
            countInfo.setCorrectCount(correctModel.getCorrectCount());
            countInfo.setInCorrectCount(inCorrectModel.getInCorrectCount());
            list.add(countInfo);
        }
        return list;
    }
}
