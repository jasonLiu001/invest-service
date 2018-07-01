package cn.lands.liuwang.investservice.model;

public enum ProfitType {
    WholeDayMaxProfit("全天最大", "wholeday_maxprofit", 1), Before22MaxProfit("截止22点最大", "before22_maxprofit", 2),
    WholeDayMinProfit("全天最小", "wholeday_minprofit", 3), Before22MinProfit("截止22点最小", "before22_minprofit", 4),
    WholeDayFixedProfit("全天固定1200", "wholeday_fixedprofit", 5), Before22FixedProfit("截止22点固定1200", "before22_fixedprofit", 6);
    private String name;
    private String key;
    private int index;

    private ProfitType(String name, String key, int index) {
        this.name = name;
        this.key = key;
        this.index = index;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static ProfitType getProfitTypeByKey(String keyName) {
        for (ProfitType bt : values()) {
            if (bt.key.equalsIgnoreCase(keyName)) {
                return bt;
            }
        }
        return null;
    }
}
