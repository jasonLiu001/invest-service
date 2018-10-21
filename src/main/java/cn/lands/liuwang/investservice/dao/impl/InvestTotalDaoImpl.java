package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.InvestTotalDao;
import cn.lands.liuwang.investservice.model.InvestTotalInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvestTotalDaoImpl extends BaseDao implements InvestTotalDao {
    /**
     * 查询所有的投注记录
     */
    @Override
    public List<InvestTotalInfo> findInvestTotalInfoList(int pageIndex, int pageSize, int planType) {
        String sql = "SELECT t.* FROM invest_total t WHERE t.planType=? ORDER BY t.`period` DESC LIMIT ?,?";
        Object[] params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
        List<InvestTotalInfo> list = rewardJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(InvestTotalInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    /**
     * 根据期号查询购买号码
     */
    @Override
    public InvestTotalInfo getInvestTotalInfoByPeriod(int planType, String period) {
        List<InvestTotalInfo> list = rewardJdbcTemplate.query("SELECT * FROM invest_total WHERE period=? AND planType=?", new Object[]{period, planType}, new BeanPropertyRowMapper<>(InvestTotalInfo.class));
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
