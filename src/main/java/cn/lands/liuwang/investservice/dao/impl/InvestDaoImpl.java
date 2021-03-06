package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.InvestDao;
import cn.lands.liuwang.investservice.model.InvestInfo;
import cn.lands.liuwang.investservice.model.ProfitInfo;
import cn.lands.liuwang.investservice.model.ProfitType;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvestDaoImpl extends BaseDao implements InvestDao {

    /**
     * 查询投注记录
     */
    @Override
    public List<InvestInfo> findInvestInfoList(int pageIndex, int pageSize, int planType, String beforeTimeStr) {
        String sql;
        Object[] params;
        if (StringUtils.isEmpty(beforeTimeStr)) {
            sql = "SELECT * FROM `invest` WHERE planType=? ORDER BY period DESC LIMIT ?,?";
            params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
        } else {
            sql = "SELECT * FROM `invest` WHERE planType=? AND investTimestamp>='09:50:00' AND investTimestamp<=? ORDER BY period DESC LIMIT ?,?";
            params = new Object[]{planType, beforeTimeStr, (pageIndex - 1) * pageSize, pageSize};
        }
        List<InvestInfo> list = rewardJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(InvestInfo.class));
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
        String sql;
        Object[] params;
        if (beforeTimeStr.equals("22:00:00")) {//截止22点前
            sql = "SELECT R1.* FROM (SELECT A.investDate,MAX(A.period) p1 FROM (SELECT * FROM invest R WHERE R.investTimestamp>='09:50:00' AND R.`investTimestamp`<=?) A\n" +
                    "GROUP BY A.investDate) L1 LEFT JOIN invest R1 ON L1.p1=R1.period WHERE R1.`planType`=? ORDER BY L1.p1 DESC LIMIT ?,?";
            params = new Object[]{beforeTimeStr, planType, (pageIndex - 1) * pageSize, pageSize};
        } else {
            sql = "SELECT R1.* FROM (SELECT A.investDate,MAX(A.period) p1 FROM (SELECT * FROM invest R WHERE R.`investTimestamp`<=?) A\n" +
                    "GROUP BY A.investDate) L1 LEFT JOIN invest R1 ON L1.p1=R1.period WHERE R1.`planType`=? ORDER BY L1.p1 DESC LIMIT ?,?";
            params = new Object[]{beforeTimeStr, planType, (pageIndex - 1) * pageSize, pageSize};
        }
        List<InvestInfo> list = rewardJdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(InvestInfo.class));
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
                sql = "SELECT A.investDate,MIN(A.currentAccountBalance) minprofit,MAX(A.currentAccountBalance) maxprofit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTimestamp`<='23:59:59' AND R.planType=?) A GROUP BY A.investDate ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
                break;
            case "before22_maxprofit":
                sql = "SELECT A.investDate,MIN(A.currentAccountBalance) minprofit,MAX(A.currentAccountBalance) maxprofit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTimestamp`<='22:00:00' AND R.planType=?) A GROUP BY A.investDate ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
                break;
            case "wholeday_minprofit":
                sql = "SELECT A.investDate,MIN(A.currentAccountBalance) minprofit,MAX(A.currentAccountBalance) maxprofit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTimestamp`<='23:59:59' AND R.planType=?) A GROUP BY A.investDate ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
                break;
            case "before22_minprofit":
                sql = "SELECT A.investDate,MIN(A.currentAccountBalance) minprofit,MAX(A.currentAccountBalance) maxprofit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTimestamp`<='22:00:00' AND R.planType=?) A GROUP BY A.investDate ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, (pageIndex - 1) * pageSize, pageSize};
                break;
            case "wholeday_fixedprofit":
                sql = "SELECT A.investDate,MIN(A.currentAccountBalance) minprofit,MAX(A.currentAccountBalance) maxprofit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTimestamp`<='23:59:59' AND R.planType=?) A GROUP BY A.investDate HAVING maxprofit>=? ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, fixedProfit, (pageIndex - 1) * pageSize, pageSize};
                break;
            case "before22_fixedprofit":
                sql = "SELECT A.investDate,MIN(A.currentAccountBalance) minprofit,MAX(A.currentAccountBalance) maxprofit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTimestamp`<='22:00:00' AND R.planType=?) A GROUP BY A.investDate HAVING maxprofit>=? ORDER BY A.investDate DESC LIMIT ?,?";
                params = new Object[]{planType, fixedProfit, (pageIndex - 1) * pageSize, pageSize};
                break;
            default:
                sql = "SELECT A.investDate,MIN(A.currentAccountBalance) minprofit,MAX(A.currentAccountBalance) maxprofit FROM (SELECT * FROM invest R WHERE R.`investTimestamp`>='10:00:00' AND R.`investTimestamp`<='22:00:00' AND R.planType=?) A GROUP BY A.investDate ORDER BY A.investDate DESC LIMIT ?,?";
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
