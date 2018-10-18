package customer.tcrj.com.djproject.net;

/**
 * desc:
 * author: Will .
 * date: 2017/9/2 .
 */
public class ApiConstants {

    //TODO:记得修改党务管理url地址
    /**
     * 外网 http://123.139.46.180:1122
     * 192.168.20.176:8888
     * 党务管理 http://192.168.20.217:8080/yldj-cms/wechat/app/dwgl/dwglindex.chtml?memberId=adcf025079f1499788a62cda8cb67def
     * 外网 http://www.yldjw.gov.cn
     */
    public static final String TXImageURLROOT = "http://www.yldjw.gov.cn";
    private static final String URLROOT = TXImageURLROOT+"/app/";
    public static final String ImageURLROOT = TXImageURLROOT+"/web.files";
    public static final String FileURLROOT = TXImageURLROOT+"/web.files";

    /**
     * 登录
     */
    public static final String loginApi = URLROOT+"person/login";
    /**
     * 注册
     */
    public static final String registerApi = URLROOT+"person/register";

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
     * 修改我的承若
     */
    public static final String setPromiseApi = URLROOT+"person/addWdcl";

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
     * 图片上传
     */
    public static final String sendpicApi = URLROOT+"file/uploadBase64Image";



    /**
     * 获取出勤人员数据
     */
    public static final String cqrylistApi = "http://192.168.20.176:8888/yldj-cms/app/appPartyWork/getMemberList";


    /**
     * http://192.168.20.176:8888/yldj-cms/app/appPartyWork/addActivity
     */
    public static final String ZhuZhiShengHuoGuanLiAddApi = "http://192.168.20.176:8888/yldj-cms/app/appPartyWork/addActivity";


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


//    http://192.168.20.217:8080/yldj-cms/wechat/App/dwgl/dwglAppindex.chtml
    public static final String h5dwgl = TXImageURLROOT+"/wechat/APP/dwgl/dwglindex.chtml?deviceType=android&memberId=";

    public static final String h5xxks = TXImageURLROOT+"/wechat/APP/dwgl/mzshh/democracyForm.chtml?memberId=";


}
