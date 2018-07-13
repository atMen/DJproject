package customer.tcrj.com.djproject.bean;

import java.io.Serializable;

/**
 * Created by leict on 2018/4/20.
 */

public class Entity implements Serializable{
    /**
     * message : 执行成功!
     * data : {"data":{"id":"c0bed7e69ea9457fa9b7285f466d1c3e","unit":"组织机构","dept":"中国共产党榆林市委员会","username":"刘彤","duty":"党委书记","type":"关爱型","starNum":"3","score":"","cityRank":"","deptRank":"","photo":"/web.files/uploadfile/ryEbiy/2018-05-30/20180530045936179.jpg","myPromise":"全心全意为人民服务！"}}
     * errorCode : 0
     */

    private String message;
    private DataBeanX data;
    private String errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public static class DataBeanX implements Serializable{
        /**
         * data : {"id":"c0bed7e69ea9457fa9b7285f466d1c3e","unit":"组织机构","dept":"中国共产党榆林市委员会","username":"刘彤","duty":"党委书记","type":"关爱型","starNum":"3","score":"","cityRank":"","deptRank":"","photo":"/web.files/uploadfile/ryEbiy/2018-05-30/20180530045936179.jpg","myPromise":"全心全意为人民服务！"}
         */

        private DataBean data;

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public static class DataBean implements Serializable{
            /**
             * id : c0bed7e69ea9457fa9b7285f466d1c3e
             * unit : 组织机构
             * dept : 中国共产党榆林市委员会
             * username : 刘彤
             * duty : 党委书记
             * type : 关爱型
             * starNum : 3
             * score :
             * cityRank :
             * deptRank :
             * photo : /web.files/uploadfile/ryEbiy/2018-05-30/20180530045936179.jpg
             * myPromise : 全心全意为人民服务！
             */

            private String id;
            private String unit;
            private String dept;
            private String username;
            private String duty;
            private String type;
            private String starNum;
            private String score;
            private String cityRank;
            private String deptRank;
            private String photo;
            private String myPromise;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public String getDept() {
                return dept;
            }

            public void setDept(String dept) {
                this.dept = dept;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getDuty() {
                return duty;
            }

            public void setDuty(String duty) {
                this.duty = duty;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getStarNum() {
                return starNum;
            }

            public void setStarNum(String starNum) {
                this.starNum = starNum;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getCityRank() {
                return cityRank;
            }

            public void setCityRank(String cityRank) {
                this.cityRank = cityRank;
            }

            public String getDeptRank() {
                return deptRank;
            }

            public void setDeptRank(String deptRank) {
                this.deptRank = deptRank;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getMyPromise() {
                return myPromise;
            }

            public void setMyPromise(String myPromise) {
                this.myPromise = myPromise;
            }
        }
    }


//    /**
//     * data : {"id":"f7a268394e2e48a29d593ca1a934cebe","dept":"组织机构","username":"小九","duty":"","type":"关爱型","starNum":"3","score":"","cityRank":"","deptRank":"","photo":"","myPromise":""}
//     * message : 执行成功!
//     * errorCode : 0
//     */
//
//    private DataBean data;
//    private String message;
//    private String errorCode;
//
//    public DataBean getData() {
//        return data;
//    }
//
//    public void setData(DataBean data) {
//        this.data = data;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    public String getErrorCode() {
//        return errorCode;
//    }
//
//    public void setErrorCode(String errorCode) {
//        this.errorCode = errorCode;
//    }
//
//    public static class DataBean implements Serializable{
//        /**
//         * id : f7a268394e2e48a29d593ca1a934cebe
//         * dept : 组织机构
//         * username : 小九
//         * duty :
//         * type : 关爱型
//         * starNum : 3
//         * score :
//         * cityRank :
//         * deptRank :
//         * photo :
//         * myPromise :
//         */
//
//        private String id;
//        private String dept;
//        private String username;
//        private String duty;
//        private String type;
//        private String starNum;
//        private String score;
//        private String cityRank;
//        private String deptRank;
//        private String photo;
//        private String myPromise;
//
//        public String getId() {
//            return id;
//        }
//
//        public void setId(String id) {
//            this.id = id;
//        }
//
//        public String getDept() {
//            return dept;
//        }
//
//        public void setDept(String dept) {
//            this.dept = dept;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getDuty() {
//            return duty;
//        }
//
//        public void setDuty(String duty) {
//            this.duty = duty;
//        }
//
//        public String getType() {
//            return type;
//        }
//
//        public void setType(String type) {
//            this.type = type;
//        }
//
//        public String getStarNum() {
//            return starNum;
//        }
//
//        public void setStarNum(String starNum) {
//            this.starNum = starNum;
//        }
//
//        public String getScore() {
//            return score;
//        }
//
//        public void setScore(String score) {
//            this.score = score;
//        }
//
//        public String getCityRank() {
//            return cityRank;
//        }
//
//        public void setCityRank(String cityRank) {
//            this.cityRank = cityRank;
//        }
//
//        public String getDeptRank() {
//            return deptRank;
//        }
//
//        public void setDeptRank(String deptRank) {
//            this.deptRank = deptRank;
//        }
//
//        public String getPhoto() {
//            return photo;
//        }
//
//        public void setPhoto(String photo) {
//            this.photo = photo;
//        }
//
//        public String getMyPromise() {
//            return myPromise;
//        }
//
//        public void setMyPromise(String myPromise) {
//            this.myPromise = myPromise;
//        }
//    }
}
