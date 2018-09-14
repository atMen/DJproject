package customer.tcrj.com.djproject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.githang.statusbar.StatusBarCompat;
import com.google.gson.Gson;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.tsy.sdk.myokhttp.response.JsonResponseHandler;
import com.tsy.sdk.myokhttp.util.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;


import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.Utils.AndroidBug5497Workaround;
import customer.tcrj.com.djproject.Utils.DialogHelper;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.loginBean;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.widget.VerificationCodeView;


public class LoginActivity extends FragmentActivity implements View.OnClickListener {


    private ImageView logo;
    private ScrollView scrollView;
    private EditText et_mobile;
    private EditText et_password,et_yzm;
    private ImageView iv_clean_phone;
    private ImageView clean_password;
    private ImageView iv_show_pwd;
    private Button btn_login;
    private LinearLayout ll_zc;
    private TextView forget_password;

    protected Dialog mLoadingDialog = null;

    private int screenHeight = 0;//屏幕高度
    private int keyHeight = 0; //软件盘弹起后所占高度
    private float scale = 0.6f; //logo缩放比例
    private View content;
    private int height = 0 ;

    private MyOkHttp mMyOkhttp;
    VerificationCodeView mVerificationCodeView;

    private String psw;
    private String username;
    private String isfirst;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.white), true);


        psw =  ACache.get(this).getAsString("psw");
        isfirst =  ACache.get(this).getAsString("isfirst");
        username =  ACache.get(this).getAsString("username");



        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        if(isFullScreen(this)){
            AndroidBug5497Workaround.assistActivity(this);
        }
        mLoadingDialog = DialogHelper.getLoadingDialog(this);
        initView();
        initListener();
    }

    public boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags &
                WindowManager.LayoutParams.FLAG_FULLSCREEN)==WindowManager.LayoutParams.FLAG_FULLSCREEN;
    }

    private void initView() {
        ll_zc = (LinearLayout)findViewById(R.id.ll_zc);
        logo = (ImageView) findViewById(R.id.logo);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        et_mobile = (EditText) findViewById(R.id.et_mobile);
        et_password = (EditText) findViewById(R.id.et_password);
        et_yzm = (EditText) findViewById(R.id.et_yzm);
        forget_password = (TextView) findViewById(R.id.forget_password);

        iv_clean_phone = (ImageView) findViewById(R.id.iv_clean_phone);
        clean_password = (ImageView) findViewById(R.id.clean_password);
        iv_show_pwd = (ImageView) findViewById(R.id.iv_show_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        content = findViewById(R.id.content);

        mVerificationCodeView= (VerificationCodeView) findViewById(R.id.verification_code);

        screenHeight = this.getResources().getDisplayMetrics().heightPixels; //获取屏幕高度
        keyHeight = screenHeight / 3;//弹起高度为屏幕高度的1/3

        forget_password.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );


        if(username != null && psw != null){
            et_mobile.setText(username);
            et_password.setText(psw);

                if(!"isfirst".equals(isfirst)){
                    toLogin(username,psw,psw);
                }

        }
    }

    private void initListener() {
        ll_zc.setOnClickListener(this);
        btn_login.setOnClickListener(this);
        iv_clean_phone.setOnClickListener(this);
        clean_password.setOnClickListener(this);
        iv_show_pwd.setOnClickListener(this);
        et_mobile.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && iv_clean_phone.getVisibility() == View.GONE) {
                    iv_clean_phone.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    iv_clean_phone.setVisibility(View.GONE);
                }
            }
        });
        et_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s) && clean_password.getVisibility() == View.GONE) {
                    clean_password.setVisibility(View.VISIBLE);
                } else if (TextUtils.isEmpty(s)) {
                    clean_password.setVisibility(View.GONE);
                }
                if (s.toString().isEmpty())
                    return;
                if (!s.toString().matches("[A-Za-z0-9]+")) {
                    String temp = s.toString();
                    Toast.makeText(LoginActivity.this, R.string.please_input_limit_pwd, Toast.LENGTH_SHORT).show();
                    s.delete(temp.length() - 1, temp.length());
                    et_password.setSelection(s.length());
                }
            }
        });
        /**
         * 禁止键盘弹起的时候可以滚动
         */
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        scrollView.addOnLayoutChangeListener(new ViewGroup.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
              /* old是改变前的左上右下坐标点值，没有old的是改变后的左上右下坐标点值
              现在认为只要控件将Activity向上推的高度超过了1/3屏幕高，就认为软键盘弹起*/
                if (oldBottom != 0 && bottom != 0 && (oldBottom - bottom > keyHeight)) {
                    Log.e("wenzhihao", "up------>"+(oldBottom - bottom));
                    int dist = content.getBottom() - bottom;
                    if (dist>0){
                        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(content, "translationY", 0.0f, -dist);
                        mAnimatorTranslateY.setDuration(300);
                        mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
                        mAnimatorTranslateY.start();
                        zoomIn(logo, dist);
                    }

                } else if (oldBottom != 0 && bottom != 0 && (bottom - oldBottom > keyHeight)) {
                    Log.e("wenzhihao", "down------>"+(bottom - oldBottom));
                    if ((content.getBottom() - oldBottom)>0){
                        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(content, "translationY", content.getTranslationY(), 0);
                        mAnimatorTranslateY.setDuration(300);
                        mAnimatorTranslateY.setInterpolator(new LinearInterpolator());
                        mAnimatorTranslateY.start();
                        //键盘收回后，logo恢复原来大小，位置同样回到初始位置
                        zoomOut(logo);
                    }
                }
            }
        });
    }

    /**
     * 缩小
     * @param view
     */
    public void zoomIn(final View view, float dist) {
        view.setPivotY(view.getHeight());
        view.setPivotX(view.getWidth() / 2);
        AnimatorSet mAnimatorSet = new AnimatorSet();
        ObjectAnimator mAnimatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, scale);
        ObjectAnimator mAnimatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, scale);
        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(view, "translationY", 0.0f, -dist);

        mAnimatorSet.play(mAnimatorTranslateY).with(mAnimatorScaleX);
        mAnimatorSet.play(mAnimatorScaleX).with(mAnimatorScaleY);
        mAnimatorSet.setDuration(300);
        mAnimatorSet.start();
    }

    /**
     * f放大
     * @param view
     */
    public void zoomOut(final View view) {
        view.setPivotY(view.getHeight());
        view.setPivotX(view.getWidth() / 2);
        AnimatorSet mAnimatorSet = new AnimatorSet();

        ObjectAnimator mAnimatorScaleX = ObjectAnimator.ofFloat(view, "scaleX", scale, 1.0f);
        ObjectAnimator mAnimatorScaleY = ObjectAnimator.ofFloat(view, "scaleY", scale, 1.0f);
        ObjectAnimator mAnimatorTranslateY = ObjectAnimator.ofFloat(view, "translationY", view.getTranslationY(), 0);

        mAnimatorSet.play(mAnimatorTranslateY).with(mAnimatorScaleX);
        mAnimatorSet.play(mAnimatorScaleX).with(mAnimatorScaleY);
        mAnimatorSet.setDuration(300);
        mAnimatorSet.start();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.iv_clean_phone:
                et_mobile.setText("");
                break;
            case R.id.ll_zc:
                toClass(LoginActivity.this,RegisterActivity.class);

                break;
            case R.id.clean_password:
                et_password.setText("");
                break;
            case R.id.iv_show_pwd:
                if (et_password.getInputType() != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) {
                    et_password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    iv_show_pwd.setImageResource(R.drawable.eye);
                } else {
                    et_password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    iv_show_pwd.setImageResource(R.drawable.dl01_12);
                }
                String pwd = et_password.getText().toString();
                if (!TextUtils.isEmpty(pwd))
                    et_password.setSelection(pwd.length());
                break;

            case R.id.btn_login:

                String user = et_mobile.getText().toString();
                String psw = et_password.getText().toString();
                String yzm = et_yzm.getText().toString();

//                toClass(LoginActivity.this,DwglActivity.class);
                if (TextUtils.isEmpty(psw) || TextUtils.isEmpty(user) || TextUtils.isEmpty(yzm) ){
                    Toast.makeText(this, "账号密码错误", Toast.LENGTH_SHORT).show();
                }else{

                    if(mVerificationCodeView.getVerificationCode().equals(yzm)){
//                        Toast.makeText(LoginActivity.this,"验证成功",Toast.LENGTH_SHORT).show();

                        toLogin(user,psw,yzm);
                    }else {
                        Toast.makeText(LoginActivity.this,"验证码失败",Toast.LENGTH_SHORT).show();
                    }

                }
                break;

            default:
                break;
        }
    }

    //联网进行登录
    private void toLogin(final String user, final String psw, String yzm) {
        showLoadingDialog("正在登录...");

        JSONObject jsonObject = new JSONObject();

        Log.e("TAG","username:"+user+"---psw:"+psw);
        try {
            jsonObject.put("username", user);
            jsonObject.put("password", psw);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.loginApi)
                .jsonParams(jsonObject.toString())
                .tag(this)
                .enqueue(new JsonResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, JSONObject response) {
                        Log.d("TAG", "doPost onSuccess:" + response);
                        hideLoadingDialog();
                        ACache.get(LoginActivity.this).put("isfirst","no");
                        gsonData(response,psw,user);
                    }

                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        hideLoadingDialog();
                        Log.d("TAG", "doPost onFailure:" + error_msg);
                        Toast.makeText(LoginActivity.this, error_msg, Toast.LENGTH_SHORT).show();
                    }
                });


