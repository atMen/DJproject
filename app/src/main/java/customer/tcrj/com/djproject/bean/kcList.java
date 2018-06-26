package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/4/26.
 */

public class kcList {


    /**
     * message : 执行成功!
     * data : {"content":[{"id":"663a0a3b759648748467d793ab0a467e","optime":"2018-04-26T06:48:22.894+0000","isNewRecord":false,"remarks":"","createBy":"","createDate":"","updateBy":"","updateDate":"","delFlag":"0","purchasePrice":0,"title":"测试","subTitle":"测试","source":"","subject":"13001","industry":"","serialState":"0","courseClass":"13201","courseIntroduction":"测试","intendedPopulation":"","intendedId":"","courseRule":"0","imgPath":"/uploadfile/ryEbiy/2018-04-26/20180426084626554.jpg","exemId":"","likenum":0,"isPublic":"0","trunPublic":"0","auditStatus":"","publishStatus":"","opinion":"","teacherName":"","teacherId":"","parentId":"","path":"","totalNum":"","finishNum":"0","point":"0","count":"0","progress":""}],"last":true,"totalElements":1,"totalPages":1,"size":2,"number":0,"sort":[{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":1}
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
         * content : [{"id":"663a0a3b759648748467d793ab0a467e","optime":"2018-04-26T06:48:22.894+0000","isNewRecord":false,"remarks":"","createBy":"","createDate":"","updateBy":"","updateDate":"","delFlag":"0","purchasePrice":0,"title":"测试","subTitle":"测试","source":"","subject":"13001","industry":"","serialState":"0","courseClass":"13201","courseIntroduction":"测试","intendedPopulation":"","intendedId":"","courseRule":"0","imgPath":"/uploadfile/ryEbiy/2018-04-26/20180426084626554.jpg","exemId":"","likenum":0,"isPublic":"0","trunPublic":"0","auditStatus":"","publishStatus":"","opinion":"","teacherName":"","teacherId":"","parentId":"","path":"","totalNum":"","finishNum":"0","point":"0","count":"0","progress":""}]
         * last : true
         * totalElements : 1
         * totalPages : 1
         * size : 2
         * number : 0
         * sort : [{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
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
             * id : 663a0a3b759648748467d793ab0a467e
             * optime : 2018-04-26T06:48:22.894+0000
             * isNewRecord : false
             * remarks :
             * createBy :
             * createDate :
             * updateBy :
             * updateDate :
             * delFlag : 0
             * purchasePrice : 0
             * title : 测试
             * subTitle : 测试
             * source :
             * subject : 13001
             * industry :
             * serialState : 0
             * courseClass : 13201
             * courseIntroduction : 测试
             * intendedPopulation :
             * intendedId :
             * courseRule : 0
             * imgPath : /uploadfile/ryEbiy/2018-04-26/20180426084626554.jpg
             * exemId :
             * likenum : 0
             * isPublic : 0
             * trunPublic : 0
             * auditStatus :
             * publishStatus :
             * opinion :
             * teacherName :
             * teacherId :
             * parentId :
             * path :
             * totalNum :
             * finishNum : 0
             * point : 0
             * count : 0
             * progress :
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
            private String title;
            private String subTitle;
            private String source;
            private String subject;
            private String industry;
            private String serialState;
            private String courseClass;
            private String courseIntroduction;
            private String intendedPopulation;
            private String intendedId;
            private String courseRule;
            private String imgPath;
            private String exemId;
            private int likenum;
            private String isPublic;
            private String trunPublic;
            private String auditStatus;
            private String publishStatus;
            private String opinion;
            private String teacherName;
            private String teacherId;
            private String parentId;
            private String path;
            private String totalNum;
            private String finishNum;
            private String point;
            private String count;
            private String progress;

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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubTitle() {
                return subTitle;
            }

            public void setSubTitle(String subTitle) {
                this.subTitle = subTitle;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getIndustry() {
                return industry;
            }

            public void setIndustry(String industry) {
                this.industry = industry;
            }

            public String getSerialState() {
                return serialState;
            }

            public void setSerialState(String serialState) {
                this.serialState = serialState;
            }

            public String getCourseClass() {
                return courseClass;
            }

            public void setCourseClass(String courseClass) {
                this.courseClass = courseClass;
            }

            public String getCourseIntroduction() {
                return courseIntroduction;
            }

            public void setCourseIntroduction(String courseIntroduction) {
                this.courseIntroduction = courseIntroduction;
            }

            public String getIntendedPopulation() {
                return intendedPopulation;
            }

            public void setIntendedPopulation(String intendedPopulation) {
                this.intendedPopulation = intendedPopulation;
            }

            public String getIntendedId() {
                return intendedId;
            }

            public void setIntendedId(String intendedId) {
                this.intendedId = intendedId;
            }

            public String getCourseRule() {
                return courseRule;
            }

            public void setCourseRule(String courseRule) {
                this.courseRule = courseRule;
            }

            public String getImgPath() {
                return imgPath;
            }

            public void setImgPath(String imgPath) {
                this.imgPath = imgPath;
            }

            public String getExemId() {
                return exemId;
            }

            public void setExemId(String exemId) {
                this.exemId = exemId;
            }

            public int getLikenum() {
                return likenum;
            }

            public void setLikenum(int likenum) {
                this.likenum = likenum;
            }

            public String getIsPublic() {
                return isPublic;
            }

            public void setIsPublic(String isPublic) {
                this.isPublic = isPublic;
            }

            public String getTrunPublic() {
                return trunPublic;
            }

            public void setTrunPublic(String trunPublic) {
                this.trunPublic = trunPublic;
            }

            public String getAuditStatus() {
                return auditStatus;
            }

            public void setAuditStatus(String auditStatus) {
                this.auditStatus = auditStatus;
            }

            public String getPublishStatus() {
                return publishStatus;
            }

            public void setPublishStatus(String publishStatus) {
                this.publishStatus = publishStatus;
            }

            public String getOpinion() {
                return opinion;
            }

            public void setOpinion(String opinion) {
                this.opinion = opinion;
            }

            public String getTeacherName() {
                return teacherName;
            }

            public void setTeacherName(String teacherName) {
                this.teacherName = teacherName;
            }

            public String getTeacherId() {
                return teacherId;
            }

            public void setTeacherId(String teacherId) {
                this.teacherId = teacherId;
            }

            public String getParentId() {
                return parentId;
            }

            public void setParentId(String parentId) {
                this.parentId = parentId;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }

            public String getTotalNum() {
                return totalNum;
            }

            public void setTotalNum(String totalNum) {
                this.totalNum = totalNum;
            }

            public String getFinishNum() {
                return finishNum;
            }

            public void setFinishNum(String finishNum) {
                this.finishNum = finishNum;
            }

            public String getPoint() {
                return point;
            }

            public void setPoint(String point) {
                this.point = point;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public String getProgress() {
                return progress;
            }

            public void setProgress(String progress) {
                this.progress = progress;
            }
        }

        public static class SortBean {
            /**
             * direction : DESC
             * property : optime
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
