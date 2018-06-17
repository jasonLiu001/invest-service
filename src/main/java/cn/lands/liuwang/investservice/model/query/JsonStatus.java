package cn.lands.liuwang.investservice.model.query;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JsonStatus {
    FAILED("调用失败", 0), OK("成功", 1), INVALID("参数错误", 2);
    private String name;
    private int index;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonValue
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private JsonStatus(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
