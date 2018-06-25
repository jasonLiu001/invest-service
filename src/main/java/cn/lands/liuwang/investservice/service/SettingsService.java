package cn.lands.liuwang.investservice.service;

import cn.lands.liuwang.investservice.model.SettingsInfo;

import java.util.List;

public interface SettingsService {
    /**
     * 获取所有设置
     */
    List<SettingsInfo> getAllSettings();

    /**
     * 更新设置
     */
    boolean updateSettingsByKey(SettingsInfo settingsInfo);

    /**
     * 获取单个设置项
     */
    SettingsInfo getSettingsByKey(String settingKey);
}
