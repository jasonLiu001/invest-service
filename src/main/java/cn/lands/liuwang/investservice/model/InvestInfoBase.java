package cn.lands.liuwang.investservice.model;

import java.util.Date;

public class InvestInfoBase {
    private String period;
    private int planType;
    private String investNumbers;
    private int investNumberCount;
    private double currentAccountBalance;
    private int awardMode;
    private double winMoney;
    private int status;
    private int isWin;
    private Date investTime;
    private String investTimestamp;
    private String investDate;
    private int isUseReverseInvestNumbers;
    private int touZhuBeiShu;
    private double originAccountBalance;

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

    public String getInvestNumbers() {
        return investNumbers;
    }

    public void setInvestNumbers(String investNumbers) {
        this.investNumbers = investNumbers;
    }

    public int getInvestNumberCount() {
        return investNumberCount;
    }

    public void setInvestNumberCount(int investNumberCount) {
        this.investNumberCount = investNumberCount;
    }

    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    public void setCurrentAccountBalance(double currentAccountBalance) {
        this.currentAccountBalance = currentAccountBalance;
    }

    public int getAwardMode() {
        return awardMode;
    }

    public void setAwardMode(int awardMode) {
        this.awardMode = awardMode;
    }

    public double getWinMoney() {
        return winMoney;
    }

    public void setWinMoney(double winMoney) {
        this.winMoney = winMoney;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIsWin() {
        return isWin;
    }

    public void setIsWin(int isWin) {
        this.isWin = isWin;
    }

    public Date getInvestTime() {
        return investTime;
    }

    public void setInvestTime(Date investTime) {
        this.investTime = investTime;
    }

    public String getInvestTimestamp() {
        return investTimestamp;
    }

    public void setInvestTimestamp(String investTimestamp) {
        this.investTimestamp = investTimestamp;
    }

    public String getInvestDate() {
        return investDate;
    }

    public void setInvestDate(String investDate) {
        this.investDate = investDate;
    }

    public int getIsUseReverseInvestNumbers() {
        return isUseReverseInvestNumbers;
    }

    public void setIsUseReverseInvestNumbers(int isUseReverseInvestNumbers) {
        this.isUseReverseInvestNumbers = isUseReverseInvestNumbers;
    }

    public int getTouZhuBeiShu() {
        return touZhuBeiShu;
    }

    public void setTouZhuBeiShu(int touZhuBeiShu) {
        this.touZhuBeiShu = touZhuBeiShu;
    }

    public double getOriginAccountBalance() {
        return originAccountBalance;
    }

    public void setOriginAccountBalance(double originAccountBalance) {
        this.originAccountBalance = originAccountBalance;
    }
}
