package cn.lands.liuwang.investservice.dao;

import cn.lands.liuwang.investservice.model.SettingsInfo;

import java.util.List;

public interface SettingsDao {
    /**
     * 获取所有设置
     */
    List<SettingsInfo> getAllSettings();

    /**
     * 更新设置
     */
    boolean updateSettingsById(SettingsInfo settingsInfo);

    /**
     * 获取单个设置项
     */
    SettingsInfo getSettingsByKey(String settingKey);
}
