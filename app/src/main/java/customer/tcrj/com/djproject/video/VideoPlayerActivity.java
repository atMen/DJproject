package customer.tcrj.com.djproject.video;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import customer.tcrj.com.djproject.LoginActivity;
import customer.tcrj.com.djproject.MainActivity;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.Utils.DialogHelper;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.net.ApiConstants;


/***********************************************************************
 * 视频播放器-使用系统控件
 ***********************************************************************/
public class VideoPlayerActivity extends Activity implements View.OnClickListener {

    private static final String TAG = VideoPlayerActivity.class.getSimpleName();

    private static final String ROOTURL = "http://192.168.10.27:9134/web.files";
    /**
     * 视频进度更新
     */
    private static final int PROGRESS = 1;
    /**
     * 隐藏控制面板的消息
     */
    private static final int HIDE_MEDIACONTROL = 2;
    /**
     * 屏幕默认播放方式
     */
    private static final int SCREEN_DEFAULT = 3;
    /**
     * 屏幕以全屏方式播放
     */
    private static final int SCREEN_FULL = 4;
    private static final int FINISH = 5;
    private VideoView videoview;
    private Uri uri;

    private LinearLayout llTop;
    private TextView tvVideoname;
    private LinearLayout ll_loading;
    private LinearLayout ll_buffering;
    private ImageView ivSystemBattery;
    private TextView tvSystemTime;
    private Button btnVideoVoice;
    private SeekBar seekbarVoice;
    private Button btnSwitchPlayer;
    private LinearLayout llBottom;
    private TextView tvCurrentTime;
    private MySeekBar seekbarVideo;
    private TextView tvDuration;
    private Button btnVideoBack;
    private Button btnVideoPre;
    private Button btnVideoStartPause;
    private Button btnVideoNext;
    private Button btnVideoSwitchScreen;
    private Button btnbigvideo;
    private MyReceiver receiver;


    /**
     * 视频列表中的位置
     */
    private int position;

    //手势识别器
    //1.定义手势识别器，申明
    //2.实例化手势识别器，重新双击，单击，长按方法
    //3.接收事件onTouchEvent();
    private GestureDetector detector;

    /**
     * 是否隐藏了控制面板
     */
    private boolean isHideMediaControl = false;
    /**
     * 视频原始画面的大小
     */
    private int videoWidth;
    private int videoHeight;

    /**
     * 声音服务
     */
    private AudioManager am;
    /**
     * 当前音量
     */
    private int currentVolume;

    /**
     * 最大音量
     */
    private int maxVolume;

    /**
     * 是否是静音
     */
    private boolean isMute = false;
    /**
     *起始坐标
     */

    private  float startY;

    /**
     * 滑动的区域
     */
    private float touchRang;
    /**
     * 当前的音量
     */
    private  int mVol;

    class MyOnPreparedListener implements MediaPlayer.OnPreparedListener {
        @Override
        public void onPrepared(MediaPlayer mp) {

            mp.setOnSeekCompleteListener(new MediaPlayer.OnSeekCompleteListener() {
                @Override
                public void onSeekComplete(MediaPlayer mp) {
                    Toast.makeText(VideoPlayerActivity.this, "拖动完成了", Toast.LENGTH_SHORT).show();
                }
            });

            videoWidth = mp.getVideoWidth();
            videoHeight = mp.getVideoHeight();

            //隐藏加载画面
            ll_loading.setVisibility(View.GONE);


            videoview.start();//开始播放
            //设置总时长
            int duration = videoview.getDuration();//毫秒
            tvDuration.setText(utils.stringForTime(duration));

            //1.SeekBar.setMax(duration);SeekBar和总时长关联起来
            seekbarVideo.setMax(duration);

            //隐藏控制面板
            hideMediaControl();
            setVideoType(SCREEN_DEFAULT);
            //发消息更新
            handler.sendEmptyMessage(PROGRESS);
        }
    }

    ;

