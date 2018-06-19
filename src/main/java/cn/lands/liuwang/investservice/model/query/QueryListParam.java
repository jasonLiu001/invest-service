package cn.lands.liuwang.investservice.model.query;

/**
 * 开奖号码查询参数
 */
public class QueryListParam {
    private int pageIndex;
    private int pageSize;
    private int planType;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPlanType() {
        return planType;
    }

    public void setPlanType(int planType) {
        this.planType = planType;
    }
}
