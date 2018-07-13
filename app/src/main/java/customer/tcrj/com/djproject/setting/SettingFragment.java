package customer.tcrj.com.djproject.setting;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.iarcuschin.simpleratingbar.SimpleRatingBar;

import butterknife.BindView;
import customer.tcrj.com.djproject.LoginActivity;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.Utils.AppManager;
import customer.tcrj.com.djproject.base.BaseFragment;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.checkUpdata.SweetAlertDialog;
import customer.tcrj.com.djproject.checkUpdata.UpdateManager;
import customer.tcrj.com.djproject.net.ApiConstants;


/**
 * Created by leict on 2018/3/22.
 */

public class SettingFragment extends BaseFragment implements View.OnClickListener {

    @BindView(R.id.modify_psw)
    public RelativeLayout modify_psw;
    @BindView(R.id.rl_about)
    public RelativeLayout rl_about;
    @BindView(R.id.rl_updata)
    public RelativeLayout rl_updata;
    @BindView(R.id.tv_cn)
    TextView cn;
    @BindView(R.id.tv_zbpm)
    TextView tv_zbpm;
    @BindView(R.id.tv_qspm)
    TextView tv_qspm;
    @BindView(R.id.tv_ndjf)
    TextView tv_ndjf;
    @BindView(R.id.tv_type)
    TextView tv_type;
    @BindView(R.id.tv_username)
    TextView tv_username;
    @BindView(R.id.tv_jgzb)
    TextView tv_jgzb;
    @BindView(R.id.tv_zw)
    TextView tv_zw;
    @BindView(R.id.iv_photo)
    ImageView iv_photo;
    @BindView(R.id.start)
    SimpleRatingBar start;
    private Entity loginInfo = null;


    @Override
    protected int setLayout() {
        return R.layout.setting_fragment;
    }

    @Override
    protected void setView() {
        modify_psw.setOnClickListener(this);
        rl_about.setOnClickListener(this);
        rl_updata.setOnClickListener(this);
    }

    @Override
    protected void setData() {
        loginInfo = (Entity) ACache.get(mContext).getAsObject("loginInfo");
        setUserInfo(loginInfo);
    }

//    private void setUserInfo(Entity response) {
//
//        if(response != null){
//
//            Entity.DataBean personInfo = response.getData();
//            Log.e("TAG","StarNum"+personInfo.getStarNum());
//            tv_zbpm.setText("支部排名：第"+personInfo.getDeptRank()+"名");
//            tv_qspm.setText("全市排名：第"+personInfo.getCityRank()+"名");
//            tv_ndjf.setText("年度积分："+personInfo.getScore()+"分");
//            tv_type.setText(personInfo.getType()+" |");
//            tv_username.setText(personInfo.getUsername());
//            tv_jgzb.setText(personInfo.getDept());
////          cn.setText(personInfo.get());//承若
//            tv_zw.setText(personInfo.getDuty());
//
//            String photo = personInfo.getPhoto();
//
//            if(photo != null ){
//
//                if(!photo.equals("")){
//                    Log.e("TAG","setting-photo"+photo);
//                    Glide.with(this).load(ApiConstants.TXImageURLROOT+photo).into(iv_photo);
//                }
//
//            }
//            int i = Integer.parseInt(personInfo.getStarNum());
//            if(i > 0){
//                start.setVisibility(View.VISIBLE);
//                start.setNumberOfStars(i);
//                start.setRating(i);
//
//            }else{
//                start.setVisibility(View.GONE);
//            }
//
//        }
//
//
//    }
private void setUserInfo(Entity response) {

    if(response != null){

//            llcn.setVisibility(View.VISIBLE);
        Entity.DataBeanX.DataBean personInfo = response.getData().getData();

        String photo = personInfo.getPhoto();
        Log.e("TAG","photo"+photo);
        if(photo != null){

            if(!photo.equals("")){
                Log.e("TAG","setting-photo"+photo);
                Glide.with(this).load(ApiConstants.TXImageURLROOT+photo).into(iv_photo);
            }
//                    Uri uri=Uri.parse(photo);
//                    iv_photo.setImageURI(uri);

        }


        String deptRank = personInfo.getDeptRank();
        if(deptRank != null && !deptRank.equals("")){
            tv_zbpm.setText("支部排名：第"+personInfo.getDeptRank()+"名");
        }else {
            tv_zbpm.setText("支部排名：无");
        }

        String cityRank = personInfo.getCityRank();
        if(cityRank != null && !cityRank.equals("")){
            tv_qspm.setText("全市排名：第"+personInfo.getCityRank()+"名");
        }else {
            tv_qspm.setText("全市排名：无");
        }
        String score = personInfo.getScore();
        if(score != null && !score.equals("")){
            tv_ndjf.setText("年度积分："+personInfo.getScore()+"分");
        }else {
            tv_ndjf.setText("年度积分：无");
        }


        tv_type.setText(personInfo.getType()+" |");
        tv_username.setText(personInfo.getUsername());
//            tv_jgzb.setText(personInfo.getUnit()+personInfo.getDept());
        tv_jgzb.setText(personInfo.getDept());
        cn.setText(personInfo.getMyPromise());//承若

        tv_zw.setText(personInfo.getDuty());

        String starNum = personInfo.getStarNum();
        if(starNum != null){
            int i = Integer.parseInt(starNum);
            if(i > 0){
                start.setVisibility(View.VISIBLE);
                start.setNumberOfStars(i);
                start.setRating(i);

            }else{
                start.setVisibility(View.GONE);
            }
        }


//            if(personInfo.getStarNum() > 0){
//                start.setVisibility(View.VISIBLE);
//                start.setNumberOfStars(personInfo.getStarNum());
//                start.setRating(personInfo.getStarNum());
//
//            }else{
//                start.setVisibility(View.GONE);
//            }

    }


}

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.modify_psw:
                toClass(mContext,MdifyPswActivity.class);
                break;
            case R.id.rl_about:
                showUpdateDialog();
                break;
            case R.id.rl_updata:
                CheckUpdate();
                break;
        }
    }
    /**
     * 检查最新版本
     *
     * @return
     */
    private void CheckUpdate() {
        UpdateManager um = new UpdateManager(getActivity());
        um.checkUpdate("", 0);
    }

    private void showUpdateDialog() {

/*		Intent intent = new Intent();
        intent.setClass(mContext, IsDownLoad.class);
		mContext.startActivity(intent);*/
        final SweetAlertDialog sad = new SweetAlertDialog(getActivity());
        sad.setTitleText("注销登录");
        sad.setContentText("您确定要进行注销操作吗？");
        sad.setConfirmText("确定");
        sad.setCancelText("取消");
        sad.setCanceledOnTouchOutside(true);
        sad.setCancelable(true);
        sad.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sad.dismiss();


            }
        });
        sad.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sureZX();
                sad.dismiss();

            }
        });
        sad.show();
    }

    private void sureZX() {
        AppManager.getAppManager().finishAllActivity();
        ACache.get(mContext).clear();
        goLogin();
    }

    private void goLogin() {
        Intent intent = new Intent(mContext, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