    class MyOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
//            playNextVideo();
            Toast.makeText(VideoPlayerActivity.this, "播放完成", Toast.LENGTH_SHORT).show();
        }
    }

    class MyOnErrorListener implements MediaPlayer.OnErrorListener {

        @Override
        public boolean onError(MediaPlayer mp, int what, int extra) {
            //1.系统播放器格式不支持-直接跳转到万能播放器
            //2.播放网络资源，网络中断--如果是已经播放起来，就重试（在网络断断续续）
            //3.视频下载中间有空白-把下载的bug给修改了
//            startVitamioPlayer();
            return true;
        }
    }

//    private void startVitamioPlayer() {
//        Intent intent = new Intent(this,VitamioVideoPlayerActivity.class);
//        if(mediaItems != null && mediaItems.size() >0){
//
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("videolist", mediaItems);//传递的是播放列表
//            intent.putExtras(bundle);
//            //传递播放位置
//            intent.putExtra("position", position);
//
//        }else if(uri != null){
//            intent.setData(uri);//文件夹，浏览器，QQ控件
//        }
//
//        startActivity(intent);
//
//        handler.sendEmptyMessageDelayed(FINISH,1500);
//
//    }

//    /**
//     * 播放下一个视频
//     */
//    private void playNextVideo() {
//
//        if (mediaItems != null && mediaItems.size() > 0) {
//
//            position++;
//            if (position < mediaItems.size()) {
//
//                MediaItem mediaItem = mediaItems.get(position);
//                tvVideoname.setText(mediaItem.getTitle());
//                videoview.setVideoPath(mediaItem.getData());
//                isNetUrl = utils.isNetUrl(mediaItem.getData());
//                ll_loading.setVisibility(View.VISIBLE);
//                setButtonStatus();
//                if (position == mediaItems.size() - 1) {
//                    Toast.makeText(VideoPlayerActivity.this, "已经最后一个视频了", Toast.LENGTH_SHORT).show();
//                }
//
//            } else {
//                finish();
//
//            }
//
//        }
//
//    }
//
//    /**
//     * 播放上一个视频
//     */
//    private void playPreVideo() {
//
//        if (mediaItems != null && mediaItems.size() > 0) {
//
//            position--;
//            if (position >= 0) {
//
//                MediaItem mediaItem = mediaItems.get(position);
//                tvVideoname.setText(mediaItem.getTitle());
//                videoview.setVideoPath(mediaItem.getData());
//                isNetUrl = utils.isNetUrl(mediaItem.getData());
//                ll_loading.setVisibility(View.VISIBLE);
//                setButtonStatus();
//
//
//            } else {
//                position = 0;
//
//            }
//
//        }
//
//    }

//    private void setButtonStatus() {
//        if (mediaItems != null && mediaItems.size() > 0) {
//            if (position == 0) {//上一个按钮变灰，并且不可用点击
//                btnVideoPre.setBackgroundResource(R.drawable.btn_pre_gray);
//                btnVideoPre.setEnabled(false);
//            } else if (position == mediaItems.size() - 1) {//下一个按钮变灰，并且不可用点击
//                btnVideoNext.setBackgroundResource(R.drawable.btn_next_gray);
//                btnVideoNext.setEnabled(false);
//            } else {
//                //把按钮设置默认和可以点击
//                btnVideoPre.setBackgroundResource(R.drawable.btn_video_pre_selector);
//                btnVideoPre.setEnabled(true);
//                btnVideoNext.setBackgroundResource(R.drawable.btn_video_next_selector);
//                btnVideoNext.setEnabled(true);
//            }
//        } else if (uri != null) {//播放源来自，本地文件夹，浏览器，网络
//            btnVideoPre.setBackgroundResource(R.drawable.btn_pre_gray);
//            btnVideoPre.setEnabled(false);
//            btnVideoNext.setBackgroundResource(R.drawable.btn_next_gray);
//            btnVideoNext.setEnabled(false);
//        }
//
//
//    }

    /**
     * Activity是否销毁
     */
    private boolean isActivityDestroy = false;

    private Utils utils;

    /**
     * 是否是全屏播放
     */
    private boolean isScreenFull = false;

    private int screenWidth;
    private int screenHeight;

    private  boolean isNetUrl;

    /**
     * 上一秒视频播放的进度
     */
    private  int preCurrentPosition;

