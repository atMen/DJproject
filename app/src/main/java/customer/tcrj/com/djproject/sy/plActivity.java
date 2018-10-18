package customer.tcrj.com.djproject.sy;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.githang.statusbar.StatusBarCompat;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.adpater.spplAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.kcList;
import customer.tcrj.com.djproject.bean.kjdzInfo;
import customer.tcrj.com.djproject.bean.plInfo;

import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class plActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;
    @BindView(R.id.tv_search)
    TextView tv_search;
    @BindView(R.id.edt_pl)
    EditText edt_pl;
    @BindView(R.id.nice_video_player)
    NiceVideoPlayer mNiceVideoPlayer;

    private MyOkHttp mMyOkhttp;
    private spplAdapter detailAdapter;
    private List<plInfo.DataBean.ContentBean> beanList;

    private int pageNum = 1;
    private boolean canPull = true;
    private String memberId;
    private String playtime,minduction;
    private String studyState;
    private String courseId;
    private String file;
    private String filename;
    Entity loginInfo;

    @Override
    protected int setLayout() {

        return R.layout.activity_kjpl;
    }

    @Override
    protected void setStatusBar() {

    }

    @Override
    protected void setView() {



        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");
        file = getIntent().getStringExtra("file");
        filename = getIntent().getStringExtra("fileName");

        memberId = getIntent().getStringExtra("kcid");
        courseId = getIntent().getStringExtra("kjid");
        studyState = getIntent().getStringExtra("studyState");
        playtime = getIntent().getStringExtra("playtime");
        minduction = getIntent().getStringExtra("minduction");

        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        mPtrFrameLayout.disableWhenHorizontalMove(true);
        txtTitle.setText("视频学习");
        tv_search.setOnClickListener(this);
        btnback.setOnClickListener(this);
        init();

        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {

                if(!canPull){
                    return false;
                }
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mRecyclerView, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                pageNum = 1;
                getData(pageNum);
            }
        });
        beanList = new ArrayList<>();
//        plInfo.DataBean.ContentBean data = new plInfo.DataBean.ContentBean();
//        plInfo.DataBean.ContentBean data1 = new plInfo.DataBean.ContentBean();
//        plInfo.DataBean.ContentBean data2 = new plInfo.DataBean.ContentBean();
//        beanList.add(data);
//        beanList.add(data);
//        beanList.add(data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(detailAdapter = new spplAdapter(beanList, this));
        detailAdapter.setPreLoadNumber(1);
        detailAdapter.setLoadMoreView(new CustomLoadMoreView());
        detailAdapter.setEnableLoadMore(true);
        detailAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        detailAdapter.setOnItemClickListener(this);
        detailAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.e("TAG","点击重新加载数据");
                getData(pageNum);
            }
        }, mRecyclerView);

