package cn.lands.liuwang.investservice.model.stats;

public class CorrectWrongCountInfo {
    private int planType;
    private int correctCount;
    private int inCorrectCount;

    public int getPlanType() {
        return planType;
    }

    public void setPlanType(int planType) {
        this.planType = planType;
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public int getInCorrectCount() {
        return inCorrectCount;
    }

    public void setInCorrectCount(int inCorrectCount) {
        this.inCorrectCount = inCorrectCount;
    }
}
