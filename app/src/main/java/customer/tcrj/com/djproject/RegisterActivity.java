package customer.tcrj.com.djproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.Utils.AppManager;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.net.ApiConstants;


public class RegisterActivity extends BaseActivity {

    @BindView(R.id.edt_Account)
    public EditText edt_Account;

    @BindView(R.id.edt_name)
    public EditText edt_name;

    @BindView(R.id.edt_phone)
    public EditText edt_phone;

    @BindView(R.id.edt_sfz)
    public EditText edt_sfz;

    @BindView(R.id.edt_Password)
    public EditText edt_Password;

    @BindView(R.id.edt_Password2)
    public EditText edt_Password2;

    @BindView(R.id.btn_true)
    public Button btn_true;

    @BindView(R.id.txtTitle)
    public TextView txtTitle;

    @BindView(R.id.btnback)
    public ImageView btnback;


    private MyOkHttp mMyOkhttp;

    @Override
    protected int setLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void setView() {
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        btn_true.setOnClickListener(this);
        btnback.setOnClickListener(this);
        txtTitle.setText("注册");
    }

    @Override
    protected void setData() {
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_true:
                isOk();
                break;
            case R.id.btnback:
                finish();
                break;
        }
    }



    public void getDataFromNet(String psw1, String psw2, String name, String phone, String sfz) {
        showLoadingDialog("正在注册...");

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("username", name);
            jsonObject.put("idEntityCard", sfz);
            jsonObject.put("account", psw1);

            jsonObject.put("mobile", phone);
            jsonObject.put("password", psw2);
            jsonObject.put("rePassword", psw2);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.registerApi)
                .jsonParams(jsonObject.toString())
                .tag(this)
                .enqueue(new GsonResponseHandler<Entity>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        hideLoadingDialog();
                        Toast.makeText(RegisterActivity.this, error_msg, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(int statusCode, Entity response) {
                        hideLoadingDialog();
                        Log.e("TAG","response:"+response.toString());
                        String errorCode = response.getErrorCode();
                        Toast.makeText(RegisterActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();
                        if(errorCode.equals("0")){

                            toClass(RegisterActivity.this,LoginActivity.class);
                            AppManager.getAppManager().finishAllActivity();

                        }



                    }
                });
    }

    //信息输入是否符合规格
    private void isOk() {
        String psw1 = edt_Account.getText().toString();
        String psw2 = edt_Password.getText().toString();
        String psw3 = edt_Password2.getText().toString();
        String name = edt_name.getText().toString();
        String phone = edt_phone.getText().toString();
        String sfz = edt_sfz.getText().toString();

        if(psw2.equals(psw3)){
            if(psw1.equals("") || psw2.equals("") || psw3.equals("") || name.equals("") || phone.equals("") || sfz.equals("")){
                Toast.makeText(this, "请将数据填写完整", Toast.LENGTH_SHORT).show();
            }else{
                getDataFromNet(psw1,psw2,name,phone,sfz);
            }
        }else {
            Toast.makeText(this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        mMyOkhttp.cancel(this);
        super.onDestroy();
    }
}
