package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/10/23.
 */

public class info
{

    /**
     * message : 执行成功!
     * data : [{"id":"a8def1e7742f478586e9daadeb225ebf","name":"市级新闻"},{"id":"a8def1e7742f478586e9daadeb225ebf","name":"县级新闻"},{"id":"a8def1e7742f478586e9daadeb225ebf","name":"党委新闻"},{"id":"a8def1e7742f478586e9daadeb225ebf","name":"支部新闻"}]
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

    public static class DataBean {
        /**
         * id : a8def1e7742f478586e9daadeb225ebf
         * name : 市级新闻
         */

        private String id;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
