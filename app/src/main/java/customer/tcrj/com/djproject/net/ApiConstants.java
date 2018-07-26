package customer.tcrj.com.djproject.net;

/**
 * desc:
 * author: Will .
 * date: 2017/9/2 .
 */
public class ApiConstants {


    /**
     * 外网 http://111.21.32.158:8000
     */
    public static final String TXImageURLROOT = "http://111.21.32.158:1122";
    private static final String URLROOT = TXImageURLROOT+"/app/";
    public static final String ImageURLROOT = TXImageURLROOT+"/web.files";
    public static final String FileURLROOT = TXImageURLROOT+"/web.files";

//    /**
//     * 内网
//     */
//    public static final String TXImageURLROOT = "http://192.168.10.26:9134";
//    private static final String URLROOT = TXImageURLROOT+"/app/";
//    public static final String ImageURLROOT = TXImageURLROOT+"/web.files";
//    public static final String FileURLROOT = TXImageURLROOT+"/web.files";

    /**
     * 登录
     */
    public static final String loginApi = URLROOT+"person/login";
    /**
     * 注册
     */
    public static final String registerApi = URLROOT+"person/register";

//    /**
//     * 个人信息
//     */
//    public static final String userinfoApi = URLROOT+"person/getPersonalCenter.chtml";

    /**
     * dwgl/getHomePagePic
     * 轮播图片
     */
    public static final String picApi = URLROOT+"dwgl/getHomePagePic";

    /**
     * 获取本部党员信息
     */
    public static final String dyinfoApi = URLROOT+"person/getMyDeptPersonsInfo";

    /**
     * 获取互动交流-心愿墙
     */
    public static final String xyqinfoApi = URLROOT+"person/wishWall";

    /**
     * 获取课程列表
     */
    public static final String kclistApi = URLROOT+"learn/getCourseList";


    /**
     * learn/setStudyState
     * 上传学习进度
     */
    public static final String StudyStateApi = URLROOT+"learn/setStudyState";

    /**
     * 信息发布
     */
    public static final String msgsendApi = URLROOT+"dwgl/addHomePagePic";


    /**
     * person/addWishWall 写心愿
     */
    public static final String xyinfosendApi = URLROOT+"person/addWishWall";


    /**
     * 获取课程课件
     */
    public static final String kjlistApi = URLROOT+"learn/getCourseware";

//    /**
//     * 获取课程课件数
//     */
    public static final String kjnumlistApi = URLROOT+"learn/countCourseware";

//    /**
//     * 获取课程课件数
//     */
//    public static final String kjnumlistApi = "http://192.168.20.201:8080/yldj-cms/app/learn/countCourseware";

    /**
     * 课程课件点赞
     */
    public static final String kcdzApi = URLROOT+"learn/likeCourse";

    /**
     * 课程评论列表
     */
    public static final String kcpllistApi = URLROOT+"learn/getCourseComment";
    /**
     * 课程评论
     */
    public static final String kcplApi = URLROOT+"learn/commentCourse";
    /**
     * 我的消息
     */
    public static final String msgApi = URLROOT+"person/getMyMsgList";
    /**
     * 修改密码
     */
    public static final String mdifypswApi = URLROOT+"person/updatePassword";

    //党务管理
    /**
     * 党员信息列表 app/dwgl/getInfoList
     */
//    public static final String dylistApi = URLROOT+"dwgl/getInfoList";

    /**
     * dwgl/getPartyMeetList
     */

    public static final String dhlistApi = URLROOT+"dwgl/getPartyMeetList";

    /**
     * dwgl/getPartyMemberList 党员信息
     */
    public static final String dylistApi = URLROOT+"dwgl/getPartyMemberList";

    /**
     * 党课管理
     */
    public static final String dklistApi = URLROOT+"dwgl/getTeacherList";

//    /**
//     * 题库列表
//     */
//    public static final String examlistApi = URLROOT+"learn/getExamList";

    /**
     * 题库列表（未考）
     */
    public static final String examwklistApi = URLROOT+"learn/getStartExamList";

    /**
     * 题库列表（以考）
     */
    public static final String examyklistApi = URLROOT+"learn/getFinshExamList";


    /**
     * 网上调查列表
     */
    public static final String wsdclistApi = URLROOT+"learn/surveyOnLineList";

    /**
     * 网上调查列表
     */
    public static final String h5hdjlApi = URLROOT+"hdjl.chtml";
    public static final String h5examApi = URLROOT+"exam.chtml";
    public static final String h5yyj = TXImageURLROOT+"/wechat/examstack/exam/myExam.chtml";

}
