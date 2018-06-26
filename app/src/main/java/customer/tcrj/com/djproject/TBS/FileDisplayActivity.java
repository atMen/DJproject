package customer.tcrj.com.djproject.TBS;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.githang.statusbar.StatusBarCompat;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.FileCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.tencent.smtt.sdk.TbsReaderView;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.DialogHelper;
import customer.tcrj.com.djproject.Utils.Utils;

/**
 * Project :  yunaandroid.
 * Package name: com.renwei.yunlong.activity
 * Created by :  Benjamin.
 * Created time: 2017/11/24 10:58
 * Changed by :  Benjamin.
 * Changed time: 2017/11/24 10:58
 * Class description:
 */

public class FileDisplayActivity extends Activity implements TbsReaderView.ReaderCallback {

    private final String TAG = "FileDisplayActivity";
    TextView tvInformation;
    LinearLayout tbsParent;
    private TbsReaderView mTbsReaderView;
    private TextView num;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_display);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.red), true);
        mLoadingDialog = DialogHelper.getLoadingDialog(this);

        String path = getIntent().getStringExtra("path") == null ? "" : getIntent().getStringExtra("path");

        num = (TextView) findViewById(R.id.num);
        num.setVisibility(View.VISIBLE);


        tbsParent = (LinearLayout) findViewById(R.id.tbsParent);
        tvInformation = (TextView) findViewById(R.id.tv_information);
//        mTbsReaderView = (TbsReaderView)findViewById(R.id.tbs);
        mTbsReaderView = new TbsReaderView(this, FileDisplayActivity.this);
        tbsParent.addView(mTbsReaderView, new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        downloadFile(path);
    }

    private void openFile(String absPath) {
        final File file = new File(absPath);
        if (file.exists()) {
            //显示文件
            final Bundle bundle = new Bundle();
            bundle.putString("filePath", absPath);
            bundle.putString("tempPath", Environment.getExternalStorageDirectory().getPath());
            String pathFormat = parseFormat(absPath);
            boolean result = mTbsReaderView.preOpen(pathFormat, false);
            Log.e(TAG, String.valueOf(file.getName()) + "文件格式:" + pathFormat + "预加载结果" + result);
            if (result) {
                tvInformation.setVisibility(View.GONE);
                mTbsReaderView.setVisibility(View.VISIBLE);
                mTbsReaderView.openFile(bundle);
            } else {
                mTbsReaderView.setVisibility(View.GONE);
                tvInformation.setVisibility(View.VISIBLE);
                tvInformation.setText("不支持的文件格式");
            }

        } else {
            mTbsReaderView.setVisibility(View.GONE);
            tvInformation.setVisibility(View.VISIBLE);
            tvInformation.setText("文件不存在");
        }
    }

    //获取文件的格式判断文件是否支持 这里文件是不需要带.的 ******
    private String parseFormat(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTbsReaderView.onStop();
        tbsParent.removeView(mTbsReaderView);
    }

    private void downloadFile(String url) {
        showLoadingDialog("正在加载");
        File file = new File(url);
        String fileName = file.getName();
        String localFileName = getCacheDir().getAbsolutePath() + fileName;
        File localFile = new File(localFileName);
        if (localFile.exists()) {
            openFile(localFile.getAbsolutePath());
            return;
        }
        OkGo.<File>get(url).tag(this).execute(new FileCallback(getCacheDir().getAbsolutePath(), fileName) {
            @Override
            public void onSuccess(Response<File> response) {
                Log.e(TAG, "onSuccess: 下载成功");
                hideLoadingDialog();
                if (response.body().exists()) {
                    openFile(response.body().getAbsolutePath());
                }
            }

            @Override
            public void onError(Response<File> response) {
                hideLoadingDialog();
                Toast.makeText(FileDisplayActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onError:downloadProgress ---" + response.getException().getMessage());
                Log.e(TAG, "onError: 下载失败");
            }

            @Override
            public void downloadProgress(Progress progress) {
                Log.e(TAG, "onError:downloadProgress ---" + progress.currentSize);
            }
        });
    }

    @Override
    public void onCallBackAction(Integer integer, Object o, Object o1) {

    }

    public static void openActivity(Context context, String url) {
        Intent intent = new Intent(context, FileDisplayActivity.class);
        intent.putExtra("path", url);
        context.startActivity(intent);
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
            num.setText(number+"");

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
        Log.e(TAG, "onPause");
        // TODO Auto-generated method stub
        Message msg = new Message();
        msg.what = 0;
        handlerStopTime.sendMessage(msg);
        super.onPause();
    }

    @Override
    protected void onResume() {
        Log.e(TAG, "onResume");
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
                    finish();
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



}
