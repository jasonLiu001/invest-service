package cn.lands.liuwang.investservice.model.query;

public class QueryListProfit extends QueryListBase {
    private int fixedProfit;
    private String profitType;

    public String getProfitType() {
        return profitType;
    }

    public void setProfitType(String profitType) {
        this.profitType = profitType;
    }

    public int getFixedProfit() {
        return fixedProfit;
    }

    public void setFixedProfit(int fixedProfit) {
        this.fixedProfit = fixedProfit;
    }


}
