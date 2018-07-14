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
        String sql = "SELECT t.period,t.planType,t.investNumberCount,t.currentAccountBalance,t.winMoney,t.isWin,t.status,t.investTime FROM invest_total t WHERE t.planType=? ORDER BY t.`period` DESC LIMIT ?,?";
        Object[] params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
        List<InvestTotalInfo> list = rewardJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(InvestTotalInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