//    /**
//     * Activity的生命周期的主要方法
//     * onCreate();
//     * onStart();
//     * onResume();
//     * onPause();
//     * onStop();
//     * onDestory();
//     *
//     * @param savedInstanceState
//     */
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.e(TAG, "onCreate");
//
//        initData();
//
//        findViews();
//
////        getData();
//        setListener();
//        setData();
//
//
//    }
//    String url = "http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4";
//
//    String music = "http://192.168.20.201:8080/web.files/uploadfile/ryEbiy/2018-04-28/20180428084824160.mp3";
    private void setData() {
        //设置控制面板-自定义
//        videoview.setMediaController(new MediaController(this));

//        if (mediaItems != null && mediaItems.size() > 0) {
//
//            MediaItem mediaItem = mediaItems.get(position);
//            tvVideoname.setText(mediaItem.getTitle());
//            videoview.setVideoPath(mediaItem.getData());
//            isNetUrl = utils.isNetUrl(mediaItem.getData());
//
//
//        } else if (uri != null) {
        uri = Uri.parse(file);
        videoview.setVideoURI(uri);//设置视频播放地址
            tvVideoname.setText(filename);
            isNetUrl = utils.isNetUrl(uri.toString());
//        }

//        setButtonStatus();


    }

//    private void getData() {
//        Intent intent = getIntent();
//        uri = intent.getData();//null,浏览器，本地浏览器，相册
//        mediaItems = (ArrayList<MediaItem>) intent.getSerializableExtra("videolist");
//        position = intent.getIntExtra("position", 0);
//
//
//    }


    private void initData() {
        utils = new Utils();
        //注册监听电量广播
        receiver = new MyReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receiver, filter);

        //得到屏幕的宽和高
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        screenWidth = wm.getDefaultDisplay().getWidth();
        screenHeight = wm.getDefaultDisplay().getHeight();

        //得到当前音量和最大音量
        am = (AudioManager) getSystemService(AUDIO_SERVICE);
        //当前音量：0~15等级
        currentVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        //最大音量
        maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        Log.e(TAG, "最大音量为==" + maxVolume);
        //2.实例化手势识别器
        detector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapConfirmed(MotionEvent e) {
//                Toast.makeText(VideoPlayerActivity.this,"d单击了",Toast.LENGTH_SHORT).show();
                if (isHideMediaControl) {
                    //显示控制面板
                    showMediaControl();
                    //过一段时间后（5000）隐藏控制面板
                    handler.sendEmptyMessageDelayed(HIDE_MEDIACONTROL, 5000);
                } else {
                    //隐藏控制面板
                    hideMediaControl();
                    //移除控制面板
                    handler.removeMessages(HIDE_MEDIACONTROL);
                }
                return super.onSingleTapConfirmed(e);

            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
//                Toast.makeText(VideoPlayerActivity.this,"双击了",Toast.LENGTH_SHORT).show();
                switchVideoSize();
                return super.onDoubleTap(e);
            }

            @Override
            public void onLongPress(MotionEvent e) {
//                Toast.makeText(VideoPlayerActivity.this,"长按了",Toast.LENGTH_SHORT).show();
                startAndPause();
                super.onLongPress(e);

            }
        });
    }

    private void setVideoType(int screenDefault) {
        switch (screenDefault) {
            case SCREEN_FULL://全屏播放器
                videoview.setVideoSize(screenWidth, screenHeight);
                isScreenFull = true;
                //按钮状态设置为默认
                btnVideoSwitchScreen.setBackgroundResource(R.drawable.btn_video_switch_screen_default_selector);
                break;
            case SCREEN_DEFAULT://默认播放

                //真正视频的宽和高
                int mVideoWidth = videoWidth;
                int mVideoHeight = videoHeight;

                //屏幕的宽和高
                int width = screenWidth;
                int height = screenHeight;

                if (mVideoWidth > 0 && mVideoHeight > 0) {
                    if (mVideoWidth * height < width * mVideoHeight) {
                        //Log.i("@@@", "image too wide, correcting");
                        width = height * mVideoWidth / mVideoHeight;
                    } else if (mVideoWidth * height > width * mVideoHeight) {
                        //Log.i("@@@", "image too tall, correcting");
                        height = width * mVideoHeight / mVideoWidth;
                    }
                }
                videoview.setVideoSize(width, height);
                isScreenFull = false;
                //按钮状态设置为默认
                btnVideoSwitchScreen.setBackgroundResource(R.drawable.btn_video_switch_screen_full_selector);


                break;
            default:
                break;
        }
    }


    class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra("level", 0);//0~100
            //设置电量状态
            setBatteryStatus(level);
            Log.e(TAG, "VideoPlayerActivity当前线程名称=" + Thread.currentThread().getName());
        }
    }

    private void setBatteryStatus(int level) {
        if (level <= 0) {
            ivSystemBattery.setImageResource(R.drawable.ic_battery_0);
        } else if (level <= 10) {
            ivSystemBattery.setImageResource(R.drawable.ic_battery_10);
        } else if (level <= 20) {
            ivSystemBattery.setImageResource(R.drawable.ic_battery_20);
        } else if (level <= 40) {
            ivSystemBattery.setImageResource(R.drawable.ic_battery_40);
        } else if (level <= 60) {
            ivSystemBattery.setImageResource(R.drawable.ic_battery_60);
        } else if (level <= 80) {
            ivSystemBattery.setImageResource(R.drawable.ic_battery_80);
        } else if (level <= 100) {
            ivSystemBattery.setImageResource(R.drawable.ic_battery_100);
        } else {
            ivSystemBattery.setImageResource(R.drawable.ic_battery_100);
        }

    }


    /**
     * 隐藏控制面板
     */
    private void hideMediaControl() {
        llTop.setVisibility(View.GONE);
        llBottom.setVisibility(View.GONE);
        isHideMediaControl = true;

    }

    /**
     * 显示控制面板
     */
    private void showMediaControl() {
        llTop.setVisibility(View.VISIBLE);
        llBottom.setVisibility(View.VISIBLE);
        isHideMediaControl = false;

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_VOLUME_DOWN){
            currentVolume--;
            updatavolumeProgress(currentVolume);
            handler.removeMessages(HIDE_MEDIACONTROL);
            handler.sendEmptyMessageDelayed(HIDE_MEDIACONTROL, 5000);
            return true;
        }else if(keyCode == KeyEvent.KEYCODE_VOLUME_UP){
            currentVolume++;
            updatavolumeProgress(currentVolume);
            handler.removeMessages(HIDE_MEDIACONTROL);
            handler.sendEmptyMessageDelayed(HIDE_MEDIACONTROL, 5000);
            return true;
        }

        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            showTimeOutDialog(true, "1");
            Message msg = new Message();
            msg.what = 0;
            handlerStopTime.sendMessage(msg);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    //3.接收事件，传递给手识别器
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        detector.onTouchEvent(event);
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN://手指按下屏幕
                //1.记录相关的值
                startY = event.getY();
                touchRang = Math.min(screenWidth, screenHeight);//screenHeight
                mVol = am.getStreamVolume(AudioManager.STREAM_MUSIC);
                handler.removeMessages(HIDE_MEDIACONTROL);
                break;
            case MotionEvent.ACTION_MOVE://手指在屏幕上移动
                //2.来到结束的坐标
                float endY = event.getY();
                //3.计算偏移量
                float distanceY = startY - endY;

                //要改变的声音 = (滑动的距离 / 总距离)*最大音量
                float delta = (distanceY/touchRang)*maxVolume;
                //最终声音 = 原来的声音 + 要改变的声音
                float volume = Math.min(Math.max(mVol+delta,0),maxVolume);
                if(delta != 0){
                    updatavolumeProgress((int) volume);
                }

