package customer.tcrj.com.djproject.sy;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import customer.tcrj.com.djproject.LoginActivity;
import customer.tcrj.com.djproject.MainActivity;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.Utils;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.checkUpdata.SweetAlertDialog;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.widget.DialogDateTimePicker;

public class releaseActivity extends BaseActivity {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;
    @BindView(R.id.time_pop)
    LinearLayout time_pop;
    @BindView(R.id.rl_type)
    LinearLayout rl_type;
    @BindView(R.id.btn_send)
    Button btn_send;

    @BindView(R.id.type)
    TextView type;
    @BindView(R.id.time)
    TextView tvtime;
    @BindView(R.id.edt_search_result)
    EditText title;
    @BindView(R.id.content)
    EditText content;

    private MyOkHttp mMyOkhttp;


    @Override
    protected int setLayout() {
        return R.layout.activity_release;
    }

    @Override
    protected void setView() {
//        setPopuWindow();
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        txtTitle.setText("信息发布");
        btnback.setOnClickListener(this);
        rl_type.setOnClickListener(this);
        time_pop.setOnClickListener(this);
        btn_send.setOnClickListener(this);
    }

    @Override
    protected void setData() {

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btnback:
                finish();
                break;

            case R.id.rl_type:
                setPopuWindow();
                mPopTop.showAsDropDown(rl_type);
                break;
            case R.id.time_pop:
                setTimd();
                break;
            case R.id.btn_send:
                String stype = type.getText().toString();
                String stvtime = tvtime.getText().toString();
                String stitle = title.getText().toString();
                String scontent = content.getText().toString();

                Log.e("TAG","type:"+stype+"---stvtime:"+stvtime+"---stitle:"+stitle+"---scontent:"+scontent);

                if(stype.equals("") || stvtime.equals("") || stitle.equals("") || scontent.equals("") ){
                    Toast.makeText(this, "请将信息填写完整", Toast.LENGTH_SHORT).show();
                }else{
                    toSend(stitle,typeId,scontent,stvtime);
                }

                break;
        }

    }

    private String typeId = "";
    private void setTimd() {

        DialogDateTimePicker start = new DialogDateTimePicker(this);
        start.onDatePickerListener(new DialogDateTimePicker.DatePickerCallBack() {
            @Override
            public void onClickListener(String time) {
                tvtime.setText(time);

            }
        });
        start.show();
    }

    private PopupWindow mPopTop;
    private TextView tvPopuReport;
    private TextView tvPopuShare;
    private TextView tvPopuMove;
    private TextView tvPopuSeas;
    /**
     * 弹出框样式设置
     */
    private void setPopuWindow() {
        mPopTop = new PopupWindow(this);
        int w = Utils.getWidth(this);
        mPopTop.setWidth(mWidth);
        mPopTop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        mPopTop.setFocusable(true);//TODO 获取焦点
        mPopTop.setTouchable(true);
        mPopTop.setOutsideTouchable(true);//TODO 设置popupwindow外部可点击
        ColorDrawable dw = new ColorDrawable(0000000000);// TODO 实例化一个ColorDrawable颜色为半透明
        mPopTop.setBackgroundDrawable(dw);// TODO 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        mPopTop.setAnimationStyle(R.style.mystyle);//TODO 设置显示和消失动画
        View conentView = Utils.getLayoutInflater(this).inflate(R.layout.item_popu_current, null);
        setConentViewClickListener(conentView);
        mPopTop.setContentView(conentView);
    }
    private int mWidth;

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        mWidth = rl_type.getWidth();

        Log.e("TAG", "onWindowFocusChanged: width = " + mWidth);
    }

    /**
     * 事件
     *
     * @param v
     */
    private void setConentViewClickListener(View v) {
        tvPopuReport = (TextView) v.findViewById(R.id.tv_popu_report);
        tvPopuShare = (TextView) v.findViewById(R.id.tv_popu_share);
        tvPopuMove = (TextView) v.findViewById(R.id.tv_popu_move);
        tvPopuSeas = (TextView) v.findViewById(R.id.tv_popu_seas);

        tvPopuReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopTop.dismiss();
                typeId = "JFRFRB";
                type.setText("市级新闻");
            }
        });
        tvPopuShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopTop.dismiss();
                typeId = "VZJNf2";
                type.setText("县级新闻");
            }
        });
        tvPopuMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopTop.dismiss();
                typeId = "Vr6beq";
                type.setText("党委新闻");
            }
        });
        tvPopuSeas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopTop.dismiss();
                typeId = "3A3YN3";
                type.setText("支部新闻");
            }
        });
    }


    private void toSend(final String title,String categoryId,String content, String time) {
        showLoadingDialog("正在提交...");

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("title", title);
            jsonObject.put("content", content);
            jsonObject.put("time", time);
            jsonObject.put("categoryId", categoryId);

//            jsonObject.put("username", "zs");
//            jsonObject.put("password", "123456");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.msgsendApi)
                .jsonParams(jsonObject.toString())
                .tag(this)
                .enqueue(new GsonResponseHandler<Entity>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        hideLoadingDialog();
                        showUpdateDialog("信息发布失败", 1);
                        Log.e("TAG","msg"+statusCode);
                    }

                    @Override
                    public void onSuccess(int statusCode, Entity response) {
                        hideLoadingDialog();
                        if(response.getErrorCode().equals("0")){
                            showUpdateDialog("信息发布成功", 2);
                        }
                    }
                });
    }

    private void showUpdateDialog(String s, final int num) {

/*		Intent intent = new Intent();
        intent.setClass(mContext, IsDownLoad.class);
		mContext.startActivity(intent);*/
        final SweetAlertDialog sad = new SweetAlertDialog(this);
        sad.setTitleText(s);
        sad.setContentText("");
        sad.setConfirmText("确定");
        sad.setCanceledOnTouchOutside(true);
        sad.setCancelable(true);

        sad.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {

                if(num == 2){
                    finish();
                }

                sad.dismiss();

            }
        });
        sad.show();
    }
}
