package cn.lands.liuwang.investservice.model.query;

public class QueryListBeforeTime extends QueryListBase {
    //在此时间点之前
    private String beforeTimeStr;
    //安记录 创建日期 过滤
    private String createDateStr;

    public String getCreateTimeStr() {
        return createDateStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createDateStr = createTimeStr;
    }

    public String getBeforeTimeStr() {
        return beforeTimeStr;
    }

    public void setBeforeTimeStr(String beforeTimeStr) {
        this.beforeTimeStr = beforeTimeStr;
    }
}
