package cn.lands.liuwang.investservice.model;

import java.util.List;

public class InvestTotalListInfo {
    private String period;
    private List<InvestTotalInfo> investTotalInfos;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public List<InvestTotalInfo> getInvestTotalInfos() {
        return investTotalInfos;
    }

    public void setInvestTotalInfos(List<InvestTotalInfo> investTotalInfos) {
        this.investTotalInfos = investTotalInfos;
    }
}
