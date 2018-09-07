package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/4/27.
 */

public class plInfo {

    /**
     * data : {"content":[{"id":"5c7ac09a6328ccc4016329dcf3dc0017","optime":"2018-05-04T06:35:36.000+0000","isNewRecord":false,"remarks":"","createBy":"5e75222372e049a4848a79505f9158e7","createDate":"2018-05-04 14:35:36","updateBy":"5e75222372e049a4848a79505f9158e7","updateDate":"2018-05-04 14:35:36","delFlag":"0","createUser":{"id":"5e75222372e049a4848a79505f9158e7","optime":"2018-05-09T02:47:02.000+0000","cname":"梁冰","ename":"xiaojiu","sort":0,"enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"7f859e95fb05498e83c0e8e04e4999e3","departmentName":"","code":"","sex":"2","mobile":"18821796400","email":"152041555586@163.com","address":"陕西渭南","note":""},"updateUser":{"id":"5e75222372e049a4848a79505f9158e7","optime":"2018-05-09T02:47:02.000+0000","cname":"梁冰","ename":"xiaojiu","sort":0,"enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"7f859e95fb05498e83c0e8e04e4999e3","departmentName":"","code":"","sex":"2","mobile":"18821796400","email":"152041555586@163.com","address":"陕西渭南","note":""},"purchasePrice":0,"content":"图片清晰，内容新颖","courseId":"80f01b907cfd4cd0a4abb527f54021cf","coursewareId":"6657c87ce2ed4c61a73d6f24180c674c","reply":"认同便好","state":"1","courseName":"","coursewareName":"","createName":"","createdataDate":"","photo":""}],"last":true,"totalElements":1,"totalPages":1,"sort":[{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":1,"size":10,"number":0}
     * message : 执行成功!
     * errorCode : 0
     */

    private DataBean data;
    private String message;
    private String errorCode;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
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

    public static class DataBean {
        /**
         * content : [{"id":"5c7ac09a6328ccc4016329dcf3dc0017","optime":"2018-05-04T06:35:36.000+0000","isNewRecord":false,"remarks":"","createBy":"5e75222372e049a4848a79505f9158e7","createDate":"2018-05-04 14:35:36","updateBy":"5e75222372e049a4848a79505f9158e7","updateDate":"2018-05-04 14:35:36","delFlag":"0","createUser":{"id":"5e75222372e049a4848a79505f9158e7","optime":"2018-05-09T02:47:02.000+0000","cname":"梁冰","ename":"xiaojiu","sort":0,"enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"7f859e95fb05498e83c0e8e04e4999e3","departmentName":"","code":"","sex":"2","mobile":"18821796400","email":"152041555586@163.com","address":"陕西渭南","note":""},"updateUser":{"id":"5e75222372e049a4848a79505f9158e7","optime":"2018-05-09T02:47:02.000+0000","cname":"梁冰","ename":"xiaojiu","sort":0,"enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"7f859e95fb05498e83c0e8e04e4999e3","departmentName":"","code":"","sex":"2","mobile":"18821796400","email":"152041555586@163.com","address":"陕西渭南","note":""},"purchasePrice":0,"content":"图片清晰，内容新颖","courseId":"80f01b907cfd4cd0a4abb527f54021cf","coursewareId":"6657c87ce2ed4c61a73d6f24180c674c","reply":"认同便好","state":"1","courseName":"","coursewareName":"","createName":"","createdataDate":"","photo":""}]
         * last : true
         * totalElements : 1
         * totalPages : 1
         * sort : [{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
         * first : true
         * numberOfElements : 1
         * size : 10
         * number : 0
         */

