package customer.tcrj.com.djproject.bean;

/**
 * Created by leict on 2018/9/13.
 */

public class loginBean {

    /**
     * data :
     * message : 用户名不存在
     * errorCode : 040013
     */

    private String data;
    private String message;
    private String errorCode;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
