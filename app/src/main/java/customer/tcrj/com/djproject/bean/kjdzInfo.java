package customer.tcrj.com.djproject.bean;

/**
 * Created by leict on 2018/4/26.
 */

public class kjdzInfo {

    /**
     * message : 取消了点赞
     * data :
     * errorCode : -1
     */

    private String message;
    private String data;
    private String errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
