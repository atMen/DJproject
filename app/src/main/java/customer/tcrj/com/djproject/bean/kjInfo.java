package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/4/26.
 */

public class kjInfo {


    /**
     * message : 执行成功!
     * data : {"content":[{"id":"497603e6eb0846baaa87b8d4dae73011","optime":"2018-05-04T06:48:45.000+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"2018-05-04 14:48:45","updateBy":"1","updateDate":"2018-05-04 14:48:45","delFlag":"0","createUser":{"id":"1","optime":"2018-05-04T06:22:35.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"updateUser":{"id":"1","optime":"2018-05-04T06:22:35.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"name":"什么是<<中国制造2025>>","type":"13301","closeCondition":"0","minDuration":"0","isElective":"0","chapterId":"d249f0c189e84cfa8f793c59502411cd","courseId":"abcd5b880af34cc58443145836e1c31a","file":"/uploadfile/ryEbiy/2018-05-04/20180504023543693.mp4","fileName":"20180504091424614.mp4","submitStatus":"1","auditStatus":"1","publishStatus":"1","nonInvigilation":"1","point":"10","likenum":1,"courseName":"","chapterName":"","subject":"","industry":"","userId":"","updateDateu":"","studyState":"81","playTime":"0"}],"last":true,"totalElements":1,"totalPages":1,"size":10,"number":0,"sort":[{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":1}
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
         * content : [{"id":"497603e6eb0846baaa87b8d4dae73011","optime":"2018-05-04T06:48:45.000+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"2018-05-04 14:48:45","updateBy":"1","updateDate":"2018-05-04 14:48:45","delFlag":"0","createUser":{"id":"1","optime":"2018-05-04T06:22:35.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"updateUser":{"id":"1","optime":"2018-05-04T06:22:35.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"name":"什么是<<中国制造2025>>","type":"13301","closeCondition":"0","minDuration":"0","isElective":"0","chapterId":"d249f0c189e84cfa8f793c59502411cd","courseId":"abcd5b880af34cc58443145836e1c31a","file":"/uploadfile/ryEbiy/2018-05-04/20180504023543693.mp4","fileName":"20180504091424614.mp4","submitStatus":"1","auditStatus":"1","publishStatus":"1","nonInvigilation":"1","point":"10","likenum":1,"courseName":"","chapterName":"","subject":"","industry":"","userId":"","updateDateu":"","studyState":"81","playTime":"0"}]
         * last : true
         * totalElements : 1
         * totalPages : 1
         * size : 10
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

//            public boolean isZanFocus() {
//                return zanFocus;
//            }
//
//            public void setZanFocus(boolean zanFocus) {
//                this.zanFocus = zanFocus;
//            }
//            private boolean zanFocus;



            public boolean isHasLike() {
                return hasLike;
            }

            public void setHasLike(boolean hasLike) {
                this.hasLike = hasLike;
            }

            private boolean hasLike;

            /**hasLike
             * id : 497603e6eb0846baaa87b8d4dae73011
             * optime : 2018-05-04T06:48:45.000+0000
             * isNewRecord : false
             * remarks :
             * createBy : 1
             * createDate : 2018-05-04 14:48:45
             * updateBy : 1
             * updateDate : 2018-05-04 14:48:45
             * delFlag : 0
             * createUser : {"id":"1","optime":"2018-05-04T06:22:35.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""}
             * updateUser : {"id":"1","optime":"2018-05-04T06:22:35.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""}
             * purchasePrice : 0
             * name : 什么是<<中国制造2025>>
             * type : 13301
             * closeCondition : 0
             * minDuration : 0
             * isElective : 0
             * chapterId : d249f0c189e84cfa8f793c59502411cd
             * courseId : abcd5b880af34cc58443145836e1c31a
             * file : /uploadfile/ryEbiy/2018-05-04/20180504023543693.mp4
             * fileName : 20180504091424614.mp4
             * submitStatus : 1
             * auditStatus : 1
             * publishStatus : 1
             * nonInvigilation : 1
             * point : 10
             * likenum : 1
             * courseName :
             * chapterName :
             * subject :
             * industry :
             * userId :
             * updateDateu :
             * studyState : 81
             * playTime : 0
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
            private UpdateUserBean updateUser;
            private int purchasePrice;
            private String name;
            private String type;
            private String closeCondition;
            private String minDuration;
            private String isElective;
            private String chapterId;
            private String courseId;
            private String file;
            private String fileName;
            private String submitStatus;
            private String auditStatus;
            private String publishStatus;
            private String nonInvigilation;
            private String point;
            private int likenum;
            private String courseName;
            private String chapterName;
            private String subject;
            private String industry;
            private String userId;
            private String updateDateu;
            private String studyState;
            private String playTime;

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

            public UpdateUserBean getUpdateUser() {
                return updateUser;
            }

            public void setUpdateUser(UpdateUserBean updateUser) {
                this.updateUser = updateUser;
            }

            public int getPurchasePrice() {
                return purchasePrice;
            }

            public void setPurchasePrice(int purchasePrice) {
                this.purchasePrice = purchasePrice;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getCloseCondition() {
                return closeCondition;
            }

            public void setCloseCondition(String closeCondition) {
                this.closeCondition = closeCondition;
            }

            public String getMinDuration() {
                return minDuration;
            }

            public void setMinDuration(String minDuration) {
                this.minDuration = minDuration;
            }

            public String getIsElective() {
                return isElective;
            }

            public void setIsElective(String isElective) {
                this.isElective = isElective;
            }

            public String getChapterId() {
                return chapterId;
            }

            public void setChapterId(String chapterId) {
                this.chapterId = chapterId;
            }

            public String getCourseId() {
                return courseId;
            }

            public void setCourseId(String courseId) {
                this.courseId = courseId;
            }

            public String getFile() {
                return file;
            }

            public void setFile(String file) {
                this.file = file;
            }

            public String getFileName() {
                return fileName;
            }

            public void setFileName(String fileName) {
                this.fileName = fileName;
            }

            public String getSubmitStatus() {
                return submitStatus;
            }

            public void setSubmitStatus(String submitStatus) {
                this.submitStatus = submitStatus;
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

            public String getNonInvigilation() {
                return nonInvigilation;
            }

            public void setNonInvigilation(String nonInvigilation) {
                this.nonInvigilation = nonInvigilation;
            }

            public String getPoint() {
                return point;
            }

            public void setPoint(String point) {
                this.point = point;
            }

            public int getLikenum() {
                return likenum;
            }

            public void setLikenum(int likenum) {
                this.likenum = likenum;
            }

            public String getCourseName() {
                return courseName;
            }

            public void setCourseName(String courseName) {
                this.courseName = courseName;
            }

            public String getChapterName() {
                return chapterName;
            }

            public void setChapterName(String chapterName) {
                this.chapterName = chapterName;
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

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getUpdateDateu() {
                return updateDateu;
            }

            public void setUpdateDateu(String updateDateu) {
                this.updateDateu = updateDateu;
            }

            public String getStudyState() {
                return studyState;
            }

            public void setStudyState(String studyState) {
                this.studyState = studyState;
            }

            public String getPlayTime() {
                return playTime;
            }

            public void setPlayTime(String playTime) {
                this.playTime = playTime;
            }

            public static class CreateUserBean {
                /**
                 * id : 1
                 * optime : 2018-05-04T06:22:35.000+0000
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

            public static class UpdateUserBean {
                /**
                 * id : 1
                 * optime : 2018-05-04T06:22:35.000+0000
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
