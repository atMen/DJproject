package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/5/3.
 */

public class hdjlInfo {


    /**
     * message : 执行成功!
     * data : {"content":[{"id":"ce1e3b73b95149ab8b165e5c4db129c5","optime":"2018-07-13T06:10:30.000+0000","isNewRecord":false,"remarks":"","createBy":"","createDate":"","updateBy":"cae38184ad7a4813a9d770d391949b26","updateDate":"2018-07-13 14:13:53","delFlag":"0","updateUser":{"id":"cae38184ad7a4813a9d770d391949b26","optime":"2018-07-02T02:17:33.000+0000","cname":"测试2","ename":"ceshi2","enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"674c984b9fda4e67be5b7940d96d91f5","departmentName":"吴堡县工业园区管理委员会党委","parentId":"674c984b9fda4e67be5b7940d96d91f5","code":"","sex":"1","mobile":"15236895645","telphone":"","email":"","address":"陕西汉中","note":"","photo":"","identityCard":"610322197712120311","mz":"13601","isTw":"0","csrq":"","xl":"13701","rylb":"","jrdzzrq":"","zwzsdyrq":"","gzgw":"13801","cjgzrq":"","jtzz":"","hyzk":"0","dagldwmc":"","przyjszwmc":"党务科长","xshjclx":"","yxqk":"","dypxqk":"","isNmg":"0","isSldy":"0","sljtqk":"","sqlxsj":"","isLddy":"0","wclx":"","wdcl":"","openId":"","paidCast":"1","isParty":"0","application":"","applicationName":"","type":"0","joinstate":"14301","qspm":"","zbpm":"","gblx":"","xj":"","score":"","actualDue":"0"},"purchasePrice":0,"memberId":"","msgContent":"十九大相关资料文件","msgAddress":"14206","msgAudit":"2","msgAuditTime":"2018-07-13 14:12:26","msgIsPublish":"1","msgPublishTime":"2018-07-13 14:12:33","claimMemberId":"cae38184ad7a4813a9d770d391949b26","claimStatus":"1","claimTime":"2018-07-13 14:13:32","msgOverStatue":"1","msgOverTime":"2018-07-13 14:13:53","cname":"徐志伟","mobile":"136795688558","isMyself":""}],"last":false,"totalPages":4,"totalElements":4,"sort":[{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"numberOfElements":1,"first":true,"size":1,"number":0}
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
         * content : [{"id":"ce1e3b73b95149ab8b165e5c4db129c5","optime":"2018-07-13T06:10:30.000+0000","isNewRecord":false,"remarks":"","createBy":"","createDate":"","updateBy":"cae38184ad7a4813a9d770d391949b26","updateDate":"2018-07-13 14:13:53","delFlag":"0","updateUser":{"id":"cae38184ad7a4813a9d770d391949b26","optime":"2018-07-02T02:17:33.000+0000","cname":"测试2","ename":"ceshi2","enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"674c984b9fda4e67be5b7940d96d91f5","departmentName":"吴堡县工业园区管理委员会党委","parentId":"674c984b9fda4e67be5b7940d96d91f5","code":"","sex":"1","mobile":"15236895645","telphone":"","email":"","address":"陕西汉中","note":"","photo":"","identityCard":"610322197712120311","mz":"13601","isTw":"0","csrq":"","xl":"13701","rylb":"","jrdzzrq":"","zwzsdyrq":"","gzgw":"13801","cjgzrq":"","jtzz":"","hyzk":"0","dagldwmc":"","przyjszwmc":"党务科长","xshjclx":"","yxqk":"","dypxqk":"","isNmg":"0","isSldy":"0","sljtqk":"","sqlxsj":"","isLddy":"0","wclx":"","wdcl":"","openId":"","paidCast":"1","isParty":"0","application":"","applicationName":"","type":"0","joinstate":"14301","qspm":"","zbpm":"","gblx":"","xj":"","score":"","actualDue":"0"},"purchasePrice":0,"memberId":"","msgContent":"十九大相关资料文件","msgAddress":"14206","msgAudit":"2","msgAuditTime":"2018-07-13 14:12:26","msgIsPublish":"1","msgPublishTime":"2018-07-13 14:12:33","claimMemberId":"cae38184ad7a4813a9d770d391949b26","claimStatus":"1","claimTime":"2018-07-13 14:13:32","msgOverStatue":"1","msgOverTime":"2018-07-13 14:13:53","cname":"徐志伟","mobile":"136795688558","isMyself":""}]
         * last : false
         * totalPages : 4
         * totalElements : 4
         * sort : [{"direction":"DESC","property":"optime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
         * numberOfElements : 1
         * first : true
         * size : 1
         * number : 0
         */

