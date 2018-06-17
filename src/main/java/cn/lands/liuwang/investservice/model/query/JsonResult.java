package cn.lands.liuwang.investservice.model.query;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JsonResult {
    //返回结果0成功
    private JsonStatus status;
    //返回内容
    private String message;
    //返回数据
    private Object data;

    /**
     * api接口返回结果
     *
     * @param status  状态
     * @param message 结果描述
     */
    public JsonResult(JsonStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public JsonStatus getStatus() {
        return status;
    }

    public void setStatus(JsonStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
