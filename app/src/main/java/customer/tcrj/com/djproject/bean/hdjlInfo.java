package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/5/3.
 */

public class hdjlInfo {

    /**
     * message : 执行成功!
     * data : {"content":[{"id":"50f0cfa592f24309b62066db5782dbae","optime":"2018-04-25T09:27:12.000+0000","modelId":"d9c9b6b9adf04ae08997c3f7315344b9","modelName":"","userName":"","userAge":"","userSex":"0","userIDCard":"","userPhone":"","userEmail":"","userAddress":"","userIp":"127.0.0.1","msgCode":"0","msgTitle":"张三","msgContent":"我的心愿我的心愿我的心愿我的心愿我的心愿我的心愿","msgIsPublish":"1","msgIsReply":"0","msgDoContent":"","msgAddTime":"2018-04-25 17:27:12","msgIsOpen":"0","msgAcceptDtime":"","msgOverTime":"","msgNoAcceptDtime":"","msgNoAcceptOpin":"","msgZwwxDtime":"","msgZwwxOpin":"","submitDeptId":"","submitDeptName":"","msgDoDeptId":"","msgDoDeptName":"","sqGoalId":"","sqGoalName":"","msgFiltrateType":"0","msgSelectPwd":"","msgStatus":"0","superviseFlag":"0","alarmFlag":"0","timeoutFlag":"0","timeLimit":"0","hotReply":"","hotReplyName":"","xjpcFlag":"0","delayFlag":"0","delayAppFlag":"","flowInsId":"","flowInsAppState":"0","msgFlag":"0","degreeOfSatisfaction":"0"}],"last":true,"totalElements":1,"totalPages":1,"size":5,"number":0,"sort":[{"direction":"DESC","property":"msgAddTime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":1}
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
         * content : [{"id":"50f0cfa592f24309b62066db5782dbae","optime":"2018-04-25T09:27:12.000+0000","modelId":"d9c9b6b9adf04ae08997c3f7315344b9","modelName":"","userName":"","userAge":"","userSex":"0","userIDCard":"","userPhone":"","userEmail":"","userAddress":"","userIp":"127.0.0.1","msgCode":"0","msgTitle":"张三","msgContent":"我的心愿我的心愿我的心愿我的心愿我的心愿我的心愿","msgIsPublish":"1","msgIsReply":"0","msgDoContent":"","msgAddTime":"2018-04-25 17:27:12","msgIsOpen":"0","msgAcceptDtime":"","msgOverTime":"","msgNoAcceptDtime":"","msgNoAcceptOpin":"","msgZwwxDtime":"","msgZwwxOpin":"","submitDeptId":"","submitDeptName":"","msgDoDeptId":"","msgDoDeptName":"","sqGoalId":"","sqGoalName":"","msgFiltrateType":"0","msgSelectPwd":"","msgStatus":"0","superviseFlag":"0","alarmFlag":"0","timeoutFlag":"0","timeLimit":"0","hotReply":"","hotReplyName":"","xjpcFlag":"0","delayFlag":"0","delayAppFlag":"","flowInsId":"","flowInsAppState":"0","msgFlag":"0","degreeOfSatisfaction":"0"}]
         * last : true
         * totalElements : 1
         * totalPages : 1
         * size : 5
         * number : 0
         * sort : [{"direction":"DESC","property":"msgAddTime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
         * first : true
         * numberOfElements : 1
         */

        private boolean last;
        private int totalElements;
        private int totalPages;
        private int size;
        private int number;
        private boolean first;
        private int numberOfElements;
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

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
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

        public static class ContentBean {
            /**
             * id : 50f0cfa592f24309b62066db5782dbae
             * optime : 2018-04-25T09:27:12.000+0000
             * modelId : d9c9b6b9adf04ae08997c3f7315344b9
             * modelName :
             * userName :
             * userAge :
             * userSex : 0
             * userIDCard :
             * userPhone :
             * userEmail :
             * userAddress :
             * userIp : 127.0.0.1
             * msgCode : 0
             * msgTitle : 张三
             * msgContent : 我的心愿我的心愿我的心愿我的心愿我的心愿我的心愿
             * msgIsPublish : 1
             * msgIsReply : 0
             * msgDoContent :
             * msgAddTime : 2018-04-25 17:27:12
             * msgIsOpen : 0
             * msgAcceptDtime :
             * msgOverTime :
             * msgNoAcceptDtime :
             * msgNoAcceptOpin :
             * msgZwwxDtime :
             * msgZwwxOpin :
             * submitDeptId :
             * submitDeptName :
             * msgDoDeptId :
             * msgDoDeptName :
             * sqGoalId :
             * sqGoalName :
             * msgFiltrateType : 0
             * msgSelectPwd :
             * msgStatus : 0
             * superviseFlag : 0
             * alarmFlag : 0
             * timeoutFlag : 0
             * timeLimit : 0
             * hotReply :
             * hotReplyName :
             * xjpcFlag : 0
             * delayFlag : 0
             * delayAppFlag :
             * flowInsId :
             * flowInsAppState : 0
             * msgFlag : 0
             * degreeOfSatisfaction : 0
             */

