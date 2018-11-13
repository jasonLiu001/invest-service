package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.AwardDao;
import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.model.AwardInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AwardDaoImpl extends BaseDao implements AwardDao {
    /**
     * 查询开奖号码
     */
    @Override
    public List<AwardInfo> findAwardInfoList(int pageIndex, int pageSize) {
        List<AwardInfo> list = rewardJdbcTemplate.query("SELECT * FROM `award` ORDER BY period DESC LIMIT ?,?;", new Object[]{(pageIndex - 1) * pageSize, pageSize}, new BeanPropertyRowMapper<>(AwardInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public boolean saveAwardInfo(AwardInfo awardInfo) {
        int effectRowCount = rewardJdbcTemplate.update("INSERT INTO award(period,openNumber,openTime) VALUES(?,?,?)",
                awardInfo.getPeriod(), awardInfo.getOpenNumber(), awardInfo.getOpenTime());
        return effectRowCount > 0;
    }
}