//                startY = event.getY();
                break;

            case MotionEvent.ACTION_UP://手指离开屏幕
                handler.sendEmptyMessageDelayed(HIDE_MEDIACONTROL,5000);
                break;
        }
        return super.onTouchEvent(event);
    }

    private void setListener() {


        //监听视频的拖动-SeeKBar的状态
        seekbarVideo.setOnSeekBarChangeListener(new VideoOnSeekBarChangeListener());

        seekbarVoice.setOnSeekBarChangeListener(new VoiceOnSeekBarChangeListener());

        //设置准备好了的监听
        videoview.setOnPreparedListener(new MyOnPreparedListener());
        //播放完成监听
        videoview.setOnCompletionListener(new MyOnCompletionListener());
        //播放出错的监听
        videoview.setOnErrorListener(new MyOnErrorListener());

        //设置监听卡
        videoview.setOnInfoListener(new VideoOnInfoListener());
    }

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

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case  FINISH:
                    finish();
                    break;
                case PROGRESS://视频更新

                    //得到当前的进度-当前秒
                    int mCurrentPosition = videoview.getCurrentPosition();
                    Log.e("TAG","position:"+mCurrentPosition);
                    //得到当前播放的进度 - 记录前一秒的进度 < 500; 卡
                    int buffering = mCurrentPosition - preCurrentPosition;
                    if(buffering < 500 && videoview.isPlaying()&&isNetUrl){
                        //卡了
                        ll_buffering.setVisibility(View.VISIBLE);
                    }else{

                        //不卡
                        ll_buffering.setVisibility(View.GONE);
                    }

                    preCurrentPosition = mCurrentPosition;

                    tvCurrentTime.setText(utils.stringForTime(mCurrentPosition));


                    //2.更新SeekBar的进度
                    seekbarVideo.setProgress(mCurrentPosition);

                    //更新系统时间
                    tvSystemTime.setText(getSystemTime());


                    //设置视频缓冲

                    if(isNetUrl){
                        //网络视频
                        int buffer = videoview.getBufferPercentage();//0~100;
                        int totalBuffer = seekbarVideo.getMax()*buffer;
                        int secondaryProgress  = totalBuffer/100;
                        seekbarVideo.setSecondaryProgress(secondaryProgress);
                    }else{
                        //本地视频
                        seekbarVideo.setSecondaryProgress(0);
                    }



                    if (!isActivityDestroy) {
                        handler.removeMessages(PROGRESS);
                        handler.sendEmptyMessageDelayed(PROGRESS, 1000);
                    }

                    break;
                case HIDE_MEDIACONTROL://隐藏控制面板
                    hideMediaControl();
                    break;
            }
        }
    };

    /**
     * 得到系统时间
     *
     * @return
     */

    private String getSystemTime() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return format.format(new Date());
    }

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2016-01-23 09:43:19 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {
        videoview = (VideoView) findViewById(R.id.videoview);
        llTop = (LinearLayout) findViewById(R.id.ll_top);
        ll_loading = (LinearLayout) findViewById(R.id.ll_loading);
        ll_buffering = (LinearLayout) findViewById(R.id.ll_buffering);
        tvVideoname = (TextView) findViewById(R.id.tv_videoname);
        ivSystemBattery = (ImageView) findViewById(R.id.iv_system_battery);
        tvSystemTime = (TextView) findViewById(R.id.tv_system_time);
        btnVideoVoice = (Button) findViewById(R.id.btn_video_voice);
        seekbarVoice = (SeekBar) findViewById(R.id.seekbar_voice);
        btnSwitchPlayer = (Button) findViewById(R.id.btn_switch_player);
        llBottom = (LinearLayout) findViewById(R.id.ll_bottom);
        tvCurrentTime = (TextView) findViewById(R.id.tv_current_time);
        seekbarVideo = (MySeekBar) findViewById(R.id.seekbar_video);
        tvDuration = (TextView) findViewById(R.id.tv_duration);
        btnVideoBack = (Button) findViewById(R.id.btn_video_back);
        btnVideoPre = (Button) findViewById(R.id.btn_video_pre);
        btnVideoStartPause = (Button) findViewById(R.id.btn_video_start_pause);
        btnVideoNext = (Button) findViewById(R.id.btn_video_next);
        btnVideoSwitchScreen = (Button) findViewById(R.id.btn_video_switch_screen);//btn_bigvideo
        btnbigvideo = (Button) findViewById(R.id.btn_bigvideo);


        btnVideoVoice.setOnClickListener(this);
        btnSwitchPlayer.setOnClickListener(this);
        btnVideoBack.setOnClickListener(this);
        btnVideoPre.setOnClickListener(this);
        btnVideoStartPause.setOnClickListener(this);
        btnVideoNext.setOnClickListener(this);
        btnVideoSwitchScreen.setOnClickListener(this);
        btnbigvideo.setOnClickListener(this);


        //设置最大音量和当前默认值
        seekbarVoice.setMax(maxVolume);
        seekbarVoice.setProgress(currentVolume);

    }


    /**
     * Handle button click events<br />
     * <br />
     * Auto-created on 2016-01-23 09:43:19 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    @Override
    public void onClick(View v) {
        if (v == btnVideoVoice) {
            // Handle clicks for btnVideoVoice
            isMute = !isMute;
            updatavolume(currentVolume);
        } else if (v == btnSwitchPlayer) {
            // Handle clicks for btnSwitchPlayer
            showSwichPlayerDialog();
        } else if (v == btnVideoBack) {
            // Handle clicks for btnVideoBack
            finish();
        } else if (v == btnVideoPre) {
//            playPreVideo();
            // Handle clicks for btnVideoPre
        } else if (v == btnVideoStartPause) {
            startAndPause();
            // Handle clicks for btnVideoStartPause
        } else if (v == btnVideoNext) {
            // Handle clicks for btnVideoNext
//            playNextVideo();
        } else if (v == btnVideoSwitchScreen) {
            // Handle clicks for btnVideoSwitchScreen
            switchVideoSize();
        }else if (v == btnbigvideo) {
            // Handle clicks for btnVideoSwitchScreen
            Bundle bundle = new Bundle();
            bundle.putInt("position",videoview.getCurrentPosition());
            toClass(this,VideoPlayerbigActivity.class,bundle,001);
        }
        handler.removeMessages(HIDE_MEDIACONTROL);
        handler.sendEmptyMessageDelayed(HIDE_MEDIACONTROL, 5000);
    }
    protected void toClass(Context context, Class clazz, Bundle bundle, int reuqestCode){
        Intent intent = new Intent(context,clazz);
        intent.putExtras(bundle);
        startActivityForResult(intent,reuqestCode);
    }
    /**
     * 弹出切换播放器的对话框
     */
    private void showSwichPlayerDialog() {
        AlertDialog.Builder builder = new  AlertDialog.Builder(this);
        builder.setTitle("是否切换播放器");
        builder.setMessage("当前播放是系统播放器播放视频，是否切换到万能播放器播放");
        builder.setNegativeButton("取消", null);
        builder.setPositiveButton("切换", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                startVitamioPlayer();
            }
        });
        builder.show();

    }

    private void switchVideoSize() {
        if (isScreenFull) {
            //设置为默认
            setVideoType(SCREEN_DEFAULT);
        } else {
            //设置全屏
            setVideoType(SCREEN_FULL);
        }
    }

    private void startAndPause() {
        if (videoview.isPlaying()) {
            //暂停
            videoview.pause();
            //按钮状态设置为播放
            btnVideoStartPause.setBackgroundResource(R.drawable.btn_video_start_selector);
        } else {
            //播放状态
            videoview.start();
            //按钮状态设置暂停
            btnVideoStartPause.setBackgroundResource(R.drawable.btn_video_pause_selector);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
        if (!videoview.isPlaying()) {
            //播放状态
            videoview.start();
            //按钮状态设置暂停
            btnVideoStartPause.setBackgroundResource(R.drawable.btn_video_pause_selector);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
        if (videoview.isPlaying()) {
            //暂停
            videoview.pause();
            //按钮状态设置为播放
            btnVideoStartPause.setBackgroundResource(R.drawable.btn_video_start_selector);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");

    }

    @Override
    protected void onDestroy() {

        Log.e(TAG, "onDestroy");
        isActivityDestroy = true;

        if (receiver != null) {
            unregisterReceiver(receiver);
            receiver = null;
        }
        ///数据集合释放
        handler.removeCallbacksAndMessages(null);

        super.onDestroy();


    }


    private String file;
    private String filename;
    private String coursewareId;
    private MyOkHttp mMyOkhttp;
    protected Dialog mLoadingDialog = null;
    private Entity loginInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");
        mLoadingDialog = DialogHelper.getLoadingDialog(this);
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        file = ROOTURL+getIntent().getStringExtra("file");
        filename = getIntent().getStringExtra("fileName");
        coursewareId = getIntent().getStringExtra("id");
        Log.e("TAG","file:"+file+"--fileName:"+filename);
        initData();
        findViews();
//        getData();
        setListener();
        setData();
    }


    class VideoOnInfoListener implements MediaPlayer.OnInfoListener {

        @Override
        public boolean onInfo(MediaPlayer mp, int what, int extra) {
//          switch (what){
//              case MediaPlayer.MEDIA_INFO_BUFFERING_START://视频卡了，拖动卡
//                  ll_buffering.setVisibility(View.VISIBLE);
//                  break;
//              case MediaPlayer.MEDIA_INFO_BUFFERING_END://视频卡结束，视频拖动卡结束
//                  ll_buffering.setVisibility(View.GONE);
//                  break;
//          }
            return true;
        }
    }

    class VoiceOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                updatavolumeProgress(progress);
            }

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
            handler.removeMessages(HIDE_MEDIACONTROL);
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            handler.sendEmptyMessageDelayed(HIDE_MEDIACONTROL, 5000);
        }
    }

    /**
     * 调节音量
     *
     * @param volume
     */
    private void updatavolume(int volume) {
        if (isMute) {
            //设置没有音量
            am.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
            seekbarVoice.setProgress(0);
        } else {
            am.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
            seekbarVoice.setProgress(volume);
            currentVolume = volume;
        }
    }

    private void updatavolumeProgress(int volume) {
        am.setStreamVolume(AudioManager.STREAM_MUSIC, volume, 0);
        seekbarVoice.setProgress(volume);
        currentVolume = volume;
    }

    class VideoOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

        /**
         * @param seekBar
         * @param progress 视频要拖动到的位置
         * @param fromUser 当状态改变是由用户引起的时候，这个值为true,默认为false
         */
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser) {
                videoview.seekTo(progress);
            }

        }

        /**
         * 当手一触碰的时候回调这个方法
         */

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        /**
         * 手指离开屏幕的时候，回调这个方法
         *
         * @param seekBar
         */
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }


