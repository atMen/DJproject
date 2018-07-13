package customer.tcrj.com.djproject.sy;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.djproject.LoginActivity;
import customer.tcrj.com.djproject.MainActivity;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.Utils;
import customer.tcrj.com.djproject.adpater.GridImageAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.checkUpdata.SweetAlertDialog;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.widget.DialogDateTimePicker;
import customer.tcrj.com.djproject.widget.FullyGridLayoutManager;

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



    @BindView(R.id.recycler)
    RecyclerView recycler;

    private List<LocalMedia> selectList = new ArrayList<>();
    private GridImageAdapter adapter;
    private int maxSelectNum = 6;
    private int themeId;

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
        initPic();
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


    private void initPic() {
        themeId = R.style.picture_default_style;


        FullyGridLayoutManager manager = new FullyGridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(manager);
        adapter = new GridImageAdapter(this, onAddPicClickListener);
        adapter.setList(selectList);
        adapter.setSelectMax(maxSelectNum);
        recycler.setAdapter(adapter);
        adapter.setOnItemClickListener(new GridImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                if (selectList.size() > 0) {
                    LocalMedia media = selectList.get(position);
                    String pictureType = media.getPictureType();
                    int mediaType = PictureMimeType.pictureToVideo(pictureType);
                    switch (mediaType) {
                        case 1:
                            // 预览图片 可自定长按保存路径
                            //PictureSelector.create(MainActivity.this).themeStyle(themeId).externalPicturePreview(position, "/custom_file", selectList);
                            PictureSelector.create(releaseActivity.this).themeStyle(themeId).openExternalPreview(position, selectList);
                            break;
                        case 2:
                            // 预览视频
                            PictureSelector.create(releaseActivity.this).externalPictureVideo(media.getPath());
                            break;
                        case 3:
                            // 预览音频
                            PictureSelector.create(releaseActivity.this).externalPictureAudio(media.getPath());
                            break;
                    }
                }
            }
        });
    }



    private GridImageAdapter.onAddPicClickListener onAddPicClickListener = new GridImageAdapter.onAddPicClickListener() {
        @Override
        public void onAddPicClick() {
            // 进入相册 以下是例子：不需要的api可以不写
            PictureSelector.create(releaseActivity.this)
                    .openGallery(PictureMimeType.ofImage())// 全部.PictureMimeType.ofAll()、图片.ofImage()、视频.ofVideo()、音频.ofAudio()
                    .theme(themeId)// 主题样式设置 具体参考 values/styles   用法：R.style.picture.white.style
                    .maxSelectNum(maxSelectNum)// 最大图片选择数量
                    .minSelectNum(1)// 最小选择数量
                    .imageSpanCount(3)// 每行显示个数
                    .selectionMode(PictureConfig.MULTIPLE)// 多选 or 单选
                    .previewImage(true)// 是否可预览图片
                    .isCamera(true)// 是否显示拍照按钮
                    .isZoomAnim(true)// 图片列表点击 缩放效果 默认true
                    //.imageFormat(PictureMimeType.PNG)// 拍照保存图片格式后缀,默认jpeg
                    //.setOutputCameraPath("/CustomPath")// 自定义拍照保存路径
                    .enableCrop(false)// 是否裁剪
                    .compress(true)// 是否压缩
                    .synOrAsy(true)//同步true或异步false 压缩 默认同步
                    //.compressSavePath(getPath())//压缩图片保存地址
                    //.sizeMultiplier(0.5f)// glide 加载图片大小 0~1之间 如设置 .glideOverride()无效
                    .glideOverride(160, 160)// glide 加载宽高，越小图片列表越流畅，但会影响列表图片浏览的清晰度
                    .hideBottomControls(false)// 是否显示uCrop工具栏，默认不显示
                    .isGif(false)// 是否显示gif图片
                    .freeStyleCropEnabled(true)// 裁剪框是否可拖拽
                    .openClickSound(false)// 是否开启点击声音
                    .selectionMedia(selectList)// 是否传入已选图片
                    //.isDragFrame(false)// 是否可拖动裁剪框(固定)
//                        .videoMaxSecond(15)
//                        .videoMinSecond(10)
                    //.previewEggs(false)// 预览图片时 是否增强左右滑动图片体验(图片滑动一半即可看到上一张是否选中)
                    //.cropCompressQuality(90)// 裁剪压缩质量 默认100
                    .minimumCompressSize(100)// 小于100kb的图片不压缩
                    //.cropWH()// 裁剪宽高比，设置如果大于图片本身宽高则无效
                    //.rotateEnabled(true) // 裁剪是否可旋转图片
                    //.scaleEnabled(true)// 裁剪是否可放大缩小图片
                    //.videoQuality()// 视频录制质量 0 or 1
                    //.videoSecond()//显示多少秒以内的视频or音频也可适用
                    //.recordVideoSecond()//录制视频秒数 默认60s
                    .forResult(PictureConfig.CHOOSE_REQUEST);//结果回调onActivityResult code
        }

    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true
                    // 如果裁剪并压缩了，已取压缩路径为准，因为是先裁剪后压缩的
                    for (LocalMedia media : selectList) {
                        Log.i("原图片-----》", media.getPath());
                        Log.i("压缩图片-----》", media.getCompressPath());
                        //1.4M可压缩到500多K
                    }
                    adapter.setList(selectList);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }
}
