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
    public List<InvestInfo> findInvestInfoList(int pageIndex, int pageSize, int planType) {
        List<InvestInfo> list = rewardJdbcTemplate.query("SELECT period,planType,investNumberCount,currentAccountBalance,awardMode,winMoney,status,isWin,investTime FROM `invest` WHERE planType=? ORDER BY period DESC LIMIT ?,?;", new Object[]{planType, (pageIndex - 1) * pageSize, pageSize}, new BeanPropertyRowMapper<>(InvestInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
