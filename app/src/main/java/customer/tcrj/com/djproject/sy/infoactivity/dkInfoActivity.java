package customer.tcrj.com.djproject.sy.infoactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.dkInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;
import customer.tcrj.com.djproject.net.ApiConstants;

public class dkInfoActivity extends BaseActivity {

    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.zw)
    TextView zw;
    @BindView(R.id.sex)
    TextView sex;
    @BindView(R.id.time)
    TextView time;
    @BindView(R.id.ssdx)
    TextView ssdx;
    @BindView(R.id.zc)
    TextView zc;
    @BindView(R.id.qm)
    TextView qm;
    @BindView(R.id.zwjs)
    TextView zwjs;
    @BindView(R.id.image_icon)
    ImageView image_icon;

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;

    dkInfo.DataBean.ContentBean response;
    @Override
    protected int setLayout() {
        return R.layout.activity_dk_info;
    }

    @Override
    protected void setView() {
     response = (dkInfo.DataBean.ContentBean) getIntent().getSerializableExtra("teacherinfo");
        txtTitle.setText("教师信息");
        btnback.setOnClickListener(this);
    }

    @Override
    protected void setData() {

        if(response != null){
//            String photo = response.get();
//            if(photo != null){
//                Glide.with(this).load(ApiConstants.ImageURLROOT+photo).into(iv_photo);
//            }

            name.setText("姓名："+response.getRealName());

            String optime = response.getCreateDate();
            String substring = optime.substring(0, 10);
            time.setText("出生日期："+substring);

            String sex1 = response.getSex();
            if(sex1.equals("1")){
                sex.setText("性别：男");
            }else if(sex1.equals("0")){
                sex.setText("性别：女");
            }
            zw.setText("职务："+response.getDuty());
            ssdx.setText("所属党校："+response.getPartySchool());
            zc.setText("职称："+response.getHonour());
            qm.setText(response.getSignature());
            zwjs.setText(response.getSelfIntroduction());
        }


    }

    @Override
    public void onClick(View v) {
finish();
    }
}
