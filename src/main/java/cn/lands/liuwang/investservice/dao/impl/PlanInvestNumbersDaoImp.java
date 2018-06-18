package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.PlanInvestNumbersDao;
import cn.lands.liuwang.investservice.model.PlanInvestNumberInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanInvestNumbersDaoImp extends BaseDao implements PlanInvestNumbersDao {
    @Override
    public List<PlanInvestNumberInfo> findInvestNumbersInfoList(int pageIndex, int pageSize) {
        List<PlanInvestNumberInfo> list = rewardJdbcTemplate.query("SELECT * FROM `plan_invest_numbers` ORDER BY period DESC LIMIT ?,?;", new Object[]{(pageIndex - 1) * pageSize, pageSize}, new BeanPropertyRowMapper<>(PlanInvestNumberInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
