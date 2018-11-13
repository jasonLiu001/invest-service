package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.dao.AwardDao;
import cn.lands.liuwang.investservice.model.AwardInfo;
import cn.lands.liuwang.investservice.service.AwardService;
import cn.lands.liuwang.investservice.service.BaseService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AwardServiceImpl extends BaseService implements AwardService {
    /**
     * 查询开奖号码
     */
    @Override
    public List<AwardInfo> findAwardInfoList(int pageIndex, int pageSize) {
        return awardDao.findAwardInfoList(pageIndex, pageSize);
    }

    @Override
    public boolean saveAwardInfo(AwardInfo awardInfo) {
        return awardDao.saveAwardInfo(awardInfo);
    }

    @Override
    public void getAwardInfoList(List<AwardInfo> awardInfoList) throws IOException {
        Document doc = Jsoup.connect("https://www.km28.com/lottery-gp/cqssc.html").get();
        String openDateText = doc.select("div.r-box.fl.clearfix>div.padding>span:eq(1)").first().html();
        String[] openDateArr = openDateText.split("：");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (openDateArr.length == 2) {
            Elements tables = doc.select("table.tac.fl");
            for (Element table : tables) {
                Elements rows = table.select("tbody tr");
                for (Element row : rows) {
                    Elements columns = row.select("tr td");
                    if (columns.size() == 3 && !columns.get(0).html().equals("")) {
                        String period = columns.get(0).html();
                        String openTime = columns.get(1).html();
                        String openNumber = columns.get(2).html().replaceAll("\\s*", "");

                        if (period.length() == 2) {
                            period = openDateArr[1].replaceAll("-", "") + "-0" + period;
                        }

                        openTime = openDateArr[1] + " " + openTime + ":00";

                        AwardInfo awardModel = new AwardInfo();
                        awardModel.setPeriod(period);

                        try {
                            awardModel.setOpenTime(formatter.parse(openTime));
                        } catch (Exception ex) {
                            awardModel.setOpenTime(new Date());
                        }

                        awardModel.setOpenNumber(openNumber);
                        awardInfoList.add(awardModel);
                    }
                }
            }
        }
    }
}
