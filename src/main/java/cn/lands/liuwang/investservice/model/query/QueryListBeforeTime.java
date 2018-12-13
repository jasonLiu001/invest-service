package cn.lands.liuwang.investservice.model.query;

public class QueryListBeforeTime extends QueryListBase {
    //在此时间点之前
    private String beforeTimeStr;

    //查询开始时间
    private String startTimeStr;

    //查询结束时间
    private String endTimeStr;

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public String getStartTimeStr() {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr) {
        this.startTimeStr = startTimeStr;
    }

    public String getBeforeTimeStr() {
        return beforeTimeStr;
    }

    public void setBeforeTimeStr(String beforeTimeStr) {
        this.beforeTimeStr = beforeTimeStr;
    }
}
