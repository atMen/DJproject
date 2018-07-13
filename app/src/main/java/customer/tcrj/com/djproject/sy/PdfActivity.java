package customer.tcrj.com.djproject.sy;

import android.Manifest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnErrorListener;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.net.ApiConstants;

public class PdfActivity extends AppCompatActivity implements View.OnClickListener {

    private PDFView pdfView;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private TextView pageTv, pageTv1,txtTitle,tv_onemore;
    private ImageView btnback;
    private LinearLayout ll_pdf;
    private int p;

    private MyOkHttp mMyOkhttp;
    private String memberId;
    private String minduction;
    private String studyState;
    private String courseId;
    Entity loginInfo;

    boolean isError = true;

    private void downloadFile(String url) {
        showLoadingDialog("正在加载");
        File file = new File(url);
        String fileName = file.getName();
        String localFileName = getCacheDir().getAbsolutePath() + fileName;
        File localFile = new File(localFileName);
        if (localFile.exists() && isError) {
            Log.e("TAG","isError "+isError);
            openFile(localFile);
            return;
        }
        OkGo.<File>get(url).tag(this).execute(new FileCallback(getCacheDir().getAbsolutePath(), fileName) {
            @Override
            public void onSuccess(Response<File> response) {
                hideLoadingDialog();
                Log.e("TAG", "onSuccess: 下载成功"+response.body().getAbsolutePath());
                if (response.body().exists()) {
                    openFile(response.body());
                }
            }

            @Override
            public void onError(Response<File> response) {
                hideLoadingDialog();
                Log.e("TAG", "onError:downloadProgress ---" + response.getException().getMessage());
                Log.e("TAG", "onError: 下载失败");
                isError = false;
                tv_onemore.setVisibility(View.VISIBLE);
                ll_pdf.setVisibility(View.GONE);
            }

            @Override
            public void downloadProgress(Progress progress) {
                Log.e("TAG", "onError:downloadProgress ---" + progress.currentSize);
            }
        });
    }

    private void openFile(File absolutePath) {

        Log.e("TAG","openFile"+absolutePath);


//        pdfView.fromFile(absolutePath)
//                .enableSwipe(true)
//                .swipeHorizontal(true)
//                .enableDoubletap(false)
//                .defaultPage(0)
//                .onLoad(new OnLoadCompleteListener() {
//                    @Override
//                    public void loadComplete(int nbPages) {
//                        pageTv.setText(nbPages + "");
////                        pageTv1.setText(myPage +  "/");
//                    }
//                })
//                .onPageChange(new OnPageChangeListener() {
//
//                    @Override
//                    public void onPageChanged(int page, int pageCount) {
//                        p = page;
//                        pageTv1.setText(page + "/");
//                    }
//                })
//                .enableAnnotationRendering(false)
//                .password(null)
//                .scrollHandle(null)
//                .enableAntialiasing(true)
//                .spacing(0)
//                .pageFitPolicy(FitPolicy.BOTH)
//                .load();

        pdfView.fromFile(absolutePath)
                .enableAnnotationRendering(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .spacing(10) // in dp
                .pageFitPolicy(FitPolicy.BOTH)
                .onError(new OnErrorListener() {
                    @Override
                    public void onError(Throwable t) {
                        Log.e("TAG","加载错误");
                        isError = false;
                        tv_onemore.setVisibility(View.VISIBLE);
                        ll_pdf.setVisibility(View.GONE);

                    }
                })

                .load();


    }
    private String file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.red), true);


        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");
        courseId = getIntent().getStringExtra("kjid");
        memberId = getIntent().getStringExtra("kcid");
        studyState = getIntent().getStringExtra("studyState");
        minduction = getIntent().getStringExtra("minduction");
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();


        //获取动态权限
        getPermission();
        pdfView = (PDFView) findViewById(R.id.pdfView);
        pageTv = (TextView) findViewById(R.id.pageTv);
        pageTv1 = (TextView) findViewById(R.id.pageTv1);
        txtTitle = (TextView) findViewById(R.id.txtTitle);
        btnback = (ImageView) findViewById(R.id.btnback);
        tv_onemore = (TextView) findViewById(R.id.tv_onemore);
        ll_pdf = (LinearLayout) findViewById(R.id.ll_pdf);

        txtTitle.setText("文档学习");
        btnback.setOnClickListener(this);
        tv_onemore.setOnClickListener(this);
        file = getIntent().getStringExtra("file");
        Log.e("TAG","file:"+file);
        downloadFile(ApiConstants.FileURLROOT+file);

    }

    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };


    private void getPermission() {
        int hasWriteContactsPermission = ContextCompat.checkSelfPermission(PdfActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
            if (!ActivityCompat.shouldShowRequestPermissionRationale(PdfActivity.this,
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
                ActivityCompat.requestPermissions(PdfActivity.this,
                        PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
            }

            ActivityCompat.requestPermissions(PdfActivity.this,
                    PERMISSIONS_STORAGE, REQUEST_EXTERNAL_STORAGE);
        }

        while ((ContextCompat.checkSelfPermission(PdfActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) != PackageManager.PERMISSION_GRANTED) {
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
    protected void onDestroy() {
        super.onDestroy();
        //当activity销毁的时候，保存当前的页数，下次打开的时候，直接翻到这个页
//        SPUtils.put(MainActivity.this, "page", p);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.btnback:
                finish();
                break;
            case R.id.tv_onemore:
                tv_onemore.setVisibility(View.GONE);
                ll_pdf.setVisibility(View.VISIBLE);
                if(file != null){
                    Log.e("TAG","onemore file:"+file);
                    downloadFile(ApiConstants.FileURLROOT+file);
                }

                break;
        }

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
