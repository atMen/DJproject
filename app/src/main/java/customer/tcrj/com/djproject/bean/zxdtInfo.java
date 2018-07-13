package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/7/5.
 */

public class zxdtInfo {


    /**
     * message : 执行成功!
     * data : {"content":[{"id":"887984d215e441c6ac62adc005552949","optime":"2018-07-06T02:56:39.971+0000","isNewRecord":false,"remarks":"","createBy":"c0bed7e69ea9457fa9b7285f466d1c3e","createDate":"","updateBy":"","updateDate":"","delFlag":"0","createUser":{"id":"c0bed7e69ea9457fa9b7285f466d1c3e","optime":"2018-05-30T08:59:38.000+0000","cname":"刘彤","ename":"liutong","sort":0,"enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"7f859e95fb05498e83c0e8e04e4999e3","departmentName":"","code":"","sex":"1","mobile":"18149297777","email":"","address":"陕西省榆林市","note":""},"purchasePrice":0,"examName":"123","examSubscribe":"","examType":"1280401","effTime":"2018-07-05 19:07","expTime":"2018-07-06 19:07","examPaperId":"9efa272eab8642179d46f2dbdf267b34","seriNo":"180705c0bed7e69ea9457fa9b7285f466d1c3e887984d215e441c6ac62adc005552949","totalPoint":0,"passPoint":0,"type":"questions","state":"0","approved":"1","ksjxzt":"","sjeffTime":"","sjexpTime":"","score":123,"examPaperName":"1111","total":0,"waitCome":0,"inCome":0,"outCome":0,"pointGet":0,"startTime":"0"},{"id":"3d841249f1d9419a87c3e2b1b990528b","optime":"2018-07-06T02:56:39.971+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"","updateBy":"","updateDate":"","delFlag":"0","createUser":{"id":"1","optime":"2018-07-05T09:36:33.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"examName":"榆林党建第一期考试","examSubscribe":"","examType":"1280401","effTime":"2018-05-21 19:41","expTime":"2018-05-22 19:41","examPaperId":"731a4394a08742a88f815bd04c5af88a","seriNo":"180521c0bed7e69ea9457fa9b7285f466d1c3e3d841249f1d9419a87c3e2b1b990528b","totalPoint":0,"passPoint":0,"type":"questions","state":"0","approved":"3","ksjxzt":"","sjeffTime":"","sjexpTime":"","score":2,"examPaperName":"Y-党建考试","total":0,"waitCome":0,"inCome":0,"outCome":0,"pointGet":0,"startTime":"0"}],"totalElements":2,"totalPages":1,"last":true,"number":0,"size":15,"sort":[{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":2}
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
         * content : [{"id":"887984d215e441c6ac62adc005552949","optime":"2018-07-06T02:56:39.971+0000","isNewRecord":false,"remarks":"","createBy":"c0bed7e69ea9457fa9b7285f466d1c3e","createDate":"","updateBy":"","updateDate":"","delFlag":"0","createUser":{"id":"c0bed7e69ea9457fa9b7285f466d1c3e","optime":"2018-05-30T08:59:38.000+0000","cname":"刘彤","ename":"liutong","sort":0,"enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"7f859e95fb05498e83c0e8e04e4999e3","departmentName":"","code":"","sex":"1","mobile":"18149297777","email":"","address":"陕西省榆林市","note":""},"purchasePrice":0,"examName":"123","examSubscribe":"","examType":"1280401","effTime":"2018-07-05 19:07","expTime":"2018-07-06 19:07","examPaperId":"9efa272eab8642179d46f2dbdf267b34","seriNo":"180705c0bed7e69ea9457fa9b7285f466d1c3e887984d215e441c6ac62adc005552949","totalPoint":0,"passPoint":0,"type":"questions","state":"0","approved":"1","ksjxzt":"","sjeffTime":"","sjexpTime":"","score":123,"examPaperName":"1111","total":0,"waitCome":0,"inCome":0,"outCome":0,"pointGet":0,"startTime":"0"},{"id":"3d841249f1d9419a87c3e2b1b990528b","optime":"2018-07-06T02:56:39.971+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"","updateBy":"","updateDate":"","delFlag":"0","createUser":{"id":"1","optime":"2018-07-05T09:36:33.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"examName":"榆林党建第一期考试","examSubscribe":"","examType":"1280401","effTime":"2018-05-21 19:41","expTime":"2018-05-22 19:41","examPaperId":"731a4394a08742a88f815bd04c5af88a","seriNo":"180521c0bed7e69ea9457fa9b7285f466d1c3e3d841249f1d9419a87c3e2b1b990528b","totalPoint":0,"passPoint":0,"type":"questions","state":"0","approved":"3","ksjxzt":"","sjeffTime":"","sjexpTime":"","score":2,"examPaperName":"Y-党建考试","total":0,"waitCome":0,"inCome":0,"outCome":0,"pointGet":0,"startTime":"0"}]
         * totalElements : 2
         * totalPages : 1
         * last : true
         * number : 0
         * size : 15
         * sort : [{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
         * first : true
         * numberOfElements : 2
         */

