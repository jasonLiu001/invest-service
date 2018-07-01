package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.InvestDao;
import cn.lands.liuwang.investservice.model.InvestInfo;
import cn.lands.liuwang.investservice.model.ProfitInfo;
import cn.lands.liuwang.investservice.model.ProfitType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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

    @Override
    public InvestInfo getInvestInfoByPeriod(int planType, String period) {
        List<InvestInfo> list = rewardJdbcTemplate.query("SELECT * FROM invest WHERE period=? AND planType=?", new Object[]{period, planType}, new BeanPropertyRowMapper<>(InvestInfo.class));
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }


    @Override
    public List<InvestInfo> findInvestInfoListBeforeTime(int pageIndex, int pageSize, int planType, String beforeTimeStr) {
        List<InvestInfo> list = rewardJdbcTemplate.query("SELECT R1.period,R1.planType,R1.investNumberCount,R1.currentAccountBalance,R1.winMoney,R1.isWin,R1.status,R1.investTime FROM (SELECT A.investDate,MAX(A.period) p1 FROM (SELECT * FROM invest R WHERE R.`investTimestamp`<=?) A\n" +
                "GROUP BY A.investDate) L1 LEFT JOIN invest R1 ON L1.p1=R1.period WHERE R1.`planType`=? ORDER BY L1.p1 DESC LIMIT ?,?", new Object[]{beforeTimeStr, planType, (pageIndex - 1) * pageSize, pageSize}, new BeanPropertyRowMapper<>(InvestInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    /**
     * 查询每天最大利润
     */
    @Override
    public List<ProfitInfo> findInvestInfoListProfit(int pageIndex, int pageSize, int planType, int fixedProfit, ProfitType profitType) {
        String sql;
        Object[] params;
        switch (profitType.getKey()) {
            case "wholeday_maxprofit":
                sql = "SELECT A.investDate,MAX(A.currentAccountBalance) maxporfit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTime`<=CONCAT(DATE_FORMAT(DATE_ADD(R.`investDate`, INTERVAL 1 DAY),'%Y-%m-%d'), ' 02:00:00') AND R.planType=?) A GROUP BY A.investDate ORDER BY A.investDate DESC LIMIT ?,?;";
                params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
                break;
            case "before22_maxprofit":
                sql = "SELECT A.investDate,MAX(A.currentAccountBalance) maxporfit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTimestamp`<='22:00:00' AND R.planType=?) A GROUP BY A.investDate ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
                break;
            case "wholeday_minprofit":
                sql = "SELECT A.investDate,MIN(A.currentAccountBalance) maxporfit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTime`<=CONCAT(DATE_FORMAT(DATE_ADD(R.`investDate`, INTERVAL 1 DAY),'%Y-%m-%d'), ' 02:00:00') AND R.planType=?) A GROUP BY A.investDate ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
                break;
            case "before22_minprofit":
                sql = "SELECT A.investDate,MIN(A.currentAccountBalance) maxporfit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTimestamp`<='22:00:00' AND R.planType=?) A GROUP BY A.investDate ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
                break;
            case "wholeday_fixedprofit":
                sql = "SELECT A.investDate,MAX(A.currentAccountBalance) maxporfit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTime`<=CONCAT(DATE_FORMAT(DATE_ADD(R.`investDate`, INTERVAL 1 DAY),'%Y-%m-%d'), ' 02:00:00') AND R.planType=?) A GROUP BY A.investDate HAVING maxporfit>=? ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, fixedProfit, (pageIndex - 1) * pageSize, pageSize};
                break;
            case "before22_fixedprofit":
                sql = "SELECT A.investDate,MAX(A.currentAccountBalance) maxporfit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTimestamp`<='22:00:00' AND R.planType=?) A GROUP BY A.investDate HAVING maxporfit>=? ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, fixedProfit, (pageIndex - 1) * pageSize, pageSize};
                break;
            default:
                sql = "SELECT A.investDate,MAX(A.currentAccountBalance) maxporfit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTimestamp`<='22:00:00' AND R.planType=?) A GROUP BY A.investDate ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
        }
        List<ProfitInfo> list = rewardJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(ProfitInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }
}