//        showSuccess();

    }

    //错误页面的点击回调，重新加载数据
    @Override
    public void onRetry() {
        getData(pageNum);
    }

    @Override
    protected void setData() {
        getData(pageNum);
    }
    //获取网络数据
    private void getData(final int num) {

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("coursewareId", courseId);
            jsonObject.put("page", num+"");
            jsonObject.put("size", "10");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.kcpllistApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<plInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Toast.makeText(plActivity.this, error_msg, Toast.LENGTH_SHORT).show();

                        if(num > 1){
                            loadMoreData(null,true);
                        }else{
                            loadData(null,true);

                        }
                    }

                    @Override
                    public void onSuccess(int statusCode, plInfo response) {
                        Toast.makeText(plActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();

                        if("0".equals(response.getErrorCode())){

                            if(num > 1){//上拉加载
                                loadMoreData(response,false);
                            }else{//下拉刷新
                                loadData(response.getData().getContent(),false);
                            }
                        }
                    }
                });

    }

    //上拉加载更多数据
    private void loadMoreData(plInfo response,boolean isError) {

        if (response == null) {
            if(isError){
                detailAdapter.loadMoreFail();
                Toast.makeText(this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
            }else{
                detailAdapter.loadMoreEnd(false);
            }

        } else {

            if(pageNum > response.getData().getTotalPages()){//没有更多数据
                detailAdapter.loadMoreFail();

            }else{
                List<plInfo.DataBean.ContentBean> content = response.getData().getContent();
                pageNum++;
                detailAdapter.addData(content);
                detailAdapter.loadMoreComplete();
            }

        }




    }

    //下拉刷新
    private void loadData(List<plInfo.DataBean.ContentBean> response,boolean isError) {

        if (response == null  || response.size() <= 0) {
            if(mPtrFrameLayout != null){
                mPtrFrameLayout.refreshComplete();
            }
            if(isError){
//                Toast.makeText(flfgListActivity.this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
                showFaild();
            }else{
                showEmptyView();
            }
            canPull = false;

        } else {

            canPull = true;
            pageNum++;
            detailAdapter.setNewData(response);
            mPtrFrameLayout.refreshComplete();
            showSuccess();
            disableLoadMoreIfNotFullPage(mRecyclerView,response.size());
        }
    }

    public void disableLoadMoreIfNotFullPage(RecyclerView recyclerView, final int size) {
        detailAdapter.setEnableLoadMore(false);
        if (recyclerView == null) return;
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager == null) return;
        if (manager instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) manager;

            recyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {

                    //要等到列表显示出来才可以去获取：findLastCompletelyVisibleItemPosition
                    if ((linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1) != size) {
                        detailAdapter.setEnableLoadMore(true);
                    }

                    Log.e("TAG","测试："+(linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1));
                }
            }, 1000);



        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnback:


                    showTimeOutDialog(true, "1");
                    Message msg = new Message();
                    msg.what = 0;
                    handlerStopTime.sendMessage(msg);

                break;
            case R.id.tv_search:

                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                String s = edt_pl.getText().toString();
                if(s.equals("")){
                    Toast.makeText(this, "评论内容不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    toPL(s);
                }
                break;

        }
    }

    private void toPL(String s) {
//        {"memberId":"8ef0da67b0ee4d98ad70b91c2f653617","courseId":"663a0a3b759648748467d793ab0a467e","coursewareId":"e229809ead984abfa02e1555912e3bb4","content":"测试测试测试测试"}
        JSONObject jsonObject = new JSONObject();
        Log.e("TAG","memberId:"+loginInfo.getData().getData().getId()+"---coursewareId:"+memberId+"---courseId:"+courseId+"---content:"+s);
        try {
            jsonObject.put("memberId", loginInfo.getData().getData().getId());
            jsonObject.put("coursewareId", courseId);
            jsonObject.put("courseId", memberId);
            jsonObject.put("content", s);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.kcplApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<kjdzInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Toast.makeText(plActivity.this, error_msg, Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onSuccess(int statusCode, kjdzInfo response) {
//                        Toast.makeText(plActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();

                        if(response.getErrorCode().equals("0")){

                            Log.e("TAG","成功");
                            getData(1);
                            edt_pl.setText(null);

                        }



                    }
                });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

    private Handler handlerStopTime = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
//                    Toast.makeText(TinyWindowPlayActivity.this, "弹框", Toast.LENGTH_SHORT).show();

//                    toClass(plActivity.this,DialogActivity.class);
                    Log.e("TAG","暂停播放");
                    mNiceVideoPlayer.pause();
//                    showTimeOutDialog(true, "1");
//                    long currentPosition = mNiceVideoPlayer.getCurrentPosition();
//                    Log.e("TAG","currentPosition:"+currentPosition);
//                    handlerStopTime.sendEmptyMessageDelayed(0,1000);
                    break;
                case 1:
//                    Toast.makeText(TinyWindowPlayActivity.this, "弹框", Toast.LENGTH_SHORT).show();

//                    toClass(plActivity.this,DialogActivity.class);//弹出试题框

                    break;

            }
            super.handleMessage(msg);
        }
    };

    private void init() {
//        handlerStopTime.sendEmptyMessageDelayed(1,6000);
        mNiceVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_NATIVE); // IjkPlayer or MediaPlayer
//        String videoUrl = "http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-33-30.mp4";
//        String videoUrl = "http://192.168.10.27:9134/web.files/uploadfile/ryEbiy/2018-05-02/20180502051603445.mp3";
//        videoUrl = Environment.getExternalStorageDirectory().getPath().concat("/办公室小野.mp4");
        Log.e("TAG","播放地址："+ApiConstants.FileURLROOT+file);
        mNiceVideoPlayer.setUp(ApiConstants.FileURLROOT+file, null);
