package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/5/7.
 */

public class examlistInfo {


    /**
     * message : 执行成功!
     * data : {"content":[{"id":"e630edf5a90e4be6a1fd88ef624e5bf9","optime":"2018-05-15T07:07:50.352+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"","updateBy":"","updateDate":"","delFlag":"0","createUser":{"id":"1","optime":"2018-05-11T07:38:16.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"examName":"2018.05.15考试五","examSubscribe":"","examType":"1280401","effTime":"2018-05-15 11:38","expTime":"2018-07-15 11:38","examPaperId":"bf799653929245e69f90c16428fc5508","seriNo":"180515f8545595c30a4bd294c1afef784f5a35e630edf5a90e4be6a1fd88ef624e5bf9","totalPoint":0,"passPoint":0,"type":"questions","state":"0","approved":"2","ksjxzt":"","sjeffTime":"","sjexpTime":"","score":10,"examPaperName":"","total":0,"waitCome":0,"inCome":0,"outCome":0,"pointGet":0,"hasExam":false},{"id":"ff96823f48c947d7bc152f8530bd0012","optime":"2018-05-15T07:07:50.352+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"","updateBy":"","updateDate":"","delFlag":"0","createUser":{"id":"1","optime":"2018-05-11T07:38:16.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"examName":"2018.05.09考试二","examSubscribe":"","examType":"1280401","effTime":"2018-05-15 11:38","expTime":"2021-05-15 11:38","examPaperId":"bf799653929245e69f90c16428fc5508","seriNo":"180515f8545595c30a4bd294c1afef784f5a35ff96823f48c947d7bc152f8530bd0012","totalPoint":0,"passPoint":0,"type":"questions","state":"0","approved":"1","ksjxzt":"","sjeffTime":"","sjexpTime":"","score":10,"examPaperName":"","total":0,"waitCome":0,"inCome":0,"outCome":0,"pointGet":0,"hasExam":true}],"last":true,"totalElements":2,"totalPages":1,"size":10,"number":0,"sort":[{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":2}
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
         * content : [{"id":"e630edf5a90e4be6a1fd88ef624e5bf9","optime":"2018-05-15T07:07:50.352+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"","updateBy":"","updateDate":"","delFlag":"0","createUser":{"id":"1","optime":"2018-05-11T07:38:16.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"examName":"2018.05.15考试五","examSubscribe":"","examType":"1280401","effTime":"2018-05-15 11:38","expTime":"2018-07-15 11:38","examPaperId":"bf799653929245e69f90c16428fc5508","seriNo":"180515f8545595c30a4bd294c1afef784f5a35e630edf5a90e4be6a1fd88ef624e5bf9","totalPoint":0,"passPoint":0,"type":"questions","state":"0","approved":"2","ksjxzt":"","sjeffTime":"","sjexpTime":"","score":10,"examPaperName":"","total":0,"waitCome":0,"inCome":0,"outCome":0,"pointGet":0,"hasExam":false},{"id":"ff96823f48c947d7bc152f8530bd0012","optime":"2018-05-15T07:07:50.352+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"","updateBy":"","updateDate":"","delFlag":"0","createUser":{"id":"1","optime":"2018-05-11T07:38:16.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"examName":"2018.05.09考试二","examSubscribe":"","examType":"1280401","effTime":"2018-05-15 11:38","expTime":"2021-05-15 11:38","examPaperId":"bf799653929245e69f90c16428fc5508","seriNo":"180515f8545595c30a4bd294c1afef784f5a35ff96823f48c947d7bc152f8530bd0012","totalPoint":0,"passPoint":0,"type":"questions","state":"0","approved":"1","ksjxzt":"","sjeffTime":"","sjexpTime":"","score":10,"examPaperName":"","total":0,"waitCome":0,"inCome":0,"outCome":0,"pointGet":0,"hasExam":true}]
         * last : true
         * totalElements : 2
         * totalPages : 1
         * size : 10
         * number : 0
         * sort : [{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
         * first : true
         * numberOfElements : 2
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
            public String getExamState() {
                return examState;
            }

            public void setExamState(String examState) {
                this.examState = examState;
            }

            /**
             * id : e630edf5a90e4be6a1fd88ef624e5bf9
             * optime : 2018-05-15T07:07:50.352+0000
             * isNewRecord : false
             * remarks :
             * createBy : 1
             * createDate :
             * updateBy :
             * updateDate :
             * delFlag : 0
             * createUser : {"id":"1","optime":"2018-05-11T07:38:16.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""}
             * purchasePrice : 0
             * examName : 2018.05.15考试五
             * examSubscribe :
             * examType : 1280401
             * effTime : 2018-05-15 11:38
             * expTime : 2018-07-15 11:38
             * examPaperId : bf799653929245e69f90c16428fc5508
             * seriNo : 180515f8545595c30a4bd294c1afef784f5a35e630edf5a90e4be6a1fd88ef624e5bf9
             * totalPoint : 0
             * passPoint : 0
             * type : questions
             * state : 0
             * approved : 2
             * ksjxzt :
             * sjeffTime :
             * sjexpTime :
             * score : 10
             * examPaperName :
             * total : 0
             * waitCome : 0
             * inCome : 0
             * outCome : 0
             * pointGet : 0
             * hasExam : false
             */

            private String examState;
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
            private boolean hasExam;

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

            public boolean isHasExam() {
                return hasExam;
            }

            public void setHasExam(boolean hasExam) {
                this.hasExam = hasExam;
            }

            public static class CreateUserBean {
                /**
                 * id : 1
                 * optime : 2018-05-11T07:38:16.000+0000
                 * cname : 管理员
                 * ename : system
                 * sort : 0
                 * enable : 1
                 * deleted : 0
                 * password : 57ea494a86b47641f3721346ed16ad53
                 * departmentId :
                 * departmentName :
                 * code :
                 * sex :
                 * mobile :
                 * email :
                 * address :
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
