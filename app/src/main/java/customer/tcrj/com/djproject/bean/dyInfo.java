package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/4/25.
 */

public class dyInfo {


    /**
     * message : 执行成功!
     * data : {"content":[{"id":"61fce9845fc34b08bed1368068bf3971","optime":"2018-04-20T07:54:16.000+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"2018-04-20 15:54:16","updateBy":"1","updateDate":"2018-04-20 15:54:16","delFlag":"0","createUser":{"id":"1","optime":"2018-04-26T06:06:26.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"updateUser":{"id":"1","optime":"2018-04-26T06:06:26.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"cname":"王五","ename":"ww","enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"e156f87cccf34effa7cf5566b064580c","departmentName":"","code":"","sex":"1","mobile":"","email":"","address":"测试","note":"","photo":"","identityCard":""},{"id":"371d0aca48a7449195892007094c8520","optime":"2018-04-20T07:54:06.000+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"2018-04-20 15:54:06","updateBy":"1","updateDate":"2018-04-20 16:35:50","delFlag":"0","createUser":{"id":"1","optime":"2018-04-26T06:06:26.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"updateUser":{"id":"1","optime":"2018-04-26T06:06:26.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"cname":"李四","ename":"ls","enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"e156f87cccf34effa7cf5566b064580c","departmentName":"","code":"","sex":"1","mobile":"","email":"","address":"测试","note":"","photo":"/uploadfile/ryEbiy/2018-04-20/20180420043548476.jpg","identityCard":""}],"last":true,"totalElements":2,"totalPages":1,"size":3,"number":0,"sort":[{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":2}
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
         * content : [{"id":"61fce9845fc34b08bed1368068bf3971","optime":"2018-04-20T07:54:16.000+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"2018-04-20 15:54:16","updateBy":"1","updateDate":"2018-04-20 15:54:16","delFlag":"0","createUser":{"id":"1","optime":"2018-04-26T06:06:26.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"updateUser":{"id":"1","optime":"2018-04-26T06:06:26.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"cname":"王五","ename":"ww","enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"e156f87cccf34effa7cf5566b064580c","departmentName":"","code":"","sex":"1","mobile":"","email":"","address":"测试","note":"","photo":"","identityCard":""},{"id":"371d0aca48a7449195892007094c8520","optime":"2018-04-20T07:54:06.000+0000","isNewRecord":false,"remarks":"","createBy":"1","createDate":"2018-04-20 15:54:06","updateBy":"1","updateDate":"2018-04-20 16:35:50","delFlag":"0","createUser":{"id":"1","optime":"2018-04-26T06:06:26.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"updateUser":{"id":"1","optime":"2018-04-26T06:06:26.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""},"purchasePrice":0,"cname":"李四","ename":"ls","enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"e156f87cccf34effa7cf5566b064580c","departmentName":"","code":"","sex":"1","mobile":"","email":"","address":"测试","note":"","photo":"/uploadfile/ryEbiy/2018-04-20/20180420043548476.jpg","identityCard":""}]
         * last : true
         * totalElements : 2
         * totalPages : 1
         * size : 3
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
            /**
             * id : 61fce9845fc34b08bed1368068bf3971
             * optime : 2018-04-20T07:54:16.000+0000
             * isNewRecord : false
             * remarks :
             * createBy : 1
             * createDate : 2018-04-20 15:54:16
             * updateBy : 1
             * updateDate : 2018-04-20 15:54:16
             * delFlag : 0
             * createUser : {"id":"1","optime":"2018-04-26T06:06:26.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""}
             * updateUser : {"id":"1","optime":"2018-04-26T06:06:26.000+0000","cname":"管理员","ename":"system","sort":0,"enable":"1","deleted":"0","password":"57ea494a86b47641f3721346ed16ad53","departmentId":"","departmentName":"","code":"","sex":"","mobile":"","email":"","address":"","note":""}
             * purchasePrice : 0
             * cname : 王五
             * ename : ww
             * enable : 1
             * deleted : 0
             * password : e10adc3949ba59abbe56e057f20f883e
             * departmentId : e156f87cccf34effa7cf5566b064580c
             * departmentName :
             * code :
             * sex : 1
             * mobile :
             * email :
             * address : 测试
             * note :
             * photo :
             * identityCard :
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
            private String cname;
            private String ename;
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
            private String photo;
            private String identityCard;

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

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getIdentityCard() {
                return identityCard;
            }

            public void setIdentityCard(String identityCard) {
                this.identityCard = identityCard;
            }

            public static class CreateUserBean {
                /**
                 * id : 1
                 * optime : 2018-04-26T06:06:26.000+0000
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
                 * optime : 2018-04-26T06:06:26.000+0000
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
