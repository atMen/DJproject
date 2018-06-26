package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2018/5/8.
 */

public class wjdcInfo {

    /**
     * message : 执行成功!
     * data : {"content":[{"id":"d4d0be9bfd9f457cbee3e917bb774e49","optime":"2018-05-07T09:04:59.000+0000","title":"<<中国制造2025>>网上问卷","publish":"1","contents":"<p>&lt;&lt;中国制造2025&gt;&gt;网上问卷<\/p>","showTime":"2018-05-07 17:04:59","times":"2018-05-07 17:04:37","timee":"2022-05-07 17:04:39","restrictMember":"0","repeateHour":0,"restrictIp":"0","iprange":"","ipout":"","restrictCookie":"0","multiSelect":0,"voteCount":0,"siteId":"ryEbiy","groupId":"a02cf0463f934ef9abe2367b023f6729","groupName":"测试","linkUrl":""}],"last":true,"totalElements":1,"totalPages":1,"size":10,"number":0,"sort":[{"direction":"DESC","property":"showTime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"first":true,"numberOfElements":1}
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
         * content : [{"id":"d4d0be9bfd9f457cbee3e917bb774e49","optime":"2018-05-07T09:04:59.000+0000","title":"<<中国制造2025>>网上问卷","publish":"1","contents":"<p>&lt;&lt;中国制造2025&gt;&gt;网上问卷<\/p>","showTime":"2018-05-07 17:04:59","times":"2018-05-07 17:04:37","timee":"2022-05-07 17:04:39","restrictMember":"0","repeateHour":0,"restrictIp":"0","iprange":"","ipout":"","restrictCookie":"0","multiSelect":0,"voteCount":0,"siteId":"ryEbiy","groupId":"a02cf0463f934ef9abe2367b023f6729","groupName":"测试","linkUrl":""}]
         * last : true
         * totalElements : 1
         * totalPages : 1
         * size : 10
         * number : 0
         * sort : [{"direction":"DESC","property":"showTime","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
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
             * id : d4d0be9bfd9f457cbee3e917bb774e49
             * optime : 2018-05-07T09:04:59.000+0000
             * title : <<中国制造2025>>网上问卷
             * publish : 1
             * contents : <p>&lt;&lt;中国制造2025&gt;&gt;网上问卷</p>
             * showTime : 2018-05-07 17:04:59
             * times : 2018-05-07 17:04:37
             * timee : 2022-05-07 17:04:39
             * restrictMember : 0
             * repeateHour : 0
             * restrictIp : 0
             * iprange :
             * ipout :
             * restrictCookie : 0
             * multiSelect : 0
             * voteCount : 0
             * siteId : ryEbiy
             * groupId : a02cf0463f934ef9abe2367b023f6729
             * groupName : 测试
             * linkUrl :
             */

            private String id;
            private String optime;
            private String title;
            private String publish;
            private String contents;
            private String showTime;
            private String times;
            private String timee;
            private String restrictMember;
            private int repeateHour;
            private String restrictIp;
            private String iprange;
            private String ipout;
            private String restrictCookie;
            private int multiSelect;
            private int voteCount;
            private String siteId;
            private String groupId;
            private String groupName;
            private String linkUrl;

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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPublish() {
                return publish;
            }

            public void setPublish(String publish) {
                this.publish = publish;
            }

            public String getContents() {
                return contents;
            }

            public void setContents(String contents) {
                this.contents = contents;
            }

            public String getShowTime() {
                return showTime;
            }

            public void setShowTime(String showTime) {
                this.showTime = showTime;
            }

            public String getTimes() {
                return times;
            }

            public void setTimes(String times) {
                this.times = times;
            }

            public String getTimee() {
                return timee;
            }

            public void setTimee(String timee) {
                this.timee = timee;
            }

            public String getRestrictMember() {
                return restrictMember;
            }

            public void setRestrictMember(String restrictMember) {
                this.restrictMember = restrictMember;
            }

            public int getRepeateHour() {
                return repeateHour;
            }

            public void setRepeateHour(int repeateHour) {
                this.repeateHour = repeateHour;
            }

            public String getRestrictIp() {
                return restrictIp;
            }

            public void setRestrictIp(String restrictIp) {
                this.restrictIp = restrictIp;
            }

            public String getIprange() {
                return iprange;
            }

            public void setIprange(String iprange) {
                this.iprange = iprange;
            }

            public String getIpout() {
                return ipout;
            }

            public void setIpout(String ipout) {
                this.ipout = ipout;
            }

            public String getRestrictCookie() {
                return restrictCookie;
            }

            public void setRestrictCookie(String restrictCookie) {
                this.restrictCookie = restrictCookie;
            }

            public int getMultiSelect() {
                return multiSelect;
            }

            public void setMultiSelect(int multiSelect) {
                this.multiSelect = multiSelect;
            }

            public int getVoteCount() {
                return voteCount;
            }

            public void setVoteCount(int voteCount) {
                this.voteCount = voteCount;
            }

            public String getSiteId() {
                return siteId;
            }

            public void setSiteId(String siteId) {
                this.siteId = siteId;
            }

            public String getGroupId() {
                return groupId;
            }

            public void setGroupId(String groupId) {
                this.groupId = groupId;
            }

            public String getGroupName() {
                return groupName;
            }

            public void setGroupName(String groupName) {
                this.groupName = groupName;
            }

            public String getLinkUrl() {
                return linkUrl;
            }

            public void setLinkUrl(String linkUrl) {
                this.linkUrl = linkUrl;
            }
        }

        public static class SortBean {
            /**
             * direction : DESC
             * property : showTime
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
