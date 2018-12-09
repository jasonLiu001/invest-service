package cn.lands.liuwang.investservice.model.query;

public class QueryListBeforeTime extends QueryListBase {
    //在此时间点之前
    private String beforeTimeStr;

    //按记录 创建日期 过滤
    private String createTimeStr;

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getBeforeTimeStr() {
        return beforeTimeStr;
    }

    public void setBeforeTimeStr(String beforeTimeStr) {
        this.beforeTimeStr = beforeTimeStr;
    }
}