        private boolean last;
        private int totalElements;
        private int totalPages;
        private boolean first;
        private int numberOfElements;
        private int size;
        private int number;
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
             * id : 5c7ac09a6328ccc4016329dcf3dc0017
             * optime : 2018-05-04T06:35:36.000+0000
             * isNewRecord : false
             * remarks :
             * createBy : 5e75222372e049a4848a79505f9158e7
             * createDate : 2018-05-04 14:35:36
             * updateBy : 5e75222372e049a4848a79505f9158e7
             * updateDate : 2018-05-04 14:35:36
             * delFlag : 0
             * createUser : {"id":"5e75222372e049a4848a79505f9158e7","optime":"2018-05-09T02:47:02.000+0000","cname":"梁冰","ename":"xiaojiu","sort":0,"enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"7f859e95fb05498e83c0e8e04e4999e3","departmentName":"","code":"","sex":"2","mobile":"18821796400","email":"152041555586@163.com","address":"陕西渭南","note":""}
             * updateUser : {"id":"5e75222372e049a4848a79505f9158e7","optime":"2018-05-09T02:47:02.000+0000","cname":"梁冰","ename":"xiaojiu","sort":0,"enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"7f859e95fb05498e83c0e8e04e4999e3","departmentName":"","code":"","sex":"2","mobile":"18821796400","email":"152041555586@163.com","address":"陕西渭南","note":""}
             * purchasePrice : 0
             * content : 图片清晰，内容新颖
             * courseId : 80f01b907cfd4cd0a4abb527f54021cf
             * coursewareId : 6657c87ce2ed4c61a73d6f24180c674c
             * reply : 认同便好
             * state : 1
             * courseName :
             * coursewareName :
             * createName :
             * createdataDate :
             * photo :
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
            private String content;
            private String courseId;
            private String coursewareId;
            private String reply;
            private String state;
            private String courseName;
            private String coursewareName;
            private String createName;
            private String createdataDate;
            private String photo;

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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCourseId() {
                return courseId;
            }

            public void setCourseId(String courseId) {
                this.courseId = courseId;
            }

            public String getCoursewareId() {
                return coursewareId;
            }

            public void setCoursewareId(String coursewareId) {
                this.coursewareId = coursewareId;
            }

            public String getReply() {
                return reply;
            }

            public void setReply(String reply) {
                this.reply = reply;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getCourseName() {
                return courseName;
            }

            public void setCourseName(String courseName) {
                this.courseName = courseName;
            }

            public String getCoursewareName() {
                return coursewareName;
            }

            public void setCoursewareName(String coursewareName) {
                this.coursewareName = coursewareName;
            }

            public String getCreateName() {
                return createName;
            }

            public void setCreateName(String createName) {
                this.createName = createName;
            }

            public String getCreatedataDate() {
                return createdataDate;
            }

            public void setCreatedataDate(String createdataDate) {
                this.createdataDate = createdataDate;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public static class CreateUserBean {
                public String getXm() {
                    return xm;
                }

                public void setXm(String xm) {
                    this.xm = xm;
                }

                /**
                 * id : 5e75222372e049a4848a79505f9158e7
                 * optime : 2018-05-09T02:47:02.000+0000
                 * cname : 梁冰
                 * ename : xiaojiu
                 * sort : 0
                 * enable : 1
                 * deleted : 0
                 * password : e10adc3949ba59abbe56e057f20f883e
                 * departmentId : 7f859e95fb05498e83c0e8e04e4999e3
                 * departmentName :
                 * code :
                 * sex : 2
                 * mobile : 18821796400
                 * email : 152041555586@163.com
                 * address : 陕西渭南
                 * note :
                 */
                private String xm;
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
                 * id : 5e75222372e049a4848a79505f9158e7
                 * optime : 2018-05-09T02:47:02.000+0000
                 * cname : 梁冰
                 * ename : xiaojiu
                 * sort : 0
                 * enable : 1
                 * deleted : 0
                 * password : e10adc3949ba59abbe56e057f20f883e
                 * departmentId : 7f859e95fb05498e83c0e8e04e4999e3
                 * departmentName :
                 * code :
                 * sex : 2
                 * mobile : 18821796400
                 * email : 152041555586@163.com
                 * address : 陕西渭南
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
