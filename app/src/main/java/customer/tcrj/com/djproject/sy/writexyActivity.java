package customer.tcrj.com.djproject.sy;

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

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.BindView;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.checkUpdata.SweetAlertDialog;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.widget.DialogDateTimePicker;

public class writexyActivity extends BaseActivity {

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;


    @BindView(R.id.btn_send)
    Button btn_send;

    @BindView(R.id.edt_search_result)
    EditText edittitle;


    @BindView(R.id.content)
    EditText content;

    private MyOkHttp mMyOkhttp;

    @Override
    protected int setLayout() {
        return R.layout.activity_writexy;
    }

    @Override
    protected void setView() {
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        txtTitle.setText("写心愿");
        btnback.setOnClickListener(this);
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

            case R.id.btn_send:
                String title = edittitle.getText().toString();
                String scontent = content.getText().toString();

                Log.e("TAG","---stvtime:"+title+"---scontent:"+scontent);

                if(title.equals("") || scontent.equals("") ){
                    Toast.makeText(this, "请将信息填写完整", Toast.LENGTH_SHORT).show();
                }else{
                    toSend(scontent,title);
                }

                break;

        }
    }

    private void toSend(String content, String title) {
        showLoadingDialog("正在登陆...");

        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("content", content);
            jsonObject.put("title", title);
//            jsonObject.put("username", "zs");
//            jsonObject.put("password", "123456");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.xyinfosendApi)
                .jsonParams(jsonObject.toString())
                .tag(this)
                .enqueue(new GsonResponseHandler<Entity>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        hideLoadingDialog();
                        showUpdateDialog("发布失败",2);
                        Log.e("TAG","msg"+statusCode);
                    }

                    @Override
                    public void onSuccess(int statusCode, Entity response) {
                        hideLoadingDialog();
                        if(response.getErrorCode().equals("0")){
                            showUpdateDialog(response.getMessage(),2);
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