//                .enqueue(new GsonResponseHandler<Entity>() {
//                    @Override
//                    public void onFailure(int statusCode, String error_msg) {
//
//                        hideLoadingDialog();
//                        Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
//                        Log.e("TAG","msg"+error_msg);
//                    }
//
//                    @Override
//                    public void onSuccess(int statusCode, Entity response) {
//                        hideLoadingDialog();
//                        Toast.makeText(LoginActivity.this,response.getMessage(), Toast.LENGTH_SHORT).show();
//                        if(response.getErrorCode().equals("0")){
//                            Log.e("TAG","成功");
//                            ToCache(response,psw);
//                            toClass(LoginActivity.this,MainActivity.class);
//                            finish();
//                        }
//                    }
//                });
    }

    private void gsonData(JSONObject response, String psw, String username) {

        Gson gson = new Gson();
        try {

            final Entity gsonResponse = (Entity) gson.fromJson(response.toString(), Entity.class);
            if(gsonResponse.getErrorCode().equals("0")){
                            Log.e("TAG","成功");
                            ToCache(gsonResponse,psw,username);
                            toClass(LoginActivity.this,MainActivity.class);
                            finish();
                        }


        } catch (Exception e) {
            e.printStackTrace();

            final loginBean gsonResponse = (loginBean) gson.fromJson(response.toString(), loginBean.class);
            Toast.makeText(LoginActivity.this,gsonResponse.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    //缓存数据
    private void ToCache(Entity response, String psw, String username) {
        ACache.get(this).put("psw",psw);
        ACache.get(this).put("username",username);
        ACache.get(this).put("loginInfo",response);
    }

    protected void toClass(Context context, Class clazz){

        Intent intent = new Intent(context,clazz);

        startActivity(intent);
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


    @Override
    protected void onDestroy() {
        mMyOkhttp.cancel(this);
        super.onDestroy();

    }
}
