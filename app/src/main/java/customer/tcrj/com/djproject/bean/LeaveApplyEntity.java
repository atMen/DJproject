package customer.tcrj.com.djproject.bean;

import java.util.List;

/**
 * Created by leict on 2017/11/14.
 */

public class LeaveApplyEntity {

    public boolean isselect() {
        return isselect;
    }

    public void setIsselect(boolean isselect) {
        this.isselect = isselect;
    }

    /**
     * State : 1
     * Msg : 调用成功
     * LeavType : ["事假","病假（需按规定提供资料）","调休","年休假","其他","工伤假","婚假","产假","护理假/陪产假"]
     * LeavDayCount :
     */
    private boolean isselect;
    private int State;
    private String Msg;
    private String LeavDayCount;
    private List<String> LeavType;
    private String typeName;
    private int type;
    private String qjqssj;
    private String qjjssj;
    private String qjsy;
    private String name;
    private String ygbh;
    private String qjlx;
    private String bumen;
    private double gjts;
    private int WorkID;

    public LeaveApplyEntity() {
    }

    public LeaveApplyEntity(int type, String qjqssj, String qjjssj, String qjlx, String ygbh) {
        this.type = type;
        this.qjqssj = qjqssj;
        this.qjjssj = qjjssj;
        this.qjlx = qjlx;
        this.ygbh = ygbh;
    }

    public LeaveApplyEntity(int type, String qjqssj, String qjjssj, String qjsy, String name, String ygbh, String qjlx, String bumen, double gjts, int workid) {
        this.type = type;
        this.qjqssj = qjqssj;
        this.qjjssj = qjjssj;
        this.qjsy = qjsy;
        this.name = name;
        this.ygbh = ygbh;
        this.qjlx = qjlx;
        this.bumen = bumen;
        this.gjts = gjts;
        this.WorkID = workid;
    }

    public LeaveApplyEntity(int type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public String getLeavDayCount() {
        return LeavDayCount;
    }

    public void setLeavDayCount(String LeavDayCount) {
        this.LeavDayCount = LeavDayCount;
    }

    public List<String> getLeavType() {
        return LeavType;
    }

    public void setLeavType(List<String> LeavType) {
        this.LeavType = LeavType;
    }
}
