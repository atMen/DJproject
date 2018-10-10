package customer.tcrj.com.djproject.sy.infoactivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.githang.statusbar.StatusBarCompat;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.sy.photoview.DetailAdapter;
import customer.tcrj.com.djproject.sy.photoview.ImageInfo;

public class TpActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtTitle;
    private ImageView btnback;

    private MyOkHttp mMyOkhttp;
    private String coursewareId;
    private String minduction;
    private String studyState;
    private String courseId;
    Entity loginInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.red), true);


        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");
        courseId = getIntent().getStringExtra("kjid");//课件id
        coursewareId = getIntent().getStringExtra("kcid");//课程id
        studyState = getIntent().getStringExtra("studyState");
        minduction = getIntent().getStringExtra("minduction");
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        String iconinfo = getIntent().getStringExtra("iconinfo");
        String[] split = iconinfo.split(",");

        RecyclerView recyclerview = (RecyclerView) findViewById(R.id.recyclerview);

        txtTitle = (TextView) findViewById(R.id.txtTitle);
        btnback = (ImageView) findViewById(R.id.btnback);

        txtTitle.setText("图片学习");
        btnback.setOnClickListener(this);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        List<ImageInfo> infos = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            ImageInfo info = new ImageInfo();

            info.images = new String[split.length];

            for(int j = 0;j < split.length;j++){

                Log.e("ATG","ApiConstants.ImageURLROOT+split[j]:"+ApiConstants.ImageURLROOT+split[j]);
                info.images[j] = ApiConstants.ImageURLROOT+split[j];
            }
            infos.add(info);


        }

        if(split.length > 0){
            recyclerview.setAdapter(new DetailAdapter(this, infos));
        }else {
            Toast.makeText(this, "暂无数据", Toast.LENGTH_SHORT).show();
        }

    }

    protected Dialog mLoadingDialog = null;
    protected void showLoadingDialog(String str) {
        if (mLoadingDialog != null) {
            TextView tv = (TextView) mLoadingDialog.findViewById(R.id.tv_load_dialog);
            tv.setText(str);
            mLoadingDialog.show();
        }
    }

    protected void hideLoadingDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
        }
    }

    private int number = -1;
    Timer timer;
    TimerTask timerTask;

    Handler handlerTime = new Handler() {
        public void handleMessage(Message msg) {

            number++;
//            num.setText(number+"");

        }
    };


    private Handler handlerStopTime = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    stopTime();
                    break;
                case 1:
                    startTime();
                    break;
                default:
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        Message msg = new Message();
        msg.what = 0;
        handlerStopTime.sendMessage(msg);
        super.onPause();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        Message msg = new Message();
        msg.what = 1;
        handlerStopTime.sendMessage(msg);
        super.onResume();
    }

    private void startTime() {
        if (timer == null) {
            timer = new Timer();
        }
        if (timerTask == null) {
            timerTask = new TimerTask() {

                @Override
                public void run() {
                    Message msg = new Message();
                    msg.what = 0;
                    handlerTime.sendMessage(msg);
                }
            };
        }
        if (timer != null && timerTask != null) {
            timer.schedule(timerTask, 0, 1000);
        }
    }

    private void stopTime(){
        if(timer!=null){
            timer.cancel();
            timer=null;
        }
        if(timerTask!=null){
            timerTask.cancel();
            timerTask=null;
        }
    }



    //弹出对话框通知用户答题时间到
    protected void showTimeOutDialog(final boolean flag, final String backtype) {
        final Dialog builder = new Dialog(this, R.style.mydialog);

        builder.setContentView(R.layout.my_dialog);
        TextView title = (TextView) builder.findViewById(R.id.dialog_title);
        TextView content = (TextView) builder.findViewById(R.id.dialog_content);
        if(backtype.equals("1")){
            content.setText("您要结束本次学习吗？");
        }else{
            content.setText("错误信息");
        }
        final Button confirm_btn = (Button) builder
                .findViewById(R.id.dialog_sure);
        Button cancel_btn = (Button) builder.findViewById(R.id.dialog_cancle);
        if(backtype.equals("1")){
            confirm_btn.setText("退出");
            cancel_btn.setText("继续学习");
        }else{
            confirm_btn.setText("确定");
            cancel_btn.setVisibility(View.GONE);
        }
        confirm_btn.setOnClickListener(new View.OnClickListener() {//退出
            @Override
            public void onClick(View v) {
                if (backtype.equals("0")){
                    builder.dismiss();
                    //上传学习时间

                }else{
                    builder.dismiss();


                    //上传学习时间
                    if(studyState.equals("100")){
                        finish();
                    }else {
                        upDataprogress();

                    }
                }
            }
        });

        cancel_btn.setOnClickListener(new View.OnClickListener() {//继续学习
            @Override
            public void onClick(View v) {
                if (backtype.equals("0")) {
                    finish();
                    builder.dismiss();
                } else {
                    builder.dismiss();
                    Message msg = new Message();
                    msg.what = 1;
                    handlerStopTime.sendMessage(msg);
                }
            }
        });
        builder.setCanceledOnTouchOutside(false);// 设置点击Dialog外部任意区域关闭Dialog
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {

            @Override
            public boolean onKey(DialogInterface dialog, int keyCode,
                                 KeyEvent event) {
                return flag;
            }
        });
        builder.show();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            showTimeOutDialog(true, "1");
            Message msg = new Message();
            msg.what = 0;
            handlerStopTime.sendMessage(msg);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onClick(View v) {
        finish();
    }


    private void upDataprogress() {


        int l = (int) (Long.parseLong(minduction) * 60);

        showLoadingDialog("正在保存学习进度");
        JSONObject jsonObject = new JSONObject();
        try {

            if(number >= l){
                jsonObject.put("studyState", "100");
            }else{
                jsonObject.put("studyState", "0");
            }
            jsonObject.put("memberId", loginInfo.getData().getData().getId());
            jsonObject.put("coursewareId", courseId);
            jsonObject.put("playTime", "-1");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.StudyStateApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<Entity>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        hideLoadingDialog();
                        Log.e("TAG","失败："+error_msg);
                        finish();
                    }

                    @Override
                    public void onSuccess(int statusCode, Entity response) {
                        hideLoadingDialog();
                        Log.e("TAG","成功："+response.getMessage());
                        finish();
                    }
                });
    }
}
