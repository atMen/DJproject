package customer.tcrj.com.djproject.mine;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.adpater.dialogactivityAdapter;
import customer.tcrj.com.djproject.bean.msgInfo;
import customer.tcrj.com.djproject.bean.plInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;

public class DialogmsgActivity extends Activity implements View.OnClickListener, dialogactivityAdapter.OnItemClickListener {
    private LinearLayout ll_btn;
    private ImageView iv_close;
    private TextView title,name;
    private TextView time;

    private dialogactivityAdapter detailAdapter;
    private List<plInfo.DataBean.ContentBean> beanList;

    private String cn;

    private msgInfo.DataBean.ContentBean response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_dialog);
        response = (msgInfo.DataBean.ContentBean) getIntent().getSerializableExtra("msgInfo");
        cn = getIntent().getStringExtra("cn");
        Log.e("TAG","cninfo:"+cn);
        findview();
        initview();
    }

    private void initview() {


    }

    private void findview() {

         ll_btn = (LinearLayout)findViewById(R.id.ll_btn);
        iv_close = (ImageView) findViewById(R.id.iv_close);
        title = (TextView) findViewById(R.id.title);
        name = (TextView) findViewById(R.id.name);
        time = (TextView) findViewById(R.id.time);
        iv_close.setOnClickListener(this);

        if(response != null){
            name.setText(response.getTitle());
            title.setText(response.getContent());
            time.setText(response.getUpdateDateper());
        }

        Log.e("TAG","cn:"+cn);
        if(cn != null){
            name.setText("我的承诺");
            title.setText(cn);
        }

    }

    @Override
    public void onClick(View v) {
         finish();

    }



    @Override
    public void OnItemClick(plInfo.DataBean.ContentBean item) {
        Log.e("TAG","item点击事件");
        ll_btn.setVisibility(View.VISIBLE);
    }




}
