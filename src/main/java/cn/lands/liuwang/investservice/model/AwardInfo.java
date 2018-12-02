package cn.lands.liuwang.investservice.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 开奖号码
 */
public class AwardInfo {
    private String period;
    private String openNumber;
    private Date openTime;
    private Date createdTime;
    private int updateStatus;

    public int getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(int updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getOpenNumber() {
        return openNumber;
    }

    public void setOpenNumber(String openNumber) {
        this.openNumber = openNumber;
    }

    public Date getOpenTime() {
        return openTime;
    }

    /**
     * 时间格式化
     *
     * @return
     */
    public String getOpenTimeStringFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(openTime);
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public String getCreateTimeStringFormat() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(createdTime);
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

}