//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
//            showTimeOutDialog(true, "1");
////            Message msg = new Message();
////            msg.what = 0;
////            handlerStopTime.sendMessage(msg);
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    // 弹出对话框通知用户答题时间到
    protected void showTimeOutDialog(final boolean flag, final String backtype) {
        final Dialog builder = new Dialog(this,R.style.mydialog);

        builder.setContentView(R.layout.my_dialog);
        TextView title = (TextView) builder.findViewById(R.id.dialog_title);
        TextView content = (TextView) builder.findViewById(R.id.dialog_content);
        if(backtype.equals("1")){
            content.setText("您要结束本次学习吗？:"+videoview.getCurrentPosition()/1000);
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
//                    finish();

                    //上传学习时间

                    Log.e("TAG","上传时间");
                    upDataprogress();
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

    private void upDataprogress() {

        int CurrentPosition = videoview.getCurrentPosition() / 1000;
        int Duration = videoview.getDuration()/ 1000;

        // 创建一个数值格式化对象
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(0);
        String result = numberFormat.format((float)CurrentPosition/(float)Duration*100);

        Log.e("TAG","当前时间："+CurrentPosition+"总时长："+Duration+"比值："+result);

        showLoadingDialog("正在提交学习进度");
        Log.e("TAG","memberId："+loginInfo.getData().getId()+"coursewareId："+coursewareId+"比值："+result);
        JSONObject jsonObject = new JSONObject();
//        {"memberId":"8ef0da67b0ee4d98ad70b91c2f653617","coursewareId":"e229809ead984abfa02e1555912e3bb4","studyState":"50"}
        try {
            jsonObject.put("memberId", loginInfo.getData().getId());
            jsonObject.put("coursewareId", coursewareId);
            jsonObject.put("studyState", result);
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

    private void startTime() {
        Log.e(TAG, "onResume");
        if (!videoview.isPlaying()) {
            //播放状态
            videoview.start();
            //按钮状态设置暂停
            btnVideoStartPause.setBackgroundResource(R.drawable.btn_video_pause_selector);
        }
    }

    private void stopTime(){
        Log.e(TAG, "onPause");
        if (videoview.isPlaying()) {
            //暂停
            videoview.pause();
            //按钮状态设置为播放
            btnVideoStartPause.setBackgroundResource(R.drawable.btn_video_start_selector);
        }

    }


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

}
