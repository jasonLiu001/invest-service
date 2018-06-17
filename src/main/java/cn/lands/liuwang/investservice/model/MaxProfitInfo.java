package cn.lands.liuwang.investservice.model;

import java.util.Date;

public class MaxProfitInfo {
    private String period;
    private int planType;
    private double originAccoutBalance;
    private double maxAccountBalance;
    private double profitPercent;
    private int investTotalCount;
    private Date createTime;

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

    public double getOriginAccoutBalance() {
        return originAccoutBalance;
    }

    public void setOriginAccoutBalance(double originAccoutBalance) {
        this.originAccoutBalance = originAccoutBalance;
    }

    public double getMaxAccountBalance() {
        return maxAccountBalance;
    }

    public void setMaxAccountBalance(double maxAccountBalance) {
        this.maxAccountBalance = maxAccountBalance;
    }

    public double getProfitPercent() {
        return profitPercent;
    }

    public void setProfitPercent(double profitPercent) {
        this.profitPercent = profitPercent;
    }

    public int getInvestTotalCount() {
        return investTotalCount;
    }

    public void setInvestTotalCount(int investTotalCount) {
        this.investTotalCount = investTotalCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
