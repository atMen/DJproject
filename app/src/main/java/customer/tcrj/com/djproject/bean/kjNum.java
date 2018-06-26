package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/5/11.
 */

public class kjNum {

    /**
     * message : 执行成功!
     * data : [{"num":1,"type":"13301"},{"num":2,"type":"13302"},{"num":1,"type":"13303"},{"num":1,"type":"13305"}]
     * errorCode : 0
     */

    private String message;
    private String errorCode;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "kjNum{" +
                "message='" + message + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean {
        /**
         * num : 1
         * type : 13301
         */

        private int num;
        private String type;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "num=" + num +
                    ", type='" + type + '\'' +
                    '}';
        }
    }
}
