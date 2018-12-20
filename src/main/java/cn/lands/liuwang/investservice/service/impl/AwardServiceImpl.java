package cn.lands.liuwang.investservice.service.impl;

import cn.lands.liuwang.investservice.dao.AwardDao;
import cn.lands.liuwang.investservice.model.AwardInfo;
import cn.lands.liuwang.investservice.model.query.QueryListBase;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class AwardServiceImpl extends BaseService implements AwardService {
    /**
     * 查询开奖号码
     */
    @Override
    public List<AwardInfo> findAwardInfoList(QueryListBase listParam) {
        return awardDao.findAwardInfoList(listParam);
    }

    @Override
    public boolean saveAwardInfo(AwardInfo awardInfo) {
        return awardDao.saveAwardInfo(awardInfo);
    }

    @Override
    public List<AwardInfo> getAwardInfoList(int source) throws IOException {
        List<AwardInfo> awardInfoList = new ArrayList<>();
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

                        //这个网站的期号处理和其他网站有区别，需要特别处理，多加了一位
                        int formatPeriod = Integer.valueOf(period);
                        int resultPeriod = formatPeriod - 1;

                        if (resultPeriod == 0) {//单独处理这个特殊情况 120的期号，肯定上前一天的时间，因为更新发生在下一天
                            resultPeriod = 120;
                            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                            Date dt = null;
                            try {
                                //解析时间
                                dt = dateFormatter.parse(openDateArr[1]);
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                            Calendar rightNow = Calendar.getInstance();
                            rightNow.setTime(dt);
                            rightNow.add(Calendar.DAY_OF_YEAR, -1);//日期减1天

                            Date prevDay = rightNow.getTime();

                            dateFormatter = new SimpleDateFormat("yyyyMMdd");
                            String prevDayStr = dateFormatter.format(prevDay);

                            period = prevDayStr + "-" + String.valueOf(resultPeriod);
                        } else if (String.valueOf(resultPeriod).length() == 1) {
                            period = openDateArr[1].replaceAll("-", "") + "-00" + String.valueOf(resultPeriod);
                        } else if (String.valueOf(resultPeriod).length() == 2) {
                            period = openDateArr[1].replaceAll("-", "") + "-0" + String.valueOf(resultPeriod);
                        } else if (String.valueOf(resultPeriod).length() == 3) {
                            period = openDateArr[1].replaceAll("-", "") + "-" + String.valueOf(resultPeriod);
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

        return awardInfoList;
    }
}
