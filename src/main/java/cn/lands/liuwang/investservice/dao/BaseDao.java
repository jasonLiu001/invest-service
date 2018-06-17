package cn.lands.liuwang.investservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 数据库操作基类
 */
public class BaseDao {
    @Autowired
    @Qualifier("rewardJdbcTemplate")
    protected JdbcTemplate rewardJdbcTemplate;
}
