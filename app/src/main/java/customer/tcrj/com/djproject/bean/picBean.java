package customer.tcrj.com.djproject.bean;

/**
 * Created by leict on 2018/9/26.
 */

public class picBean {

    /**
     * message : 执行成功!
     * data : {"att_ename":"20180926051753382.jpg","att_path":"uploadfile/2018-09-26/20180926051753382.jpg"}
     * errorCode : 0
     */

    private String message;
    private DataBean data;
    private String errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public static class DataBean {
        /**
         * att_ename : 20180926051753382.jpg
         * att_path : uploadfile/2018-09-26/20180926051753382.jpg
         */

        private String att_ename;
        private String att_path;

        public String getAtt_ename() {
            return att_ename;
        }

        public void setAtt_ename(String att_ename) {
            this.att_ename = att_ename;
        }

        public String getAtt_path() {
            return att_path;
        }

        public void setAtt_path(String att_path) {
            this.att_path = att_path;
        }
    }
}
