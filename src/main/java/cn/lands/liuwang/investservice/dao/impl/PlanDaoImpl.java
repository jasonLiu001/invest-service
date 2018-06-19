package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.PlanDao;
import cn.lands.liuwang.investservice.model.PlanInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanDaoImpl extends BaseDao implements PlanDao {
    @Override
    public List<PlanInfo> findPlanInfoList(int pageIndex, int pageSize, int planType) {
        List<PlanInfo> list = rewardJdbcTemplate.query("SELECT * FROM `plan` WHERE planType=? ORDER BY period DESC LIMIT ?,?;", new Object[]{planType, (pageIndex - 1) * pageSize, pageSize}, new BeanPropertyRowMapper<>(PlanInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
