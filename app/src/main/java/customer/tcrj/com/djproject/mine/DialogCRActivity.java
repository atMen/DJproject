package customer.tcrj.com.djproject.mine;

import android.app.Activity;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.Utils.DialogHelper;
import customer.tcrj.com.djproject.adpater.MainMenuAdapter;
import customer.tcrj.com.djproject.adpater.dialogactivityAdapter;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.MessageEvent;
import customer.tcrj.com.djproject.bean.bzbdyInfo;
import customer.tcrj.com.djproject.bean.msgInfo;
import customer.tcrj.com.djproject.bean.plInfo;
import customer.tcrj.com.djproject.net.ApiConstants;

public class DialogCRActivity extends Activity implements View.OnClickListener {

    private ImageView iv_close;
    private TextView name;
    EditText title;
    Button time;

   String cn;
    private MyOkHttp mMyOkhttp;

    protected Dialog mLoadingDialog = null;

    private Entity.DataBeanX.DataBean response;
    private Entity loginInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_cr);

        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        response = (Entity.DataBeanX.DataBean) getIntent().getSerializableExtra("cn");
        cn = loginInfo.getData().getData().getMyPromise();
        mLoadingDialog = DialogHelper.getLoadingDialog(this);
        findview();
        initview();
    }

    private void initview() {


    }

    private void findview() {

        iv_close = (ImageView) findViewById(R.id.iv_close);
        title = (EditText) findViewById(R.id.title);
        name = (TextView) findViewById(R.id.name);
        time = (Button) findViewById(R.id.time);

        iv_close.setOnClickListener(this);
        time.setOnClickListener(this);

        if(cn != null){
            name.setText("我的承诺");
            title.setText(cn);
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.time:

                sendMsg();

                break;
            case R.id.iv_close:

                finish();
                break;
            default:
        }


    }

    private void sendMsg() {
        String s = title.getText().toString();
        if("".equals(s)){

            Toast.makeText(this, "请填写信息", Toast.LENGTH_SHORT).show();
        }else {
            Log.e("TAG","承若信息："+s);
            setPromise(s);
        }

    }

    public void setPromise(final String s) {

        showLoadingDialog("正在提交信息..");
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("id", loginInfo.getData().getData().getId());
            jsonObject.put("wdcl", s);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.setPromiseApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<bzbdyInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        hideLoadingDialog();
                        Toast.makeText(DialogCRActivity.this, "信息提交失败，请重新提交", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(int statusCode, bzbdyInfo data) {
                        Log.e("TAG","info:"+response.toString());
                        hideLoadingDialog();
                        Toast.makeText(DialogCRActivity.this, data.getMessage(), Toast.LENGTH_SHORT).show();
                        loginInfo.getData().getData().setMyPromise(s);
                        ACache.get(DialogCRActivity.this).put("loginInfo",loginInfo);
                        EventBus.getDefault().post(new MessageEvent(s));
                        finish();
                    }
                });
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
