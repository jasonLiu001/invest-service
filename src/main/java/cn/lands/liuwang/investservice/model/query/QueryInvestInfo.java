package cn.lands.liuwang.investservice.model.query;

/**
 *
 * 查询单个实体
 */
public class QueryInvestInfo {
    private String period;
    private int planType;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public int getPlanType() {
        return planType;
    }

    public void setPlanType(int planType) {
        this.planType = planType;
    }
}
