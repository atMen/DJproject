package customer.tcrj.com.djproject.bean;

/**
 * Created by leict on 2018/4/20.
 */

public class userInfo {

    /**
     * message : 执行成功!
     * data : {"myTask":0,"myMsg":0,"personInfo":{"unit":"XXX机关","dept":"第1支部","username":"张三","duty":"支部书记","type":"骨干型","starNum":5,"score":0,"cityRank":0,"deptRank":0,"photo":"/web.file/upload/2018/04/17/13241564.jpg"}}
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
         * myTask : 0
         * myMsg : 0
         * personInfo : {"unit":"XXX机关","dept":"第1支部","username":"张三","duty":"支部书记","type":"骨干型","starNum":5,"score":0,"cityRank":0,"deptRank":0,"photo":"/web.file/upload/2018/04/17/13241564.jpg"}
         */

        private int myTask;
        private int myMsg;
        private PersonInfoBean personInfo;

        public int getMyTask() {
            return myTask;
        }

        public void setMyTask(int myTask) {
            this.myTask = myTask;
        }

        public int getMyMsg() {
            return myMsg;
        }

        public void setMyMsg(int myMsg) {
            this.myMsg = myMsg;
        }

        public PersonInfoBean getPersonInfo() {
            return personInfo;
        }

        public void setPersonInfo(PersonInfoBean personInfo) {
            this.personInfo = personInfo;
        }

        public static class PersonInfoBean {
            /**
             * unit : XXX机关
             * dept : 第1支部
             * username : 张三
             * duty : 支部书记
             * type : 骨干型
             * starNum : 5
             * score : 0.0
             * cityRank : 0
             * deptRank : 0
             * photo : /web.file/upload/2018/04/17/13241564.jpg
             */

            private String unit;
            private String dept;
            private String username;
            private String duty;
            private String type;
            private int starNum;
            private double score;
            private int cityRank;
            private int deptRank;
            private String photo;

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

            public int getStarNum() {
                return starNum;
            }

            public void setStarNum(int starNum) {
                this.starNum = starNum;
            }

            public double getScore() {
                return score;
            }

            public void setScore(double score) {
                this.score = score;
            }

            public int getCityRank() {
                return cityRank;
            }

            public void setCityRank(int cityRank) {
                this.cityRank = cityRank;
            }

            public int getDeptRank() {
                return deptRank;
            }

            public void setDeptRank(int deptRank) {
                this.deptRank = deptRank;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }
        }
    }
}
