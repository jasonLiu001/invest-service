package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.model.query.QueryListBeforeTime;
import cn.lands.liuwang.investservice.model.stats.CorrectWrongCountInfo;
import cn.lands.liuwang.investservice.service.BaseService;
import cn.lands.liuwang.investservice.service.StatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatServiceImpl extends BaseService implements StatService {

    @Override
    public List<CorrectWrongCountInfo> getTotalCorrectAndWrongCount(QueryListBeforeTime queryListBeforeTime) {
        return statDao.getTotalCorrectAndWrongCount(queryListBeforeTime);
    }
}
