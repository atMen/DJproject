package customer.tcrj.com.djproject.mine;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.adpater.dialogactivityAdapter;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.MessageEvent;
import customer.tcrj.com.djproject.bean.msgInfo;
import customer.tcrj.com.djproject.bean.plInfo;

public class DialogCRActivity extends Activity implements View.OnClickListener {

    private ImageView iv_close;
    private TextView name;
    EditText title;
    Button time;

   String cn;

    private Entity.DataBeanX.DataBean response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_cr);
        response = (Entity.DataBeanX.DataBean) getIntent().getSerializableExtra("cn");
        cn = response.getMyPromise();
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

        }else {
            Log.e("TAG","承若信息："+s);
            response.setMyPromise(cn);
            EventBus.getDefault().post(new MessageEvent(s));
            finish();
        }

    }


}
