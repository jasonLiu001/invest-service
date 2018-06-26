package cn.lands.liuwang.investservice.dao.impl;

import cn.lands.liuwang.investservice.dao.BaseDao;
import cn.lands.liuwang.investservice.dao.SettingsDao;
import cn.lands.liuwang.investservice.model.SettingsInfo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SettingsDaoImpl extends BaseDao implements SettingsDao {
    @Override
    public List<SettingsInfo> getAllSettings() {
        List<SettingsInfo> list = rewardJdbcTemplate.query("SELECT * FROM settings", new Object[]{}, new BeanPropertyRowMapper<>(SettingsInfo.class));
        if (list.size() > 0) {
            return list;
        } else {
            return null;
        }
    }

    @Override
    public boolean updateSettingsById(SettingsInfo settingsInfo) {
        int i = rewardJdbcTemplate.update("UPDATE settings SET `value`=? WHERE `id`=?", settingsInfo.getValue(), settingsInfo.getId());
        return i > 0;
    }

    @Override
    public SettingsInfo getSettingsByKey(String settingKey) {
        List<SettingsInfo> list = rewardJdbcTemplate.query("SELECT * FROM settings WHERE `key`=?", new Object[]{settingKey}, new BeanPropertyRowMapper<>(SettingsInfo.class));
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }
}