        private boolean last;
        private int totalPages;
        private int totalElements;
        private int numberOfElements;
        private boolean first;
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

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
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
             * id : ce1e3b73b95149ab8b165e5c4db129c5
             * optime : 2018-07-13T06:10:30.000+0000
             * isNewRecord : false
             * remarks :
             * createBy :
             * createDate :
             * updateBy : cae38184ad7a4813a9d770d391949b26
             * updateDate : 2018-07-13 14:13:53
             * delFlag : 0
             * updateUser : {"id":"cae38184ad7a4813a9d770d391949b26","optime":"2018-07-02T02:17:33.000+0000","cname":"测试2","ename":"ceshi2","enable":"1","deleted":"0","password":"e10adc3949ba59abbe56e057f20f883e","departmentId":"674c984b9fda4e67be5b7940d96d91f5","departmentName":"吴堡县工业园区管理委员会党委","parentId":"674c984b9fda4e67be5b7940d96d91f5","code":"","sex":"1","mobile":"15236895645","telphone":"","email":"","address":"陕西汉中","note":"","photo":"","identityCard":"610322197712120311","mz":"13601","isTw":"0","csrq":"","xl":"13701","rylb":"","jrdzzrq":"","zwzsdyrq":"","gzgw":"13801","cjgzrq":"","jtzz":"","hyzk":"0","dagldwmc":"","przyjszwmc":"党务科长","xshjclx":"","yxqk":"","dypxqk":"","isNmg":"0","isSldy":"0","sljtqk":"","sqlxsj":"","isLddy":"0","wclx":"","wdcl":"","openId":"","paidCast":"1","isParty":"0","application":"","applicationName":"","type":"0","joinstate":"14301","qspm":"","zbpm":"","gblx":"","xj":"","score":"","actualDue":"0"}
             * purchasePrice : 0
             * memberId :
             * msgContent : 十九大相关资料文件
             * msgAddress : 14206
             * msgAudit : 2
             * msgAuditTime : 2018-07-13 14:12:26
             * msgIsPublish : 1
             * msgPublishTime : 2018-07-13 14:12:33
             * claimMemberId : cae38184ad7a4813a9d770d391949b26
             * claimStatus : 1
             * claimTime : 2018-07-13 14:13:32
             * msgOverStatue : 1
             * msgOverTime : 2018-07-13 14:13:53
             * cname : 徐志伟
             * mobile : 136795688558
             * isMyself :
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
            private UpdateUserBean updateUser;
            private int purchasePrice;
            private String memberId;
            private String msgContent;
            private String msgAddress;
            private String msgAudit;
            private String msgAuditTime;
            private String msgIsPublish;
            private String msgPublishTime;
            private String claimMemberId;
            private String claimStatus;
            private String claimTime;
            private String msgOverStatue;
            private String msgOverTime;
            private String cname;
            private String mobile;
            private String isMyself;

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

            public String getMemberId() {
                return memberId;
            }

            public void setMemberId(String memberId) {
                this.memberId = memberId;
            }

            public String getMsgContent() {
                return msgContent;
            }

            public void setMsgContent(String msgContent) {
                this.msgContent = msgContent;
            }

            public String getMsgAddress() {
                return msgAddress;
            }

            public void setMsgAddress(String msgAddress) {
                this.msgAddress = msgAddress;
            }

            public String getMsgAudit() {
                return msgAudit;
            }

            public void setMsgAudit(String msgAudit) {
                this.msgAudit = msgAudit;
            }

            public String getMsgAuditTime() {
                return msgAuditTime;
            }

            public void setMsgAuditTime(String msgAuditTime) {
                this.msgAuditTime = msgAuditTime;
            }

            public String getMsgIsPublish() {
                return msgIsPublish;
            }

            public void setMsgIsPublish(String msgIsPublish) {
                this.msgIsPublish = msgIsPublish;
            }

            public String getMsgPublishTime() {
                return msgPublishTime;
            }

            public void setMsgPublishTime(String msgPublishTime) {
                this.msgPublishTime = msgPublishTime;
            }

            public String getClaimMemberId() {
                return claimMemberId;
            }

            public void setClaimMemberId(String claimMemberId) {
                this.claimMemberId = claimMemberId;
            }

            public String getClaimStatus() {
                return claimStatus;
            }

