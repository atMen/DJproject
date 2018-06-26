package customer.tcrj.com.djproject.bean;

import java.io.Serializable;

/**
 * Created by leict on 2018/4/20.
 */

public class Entity implements Serializable{


    /**
     * data : {"id":"f7a268394e2e48a29d593ca1a934cebe","dept":"组织机构","username":"小九","duty":"","type":"关爱型","starNum":"3","score":"","cityRank":"","deptRank":"","photo":"","myPromise":""}
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

    public static class DataBean implements Serializable{
        /**
         * id : f7a268394e2e48a29d593ca1a934cebe
         * dept : 组织机构
         * username : 小九
         * duty :
         * type : 关爱型
         * starNum : 3
         * score :
         * cityRank :
         * deptRank :
         * photo :
         * myPromise :
         */

        private String id;
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
