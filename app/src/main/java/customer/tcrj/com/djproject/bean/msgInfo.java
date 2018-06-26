package customer.tcrj.com.djproject.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leict on 2018/4/26.
 */

public class msgInfo implements Serializable{

    /**
     * message : 执行成功!
     * data : {"content":[{"id":"4028944962e208f30162e215008900a6","optime":"2018-04-26T10:41:28.831+0000","isNewRecord":false,"remarks":"","createBy":"","createDate":"","updateBy":"","updateDate":"","delFlag":"0","purchasePrice":0,"userId":"8ef0da67b0ee4d98ad70b91c2f653617","messageId":"5de485ca8a104698bda27a442736d299","isRead":"0","title":"测试","content":"测试测试","updateByper":"管理员","updateDateper":"2018-04-20 16:04:09"}],"last":true,"totalElements":1,"totalPages":1,"size":9,"number":0,"sort":[{"direction":"ASC","property":"m.isRead","ignoreCase":false,"nullHandling":"NATIVE","ascending":true}],"numberOfElements":1,"first":true}
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
         * content : [{"id":"4028944962e208f30162e215008900a6","optime":"2018-04-26T10:41:28.831+0000","isNewRecord":false,"remarks":"","createBy":"","createDate":"","updateBy":"","updateDate":"","delFlag":"0","purchasePrice":0,"userId":"8ef0da67b0ee4d98ad70b91c2f653617","messageId":"5de485ca8a104698bda27a442736d299","isRead":"0","title":"测试","content":"测试测试","updateByper":"管理员","updateDateper":"2018-04-20 16:04:09"}]
         * last : true
         * totalElements : 1
         * totalPages : 1
         * size : 9
         * number : 0
         * sort : [{"direction":"ASC","property":"m.isRead","ignoreCase":false,"nullHandling":"NATIVE","ascending":true}]
         * numberOfElements : 1
         * first : true
         */

        private boolean last;
        private int totalElements;
        private int totalPages;
        private int size;
        private int number;
        private int numberOfElements;
        private boolean first;
        private List<ContentBean> content;
        private List<SortBean> sort;

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public List<ContentBean> getContent() {
            return content;
        }

        public void setContent(List<ContentBean> content) {
            this.content = content;
        }

        public List<SortBean> getSort() {
            return sort;
        }

        public void setSort(List<SortBean> sort) {
            this.sort = sort;
        }

        public static class ContentBean implements Serializable{
            /**
             * id : 4028944962e208f30162e215008900a6
             * optime : 2018-04-26T10:41:28.831+0000
             * isNewRecord : false
             * remarks :
             * createBy :
             * createDate :
             * updateBy :
             * updateDate :
             * delFlag : 0
             * purchasePrice : 0
             * userId : 8ef0da67b0ee4d98ad70b91c2f653617
             * messageId : 5de485ca8a104698bda27a442736d299
             * isRead : 0
             * title : 测试
             * content : 测试测试
             * updateByper : 管理员
             * updateDateper : 2018-04-20 16:04:09
             */

            private String id;
            private String optime;
            private boolean isNewRecord;
            private String remarks;
            private String createBy;
            private String createDate;
            private String updateBy;
            private String updateDate;
            private String delFlag;
            private int purchasePrice;
            private String userId;
            private String messageId;
            private String isRead;
            private String title;
            private String content;
            private String updateByper;
            private String updateDateper;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getOptime() {
                return optime;
            }

            public void setOptime(String optime) {
                this.optime = optime;
            }

            public boolean isIsNewRecord() {
                return isNewRecord;
            }

            public void setIsNewRecord(boolean isNewRecord) {
                this.isNewRecord = isNewRecord;
            }

            public String getRemarks() {
                return remarks;
            }

            public void setRemarks(String remarks) {
                this.remarks = remarks;
            }

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
            }

            public String getUpdateDate() {
                return updateDate;
            }

            public void setUpdateDate(String updateDate) {
                this.updateDate = updateDate;
            }

            public String getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(String delFlag) {
                this.delFlag = delFlag;
            }

            public int getPurchasePrice() {
                return purchasePrice;
            }

            public void setPurchasePrice(int purchasePrice) {
                this.purchasePrice = purchasePrice;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getMessageId() {
                return messageId;
            }

            public void setMessageId(String messageId) {
                this.messageId = messageId;
            }

            public String getIsRead() {
                return isRead;
            }

            public void setIsRead(String isRead) {
                this.isRead = isRead;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getUpdateByper() {
                return updateByper;
            }

            public void setUpdateByper(String updateByper) {
                this.updateByper = updateByper;
            }

            public String getUpdateDateper() {
                return updateDateper;
            }

            public void setUpdateDateper(String updateDateper) {
                this.updateDateper = updateDateper;
            }
        }

        public static class SortBean {
            /**
             * direction : ASC
             * property : m.isRead
             * ignoreCase : false
             * nullHandling : NATIVE
             * ascending : true
             */

            private String direction;
            private String property;
            private boolean ignoreCase;
            private String nullHandling;
            private boolean ascending;

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getProperty() {
                return property;
            }

            public void setProperty(String property) {
                this.property = property;
            }

            public boolean isIgnoreCase() {
                return ignoreCase;
            }

            public void setIgnoreCase(boolean ignoreCase) {
                this.ignoreCase = ignoreCase;
            }

            public String getNullHandling() {
                return nullHandling;
            }

            public void setNullHandling(String nullHandling) {
                this.nullHandling = nullHandling;
            }

            public boolean isAscending() {
                return ascending;
            }

            public void setAscending(boolean ascending) {
                this.ascending = ascending;
            }
        }
    }
}