            public void setClaimStatus(String claimStatus) {
                this.claimStatus = claimStatus;
            }

            public String getClaimTime() {
                return claimTime;
            }

            public void setClaimTime(String claimTime) {
                this.claimTime = claimTime;
            }

            public String getMsgOverStatue() {
                return msgOverStatue;
            }

            public void setMsgOverStatue(String msgOverStatue) {
                this.msgOverStatue = msgOverStatue;
            }

            public String getMsgOverTime() {
                return msgOverTime;
            }

            public void setMsgOverTime(String msgOverTime) {
                this.msgOverTime = msgOverTime;
            }

            public String getCname() {
                return cname;
            }

            public void setCname(String cname) {
                this.cname = cname;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getIsMyself() {
                return isMyself;
            }

            public void setIsMyself(String isMyself) {
                this.isMyself = isMyself;
            }

            public static class UpdateUserBean {
                /**
                 * id : cae38184ad7a4813a9d770d391949b26
                 * optime : 2018-07-02T02:17:33.000+0000
                 * cname : 测试2
                 * ename : ceshi2
                 * enable : 1
                 * deleted : 0
                 * password : e10adc3949ba59abbe56e057f20f883e
                 * departmentId : 674c984b9fda4e67be5b7940d96d91f5
                 * departmentName : 吴堡县工业园区管理委员会党委
                 * parentId : 674c984b9fda4e67be5b7940d96d91f5
                 * code :
                 * sex : 1
                 * mobile : 15236895645
                 * telphone :
                 * email :
                 * address : 陕西汉中
                 * note :
                 * photo :
                 * identityCard : 610322197712120311
                 * mz : 13601
                 * isTw : 0
                 * csrq :
                 * xl : 13701
                 * rylb :
                 * jrdzzrq :
                 * zwzsdyrq :
                 * gzgw : 13801
                 * cjgzrq :
                 * jtzz :
                 * hyzk : 0
                 * dagldwmc :
                 * przyjszwmc : 党务科长
                 * xshjclx :
                 * yxqk :
                 * dypxqk :
                 * isNmg : 0
                 * isSldy : 0
                 * sljtqk :
                 * sqlxsj :
                 * isLddy : 0
                 * wclx :
                 * wdcl :
                 * openId :
                 * paidCast : 1
                 * isParty : 0
                 * application :
                 * applicationName :
                 * type : 0
                 * joinstate : 14301
                 * qspm :
                 * zbpm :
                 * gblx :
                 * xj :
                 * score :
                 * actualDue : 0
                 */

                private String id;
                private String optime;
                private String cname;
                private String ename;
                private String enable;
                private String deleted;
                private String password;
                private String departmentId;
                private String departmentName;
                private String parentId;
                private String code;
                private String sex;
                private String mobile;
                private String telphone;
                private String email;
                private String address;
                private String note;
                private String photo;
                private String identityCard;
                private String mz;
                private String isTw;
                private String csrq;
                private String xl;
                private String rylb;
                private String jrdzzrq;
                private String zwzsdyrq;
                private String gzgw;
                private String cjgzrq;
                private String jtzz;
                private String hyzk;
                private String dagldwmc;
                private String przyjszwmc;
                private String xshjclx;
                private String yxqk;
                private String dypxqk;
                private String isNmg;
                private String isSldy;
                private String sljtqk;
                private String sqlxsj;
                private String isLddy;
                private String wclx;
                private String wdcl;
                private String openId;
                private String paidCast;
                private String isParty;
                private String application;
                private String applicationName;
                private String type;
                private String joinstate;
                private String qspm;
                private String zbpm;
                private String gblx;
                private String xj;
                private String score;
                private String actualDue;

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

                public String getParentId() {
                    return parentId;
                }

                public void setParentId(String parentId) {
                    this.parentId = parentId;
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

                public String getTelphone() {
                    return telphone;
                }

                public void setTelphone(String telphone) {
                    this.telphone = telphone;
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

                public String getMz() {
                    return mz;
                }

                public void setMz(String mz) {
                    this.mz = mz;
                }

                public String getIsTw() {
                    return isTw;
                }

                public void setIsTw(String isTw) {
                    this.isTw = isTw;
                }

                public String getCsrq() {
                    return csrq;
                }

                public void setCsrq(String csrq) {
                    this.csrq = csrq;
                }

                public String getXl() {
                    return xl;
                }

                public void setXl(String xl) {
                    this.xl = xl;
                }

                public String getRylb() {
                    return rylb;
                }

                public void setRylb(String rylb) {
                    this.rylb = rylb;
                }

                public String getJrdzzrq() {
                    return jrdzzrq;
                }

                public void setJrdzzrq(String jrdzzrq) {
                    this.jrdzzrq = jrdzzrq;
                }

                public String getZwzsdyrq() {
                    return zwzsdyrq;
                }

                public void setZwzsdyrq(String zwzsdyrq) {
                    this.zwzsdyrq = zwzsdyrq;
                }

                public String getGzgw() {
                    return gzgw;
                }

                public void setGzgw(String gzgw) {
                    this.gzgw = gzgw;
                }

                public String getCjgzrq() {
                    return cjgzrq;
                }

                public void setCjgzrq(String cjgzrq) {
                    this.cjgzrq = cjgzrq;
                }

                public String getJtzz() {
                    return jtzz;
                }

                public void setJtzz(String jtzz) {
                    this.jtzz = jtzz;
                }

                public String getHyzk() {
                    return hyzk;
                }

                public void setHyzk(String hyzk) {
                    this.hyzk = hyzk;
                }

                public String getDagldwmc() {
                    return dagldwmc;
                }

                public void setDagldwmc(String dagldwmc) {
                    this.dagldwmc = dagldwmc;
                }

                public String getPrzyjszwmc() {
                    return przyjszwmc;
                }

                public void setPrzyjszwmc(String przyjszwmc) {
                    this.przyjszwmc = przyjszwmc;
                }

                public String getXshjclx() {
                    return xshjclx;
                }

                public void setXshjclx(String xshjclx) {
                    this.xshjclx = xshjclx;
                }

                public String getYxqk() {
                    return yxqk;
                }

                public void setYxqk(String yxqk) {
                    this.yxqk = yxqk;
                }

                public String getDypxqk() {
                    return dypxqk;
                }

                public void setDypxqk(String dypxqk) {
                    this.dypxqk = dypxqk;
                }

                public String getIsNmg() {
                    return isNmg;
                }

                public void setIsNmg(String isNmg) {
                    this.isNmg = isNmg;
                }

                public String getIsSldy() {
                    return isSldy;
                }

                public void setIsSldy(String isSldy) {
                    this.isSldy = isSldy;
                }

                public String getSljtqk() {
                    return sljtqk;
                }

                public void setSljtqk(String sljtqk) {
                    this.sljtqk = sljtqk;
                }

                public String getSqlxsj() {
                    return sqlxsj;
                }

                public void setSqlxsj(String sqlxsj) {
                    this.sqlxsj = sqlxsj;
                }

                public String getIsLddy() {
                    return isLddy;
                }

                public void setIsLddy(String isLddy) {
                    this.isLddy = isLddy;
                }

                public String getWclx() {
                    return wclx;
                }

                public void setWclx(String wclx) {
                    this.wclx = wclx;
                }

                public String getWdcl() {
                    return wdcl;
                }

                public void setWdcl(String wdcl) {
                    this.wdcl = wdcl;
                }

                public String getOpenId() {
                    return openId;
                }

                public void setOpenId(String openId) {
                    this.openId = openId;
                }

                public String getPaidCast() {
                    return paidCast;
                }

                public void setPaidCast(String paidCast) {
                    this.paidCast = paidCast;
                }

                public String getIsParty() {
                    return isParty;
                }

                public void setIsParty(String isParty) {
                    this.isParty = isParty;
                }

                public String getApplication() {
                    return application;
                }

                public void setApplication(String application) {
                    this.application = application;
                }

                public String getApplicationName() {
                    return applicationName;
                }

                public void setApplicationName(String applicationName) {
                    this.applicationName = applicationName;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getJoinstate() {
                    return joinstate;
                }

                public void setJoinstate(String joinstate) {
                    this.joinstate = joinstate;
                }

                public String getQspm() {
                    return qspm;
                }

                public void setQspm(String qspm) {
                    this.qspm = qspm;
                }

                public String getZbpm() {
                    return zbpm;
                }

                public void setZbpm(String zbpm) {
                    this.zbpm = zbpm;
                }

                public String getGblx() {
                    return gblx;
                }

                public void setGblx(String gblx) {
                    this.gblx = gblx;
                }

                public String getXj() {
                    return xj;
                }

                public void setXj(String xj) {
                    this.xj = xj;
                }

                public String getScore() {
                    return score;
                }

                public void setScore(String score) {
                    this.score = score;
                }

                public String getActualDue() {
                    return actualDue;
                }

                public void setActualDue(String actualDue) {
                    this.actualDue = actualDue;
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