            private String id;
            private String optime;
            private String modelId;
            private String modelName;
            private String userName;
            private String userAge;
            private String userSex;
            private String userIDCard;
            private String userPhone;
            private String userEmail;
            private String userAddress;
            private String userIp;
            private String msgCode;
            private String msgTitle;
            private String msgContent;
            private String msgIsPublish;
            private String msgIsReply;
            private String msgDoContent;
            private String msgAddTime;
            private String msgIsOpen;
            private String msgAcceptDtime;
            private String msgOverTime;
            private String msgNoAcceptDtime;
            private String msgNoAcceptOpin;
            private String msgZwwxDtime;
            private String msgZwwxOpin;
            private String submitDeptId;
            private String submitDeptName;
            private String msgDoDeptId;
            private String msgDoDeptName;
            private String sqGoalId;
            private String sqGoalName;
            private String msgFiltrateType;
            private String msgSelectPwd;
            private String msgStatus;
            private String superviseFlag;
            private String alarmFlag;
            private String timeoutFlag;
            private String timeLimit;
            private String hotReply;
            private String hotReplyName;
            private String xjpcFlag;
            private String delayFlag;
            private String delayAppFlag;
            private String flowInsId;
            private String flowInsAppState;
            private String msgFlag;
            private String degreeOfSatisfaction;

            public ContentBean(String userName, String msgContent) {
                this.userName = userName;
                this.msgContent = msgContent;
            }

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

            public String getModelId() {
                return modelId;
            }

            public void setModelId(String modelId) {
                this.modelId = modelId;
            }

            public String getModelName() {
                return modelName;
            }

