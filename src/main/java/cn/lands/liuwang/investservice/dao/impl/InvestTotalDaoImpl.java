package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.InvestTotalDao;
import cn.lands.liuwang.investservice.model.InvestTotalInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvestTotalDaoImpl extends BaseDao implements InvestTotalDao {
    /**
     * 查询所有的投注记录
     */
    @Override
    public List<InvestTotalInfo> findInvestTotalInfoList(int pageIndex, int pageSize, int planType, String beforeTimeStr, String startTimeStr, String endTimeStr) {
        String sql;
        Object[] params;
        if (!StringUtils.isEmpty(beforeTimeStr)) {
            sql = "SELECT * FROM `invest_total` WHERE planType=? AND investTimestamp>='09:50:00' AND investTimestamp<=? ORDER BY period DESC LIMIT ?,?";
            params = new Object[]{planType, beforeTimeStr, (pageIndex - 1) * pageSize, pageSize};
        } else if (!StringUtils.isEmpty(startTimeStr) && !StringUtils.isEmpty(endTimeStr)) {
            sql = "SELECT t.* FROM invest_total t WHERE t.planType=? AND t.investTime>=? AND t.investTime<=? ORDER BY t.`period` DESC LIMIT ?,?";
            params = new Object[]{planType, startTimeStr, endTimeStr, (pageIndex - 1) * pageSize, pageSize};
        } else {
            sql = "SELECT t.* FROM invest_total t WHERE t.planType=? ORDER BY t.`period` DESC LIMIT ?,?";
            params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
        }
        List<InvestTotalInfo> list = rewardJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(InvestTotalInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 根据期号查询购买号码
     */
    @Override
    public InvestTotalInfo getInvestTotalInfoByPeriod(int planType, String period) {
        List<InvestTotalInfo> list = rewardJdbcTemplate.query("SELECT i.*,a.`openNumber`,a.`openTime` FROM invest_total AS i LEFT JOIN award AS a ON i.`period`=a.`period` WHERE i.period=? AND i.planType=?", new Object[]{period, planType}, new BeanPropertyRowMapper<>(InvestTotalInfo.class));
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
