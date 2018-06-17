package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.InvestDao;
import cn.lands.liuwang.investservice.model.InvestInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InvestDaoImpl extends BaseDao implements InvestDao {

    /**
     * 查询投注记录
     */
    @Override
    public List<InvestInfo> findInvestInfoList(int pageIndex, int pageSize) {
        List<InvestInfo> list = rewardJdbcTemplate.query("SELECT * FROM `invest` ORDER BY period DESC LIMIT ?,?;", new Object[]{pageIndex - 1, pageSize}, new BeanPropertyRowMapper<>(InvestInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