//        mNiceVideoPlayer.setUp(ApiConstants.FileURLROOT+file, null);
//        mNiceVideoPlayer.setUp(videoUrl, null);


        Log.e("TAG","playtime:"+playtime);
        if(playtime != null){

            int time = 0;

            if(playtime.contains(".")){
                String[] split = playtime.split("\\.");
                String s = split[1];
                time = (int)Long.parseLong(s) * 1000;

            }else{
                 time = (int)Long.parseLong(playtime) * 1000;
            }


            if(time == 0 ){//TODO：当视频播放完成时上传playtime为-1 因为在刚打开播放器时无法获取到总时长
                //判断从哪里开始播放
                mNiceVideoPlayer.start(0);//从哪里开始播放
            }else{
                //判断从哪里开始播放
                mNiceVideoPlayer.start(time);//从哪里开始播放
                Log.e("TAG","续播:"+time);
            }
        }else{
            Log.e("TAG","playtime null");
            //判断从哪里开始播放
            mNiceVideoPlayer.start(0);//从哪里开始播放
        }



//        Log.e("TAG","当前时长Long："+Long.parseLong(playtime)+"当前时长time："+time);
        TxVideoPlayerController controller = new TxVideoPlayerController(this);
        controller.setTitle(filename);
//      controller.setLenght(6000);
//        Glide.with(this)
//                .load("http://tanzi27niu.cdsb.mobi/wps/wp-content/uploads/2017/05/2017-05-17_17-30-43.jpg")
//                .placeholder(R.drawable.img_default)
//                .crossFade()
//                .into(controller.imageView());
        mNiceVideoPlayer.setController(controller);
    }

    public void enterTinyWindow(View view) {
        if (mNiceVideoPlayer.isIdle()) {
            Toast.makeText(this, "要点击播放后才能进入小窗口", Toast.LENGTH_SHORT).show();
        } else {
            mNiceVideoPlayer.enterTinyWindow();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG","onStop");
//        NiceVideoPlayerManager.instance().releaseNiceVideoPlayer();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG","onPause");
        if (mNiceVideoPlayer.isPlaying()) {
            //暂停
            mNiceVideoPlayer.pause();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG","onResume");
//        if (!mNiceVideoPlayer.isPlaying()) {
//            //播放状态
//            mNiceVideoPlayer.restart();
//
//        }
    }

    @Override
    public void onBackPressed() {
        if (NiceVideoPlayerManager.instance().onBackPressd()) return;

        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            if (NiceVideoPlayerManager.instance().onBackPressd())
                return true;


            showTimeOutDialog(true, "1");
            Message msg = new Message();
            msg.what = 0;
            handlerStopTime.sendMessage(msg);
            return true;
        }
        return super.onKeyDown(keyCode, event);
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

                    Log.e("TAG","继续播放");
                    mNiceVideoPlayer.restart();
                    builder.dismiss();
//                    Message msg = new Message();
//                    msg.what = 1;
//                    handlerStopTime.sendMessage(msg);
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
    String result;
    private void upDataprogress() {

        int CurrentPosition = (int)mNiceVideoPlayer.getCurrentPosition() / 1000;
        int Duration = (int)mNiceVideoPlayer.getDuration()/ 1000;
        int Current = (int)mNiceVideoPlayer.getCurrentPosition();//当前播放毫秒数

        if(studyState != null || studyState.equals("100")){//是否完成课件学习
            result = "100";


        }else{//未完成学习进度

            if(minduction != null || !minduction.equals("0")) {//有时间节点

                if (CurrentPosition >= (Long.parseLong(minduction) * 60)) {//播放到达学习制定进度
                    result = "100";


                }else{

                    NumberFormat numberFormat = NumberFormat.getInstance();
                    numberFormat.setMaximumFractionDigits(0);
                    result = numberFormat.format((float)CurrentPosition/(float)Duration*100);

                }
            }else{//没有时间节点

                if (CurrentPosition >= (Long.parseLong(minduction) * 60)) {//播放到达学习制定进度
                    result = "100";
//                    Current = 0;

                }else{

                    NumberFormat numberFormat = NumberFormat.getInstance();
                    numberFormat.setMaximumFractionDigits(0);
                    result = numberFormat.format((float)CurrentPosition/(float)Duration*100);

                }
            }



        }

        if(CurrentPosition == Duration){
            Log.e("TAG","上传playtimeCurrentPosition == Duration");
            Current = 0;
        }



        Log.e("TAG","上传playtime:"+CurrentPosition+"Duration:"+Duration+"Current:"+Current);
        showLoadingDialog("正在保存学习进度");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("memberId", loginInfo.getData().getData().getId());
            jsonObject.put("coursewareId", courseId);
            jsonObject.put("playTime", Current/1000);
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
}
