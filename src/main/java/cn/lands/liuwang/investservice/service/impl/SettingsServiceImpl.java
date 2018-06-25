package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.model.SettingsInfo;
import cn.lands.liuwang.investservice.service.BaseService;
import cn.lands.liuwang.investservice.service.SettingsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsServiceImpl extends BaseService implements SettingsService {
    @Override
    public List<SettingsInfo> getAllSettings() {
        return settingsDao.getAllSettings();
    }

    @Override
    public boolean updateSettingsByKey(SettingsInfo settingsInfo) {
        return settingsDao.updateSettingsByKey(settingsInfo);
    }

    @Override
    public SettingsInfo getSettingsByKey(String settingKey) {
        return settingsDao.getSettingsByKey(settingKey);
    }
}