            public void setModelName(String modelName) {
                this.modelName = modelName;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUserAge() {
                return userAge;
            }

            public void setUserAge(String userAge) {
                this.userAge = userAge;
            }

            public String getUserSex() {
                return userSex;
            }

            public void setUserSex(String userSex) {
                this.userSex = userSex;
            }

            public String getUserIDCard() {
                return userIDCard;
            }

            public void setUserIDCard(String userIDCard) {
                this.userIDCard = userIDCard;
            }

            public String getUserPhone() {
                return userPhone;
            }

            public void setUserPhone(String userPhone) {
                this.userPhone = userPhone;
            }

            public String getUserEmail() {
                return userEmail;
            }

            public void setUserEmail(String userEmail) {
                this.userEmail = userEmail;
            }

            public String getUserAddress() {
                return userAddress;
            }

            public void setUserAddress(String userAddress) {
                this.userAddress = userAddress;
            }

            public String getUserIp() {
                return userIp;
            }

            public void setUserIp(String userIp) {
                this.userIp = userIp;
            }

            public String getMsgCode() {
                return msgCode;
            }

            public void setMsgCode(String msgCode) {
                this.msgCode = msgCode;
            }

            public String getMsgTitle() {
                return msgTitle;
            }

            public void setMsgTitle(String msgTitle) {
                this.msgTitle = msgTitle;
            }

            public String getMsgContent() {
                return msgContent;
            }

            public void setMsgContent(String msgContent) {
                this.msgContent = msgContent;
            }

            public String getMsgIsPublish() {
                return msgIsPublish;
            }

            public void setMsgIsPublish(String msgIsPublish) {
                this.msgIsPublish = msgIsPublish;
            }

            public String getMsgIsReply() {
                return msgIsReply;
            }

            public void setMsgIsReply(String msgIsReply) {
                this.msgIsReply = msgIsReply;
            }

            public String getMsgDoContent() {
                return msgDoContent;
            }

            public void setMsgDoContent(String msgDoContent) {
                this.msgDoContent = msgDoContent;
            }

            public String getMsgAddTime() {
                return msgAddTime;
            }

            public void setMsgAddTime(String msgAddTime) {
                this.msgAddTime = msgAddTime;
            }

            public String getMsgIsOpen() {
                return msgIsOpen;
            }

            public void setMsgIsOpen(String msgIsOpen) {
                this.msgIsOpen = msgIsOpen;
            }

            public String getMsgAcceptDtime() {
                return msgAcceptDtime;
            }

            public void setMsgAcceptDtime(String msgAcceptDtime) {
                this.msgAcceptDtime = msgAcceptDtime;
            }

            public String getMsgOverTime() {
                return msgOverTime;
            }

            public void setMsgOverTime(String msgOverTime) {
                this.msgOverTime = msgOverTime;
            }

            public String getMsgNoAcceptDtime() {
                return msgNoAcceptDtime;
            }

            public void setMsgNoAcceptDtime(String msgNoAcceptDtime) {
                this.msgNoAcceptDtime = msgNoAcceptDtime;
            }

            public String getMsgNoAcceptOpin() {
                return msgNoAcceptOpin;
            }

            public void setMsgNoAcceptOpin(String msgNoAcceptOpin) {
                this.msgNoAcceptOpin = msgNoAcceptOpin;
            }

            public String getMsgZwwxDtime() {
                return msgZwwxDtime;
            }

            public void setMsgZwwxDtime(String msgZwwxDtime) {
                this.msgZwwxDtime = msgZwwxDtime;
            }

            public String getMsgZwwxOpin() {
                return msgZwwxOpin;
            }

            public void setMsgZwwxOpin(String msgZwwxOpin) {
                this.msgZwwxOpin = msgZwwxOpin;
            }

            public String getSubmitDeptId() {
                return submitDeptId;
            }

            public void setSubmitDeptId(String submitDeptId) {
                this.submitDeptId = submitDeptId;
            }

            public String getSubmitDeptName() {
                return submitDeptName;
            }

            public void setSubmitDeptName(String submitDeptName) {
                this.submitDeptName = submitDeptName;
            }

            public String getMsgDoDeptId() {
                return msgDoDeptId;
            }

            public void setMsgDoDeptId(String msgDoDeptId) {
                this.msgDoDeptId = msgDoDeptId;
            }

            public String getMsgDoDeptName() {
                return msgDoDeptName;
            }

            public void setMsgDoDeptName(String msgDoDeptName) {
                this.msgDoDeptName = msgDoDeptName;
            }

            public String getSqGoalId() {
                return sqGoalId;
            }

            public void setSqGoalId(String sqGoalId) {
                this.sqGoalId = sqGoalId;
            }

            public String getSqGoalName() {
                return sqGoalName;
            }

            public void setSqGoalName(String sqGoalName) {
                this.sqGoalName = sqGoalName;
            }

            public String getMsgFiltrateType() {
                return msgFiltrateType;
            }

            public void setMsgFiltrateType(String msgFiltrateType) {
                this.msgFiltrateType = msgFiltrateType;
            }

            public String getMsgSelectPwd() {
                return msgSelectPwd;
            }

            public void setMsgSelectPwd(String msgSelectPwd) {
                this.msgSelectPwd = msgSelectPwd;
            }

            public String getMsgStatus() {
                return msgStatus;
            }

            public void setMsgStatus(String msgStatus) {
                this.msgStatus = msgStatus;
            }

            public String getSuperviseFlag() {
                return superviseFlag;
            }

            public void setSuperviseFlag(String superviseFlag) {
                this.superviseFlag = superviseFlag;
            }

            public String getAlarmFlag() {
                return alarmFlag;
            }

            public void setAlarmFlag(String alarmFlag) {
                this.alarmFlag = alarmFlag;
            }

            public String getTimeoutFlag() {
                return timeoutFlag;
            }

            public void setTimeoutFlag(String timeoutFlag) {
                this.timeoutFlag = timeoutFlag;
            }

            public String getTimeLimit() {
                return timeLimit;
            }

            public void setTimeLimit(String timeLimit) {
                this.timeLimit = timeLimit;
            }

            public String getHotReply() {
                return hotReply;
            }

            public void setHotReply(String hotReply) {
                this.hotReply = hotReply;
            }

            public String getHotReplyName() {
                return hotReplyName;
            }

            public void setHotReplyName(String hotReplyName) {
                this.hotReplyName = hotReplyName;
            }

            public String getXjpcFlag() {
                return xjpcFlag;
            }

            public void setXjpcFlag(String xjpcFlag) {
                this.xjpcFlag = xjpcFlag;
            }

            public String getDelayFlag() {
                return delayFlag;
            }

            public void setDelayFlag(String delayFlag) {
                this.delayFlag = delayFlag;
            }

            public String getDelayAppFlag() {
                return delayAppFlag;
            }

            public void setDelayAppFlag(String delayAppFlag) {
                this.delayAppFlag = delayAppFlag;
            }

            public String getFlowInsId() {
                return flowInsId;
            }

            public void setFlowInsId(String flowInsId) {
                this.flowInsId = flowInsId;
            }

            public String getFlowInsAppState() {
                return flowInsAppState;
            }

            public void setFlowInsAppState(String flowInsAppState) {
                this.flowInsAppState = flowInsAppState;
            }

            public String getMsgFlag() {
                return msgFlag;
            }

            public void setMsgFlag(String msgFlag) {
                this.msgFlag = msgFlag;
            }

            public String getDegreeOfSatisfaction() {
                return degreeOfSatisfaction;
            }

            public void setDegreeOfSatisfaction(String degreeOfSatisfaction) {
                this.degreeOfSatisfaction = degreeOfSatisfaction;
            }
        }

        public static class SortBean {
            /**
             * direction : DESC
             * property : msgAddTime
             * ignoreCase : false
             * nullHandling : NATIVE
             * ascending : false
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
