package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.PlanResultDao;
import cn.lands.liuwang.investservice.model.PlanResultInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanResultDaoImpl extends BaseDao implements PlanResultDao {
    @Override
    public List<PlanResultInfo> findPlanResultInfoList(int pageIndex, int pageSize) {
        List<PlanResultInfo> list = rewardJdbcTemplate.query("SELECT * FROM `plan_result` ORDER BY period DESC LIMIT ?,?;", new Object[]{(pageIndex - 1) * pageSize, pageSize}, new BeanPropertyRowMapper<>(PlanResultInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
