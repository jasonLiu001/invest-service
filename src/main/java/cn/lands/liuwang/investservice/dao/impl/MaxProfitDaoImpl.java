package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.MaxProfitDao;
import cn.lands.liuwang.investservice.model.MaxProfitInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaxProfitDaoImpl extends BaseDao implements MaxProfitDao {
    /**
     * 查询最大利润列表
     */
    @Override
    public List<MaxProfitInfo> findMaxProfitInfoList(int pageIndex, int pageSize) {
        List<MaxProfitInfo> list = rewardJdbcTemplate.query("SELECT * FROM `max_profit` ORDER BY period DESC LIMIT ?,?;", new Object[]{pageIndex - 1, pageSize}, new BeanPropertyRowMapper<>(MaxProfitInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