        private int totalElements;
        private int totalPages;
        private boolean last;
        private int number;
        private int size;
        private boolean first;
        private int numberOfElements;
        private List<ContentBean> content;
        private List<SortBean> sort;

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

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
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
             * id : 887984d215e441c6ac62adc005552949
             * optime : 2018-07-06T02:56:39.971+0000
             * isNewRecord : false
             * remarks :
             * createBy : c0bed7e69ea9457fa9b7285f466d1c3e
             * createDate :
             * updateBy :
             * updateDate :
             * delFlag : 0
             * createUser : {"id":"c0bed7e69ea9457fa9b7285f466d1c3e","optime":"2018-05-30T08:59:38.000+0000","cname":"刘彤","ename":"liutong","sort":0,"enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"7f859e95fb05498e83c0e8e04e4999e3","departmentName":"","code":"","sex":"1","mobile":"18149297777","email":"","address":"陕西省榆林市","note":""}
             * purchasePrice : 0
             * examName : 123
             * examSubscribe :
             * examType : 1280401
             * effTime : 2018-07-05 19:07
             * expTime : 2018-07-06 19:07
             * examPaperId : 9efa272eab8642179d46f2dbdf267b34
             * seriNo : 180705c0bed7e69ea9457fa9b7285f466d1c3e887984d215e441c6ac62adc005552949
             * totalPoint : 0
             * passPoint : 0
             * type : questions
             * state : 0
             * approved : 1
             * ksjxzt :
             * sjeffTime :
             * sjexpTime :
             * score : 123
             * examPaperName : 1111
             * total : 0
             * waitCome : 0
             * inCome : 0
             * outCome : 0
             * pointGet : 0
             * startTime : 0
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
            private CreateUserBean createUser;
            private int purchasePrice;
            private String examName;
            private String examSubscribe;
            private String examType;
            private String effTime;
            private String expTime;
            private String examPaperId;
            private String seriNo;
            private int totalPoint;
            private int passPoint;
            private String type;
            private String state;
            private String approved;
            private String ksjxzt;
            private String sjeffTime;
            private String sjexpTime;
            private int score;
            private String examPaperName;
            private int total;
            private int waitCome;
            private int inCome;
            private int outCome;
            private int pointGet;
            private String startTime;

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

            public CreateUserBean getCreateUser() {
                return createUser;
            }

            public void setCreateUser(CreateUserBean createUser) {
                this.createUser = createUser;
            }

            public int getPurchasePrice() {
                return purchasePrice;
            }

            public void setPurchasePrice(int purchasePrice) {
                this.purchasePrice = purchasePrice;
            }

            public String getExamName() {
                return examName;
            }

            public void setExamName(String examName) {
                this.examName = examName;
            }

            public String getExamSubscribe() {
                return examSubscribe;
            }

            public void setExamSubscribe(String examSubscribe) {
                this.examSubscribe = examSubscribe;
            }

            public String getExamType() {
                return examType;
            }

            public void setExamType(String examType) {
                this.examType = examType;
            }

            public String getEffTime() {
                return effTime;
            }

            public void setEffTime(String effTime) {
                this.effTime = effTime;
            }

            public String getExpTime() {
                return expTime;
            }

            public void setExpTime(String expTime) {
                this.expTime = expTime;
            }

            public String getExamPaperId() {
                return examPaperId;
            }

            public void setExamPaperId(String examPaperId) {
                this.examPaperId = examPaperId;
            }

            public String getSeriNo() {
                return seriNo;
            }

            public void setSeriNo(String seriNo) {
                this.seriNo = seriNo;
            }

            public int getTotalPoint() {
                return totalPoint;
            }

            public void setTotalPoint(int totalPoint) {
                this.totalPoint = totalPoint;
            }

            public int getPassPoint() {
                return passPoint;
            }

            public void setPassPoint(int passPoint) {
                this.passPoint = passPoint;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getApproved() {
                return approved;
            }

            public void setApproved(String approved) {
                this.approved = approved;
            }

            public String getKsjxzt() {
                return ksjxzt;
            }

            public void setKsjxzt(String ksjxzt) {
                this.ksjxzt = ksjxzt;
            }

            public String getSjeffTime() {
                return sjeffTime;
            }

            public void setSjeffTime(String sjeffTime) {
                this.sjeffTime = sjeffTime;
            }

            public String getSjexpTime() {
                return sjexpTime;
            }

            public void setSjexpTime(String sjexpTime) {
                this.sjexpTime = sjexpTime;
            }

            public int getScore() {
                return score;
            }

            public void setScore(int score) {
                this.score = score;
            }

            public String getExamPaperName() {
                return examPaperName;
            }

            public void setExamPaperName(String examPaperName) {
                this.examPaperName = examPaperName;
            }

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getWaitCome() {
                return waitCome;
            }

            public void setWaitCome(int waitCome) {
                this.waitCome = waitCome;
            }

            public int getInCome() {
                return inCome;
            }

            public void setInCome(int inCome) {
                this.inCome = inCome;
            }

            public int getOutCome() {
                return outCome;
            }

            public void setOutCome(int outCome) {
                this.outCome = outCome;
            }

            public int getPointGet() {
                return pointGet;
            }

            public void setPointGet(int pointGet) {
                this.pointGet = pointGet;
            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public static class CreateUserBean {
                /**
                 * id : c0bed7e69ea9457fa9b7285f466d1c3e
                 * optime : 2018-05-30T08:59:38.000+0000
                 * cname : 刘彤
                 * ename : liutong
                 * sort : 0
                 * enable : 1
                 * deleted : 0
                 * password : e10adc3949ba59abbe56e057f20f883e
                 * departmentId : 7f859e95fb05498e83c0e8e04e4999e3
                 * departmentName :
                 * code :
                 * sex : 1
                 * mobile : 18149297777
                 * email :
                 * address : 陕西省榆林市
                 * note :
                 */

                private String id;
                private String optime;
                private String cname;
                private String ename;
                private int sort;
                private String enable;
                private String deleted;
                private String password;
                private String departmentId;
                private String departmentName;
                private String code;
                private String sex;
                private String mobile;
                private String email;
                private String address;
                private String note;

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

                public String getCname() {
                    return cname;
                }

                public void setCname(String cname) {
                    this.cname = cname;
                }

                public String getEname() {
                    return ename;
                }

                public void setEname(String ename) {
                    this.ename = ename;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getEnable() {
                    return enable;
                }

                public void setEnable(String enable) {
                    this.enable = enable;
                }

                public String getDeleted() {
                    return deleted;
                }

                public void setDeleted(String deleted) {
                    this.deleted = deleted;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public String getDepartmentId() {
                    return departmentId;
                }

                public void setDepartmentId(String departmentId) {
                    this.departmentId = departmentId;
                }

                public String getDepartmentName() {
                    return departmentName;
                }

                public void setDepartmentName(String departmentName) {
                    this.departmentName = departmentName;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getSex() {
                    return sex;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public String getMobile() {
                    return mobile;
                }

                public void setMobile(String mobile) {
                    this.mobile = mobile;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getNote() {
                    return note;
                }

                public void setNote(String note) {
                    this.note = note;
                }
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
