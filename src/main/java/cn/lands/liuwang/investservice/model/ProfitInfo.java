package cn.lands.liuwang.investservice.model;

public class ProfitInfo {
    private String investDate;
    private double maxprofit;
    private double minprofit;

    public double getMinprofit() {
        return minprofit;
    }

    public void setMinprofit(double minprofit) {
        this.minprofit = minprofit;
    }

    public String getInvestDate() {
        return investDate;
    }

    public void setInvestDate(String investDate) {
        this.investDate = investDate;
    }

    public double getMaxprofit() {
        return maxprofit;
    }

    public void setMaxprofit(double maxprofit) {
        this.maxprofit = maxprofit;
    }
}
