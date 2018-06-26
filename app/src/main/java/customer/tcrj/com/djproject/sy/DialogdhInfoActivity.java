package customer.tcrj.com.djproject.sy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.adpater.dialogactivityAdapter;
import customer.tcrj.com.djproject.bean.dhInfo;
import customer.tcrj.com.djproject.bean.msgInfo;
import customer.tcrj.com.djproject.bean.plInfo;

public class DialogdhInfoActivity extends Activity implements View.OnClickListener {
    private ImageView iv_close;
    private TextView title,name;
    private TextView time,endtime,type,df;

    private dialogactivityAdapter detailAdapter;


    private dhInfo.DataBean.ContentBean response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dh_dialog);
        response = (dhInfo.DataBean.ContentBean) getIntent().getSerializableExtra("msgInfo");
        findview();
        initview();
    }

    private void initview() {


    }

    private void findview() {

        iv_close = (ImageView) findViewById(R.id.iv_close);


        title = (TextView) findViewById(R.id.title);
        name = (TextView) findViewById(R.id.name);
        time = (TextView) findViewById(R.id.time);
        endtime = (TextView) findViewById(R.id.endtime);
        type = (TextView) findViewById(R.id.type);
        df = (TextView) findViewById(R.id.df);


        iv_close.setOnClickListener(this);

        if(response != null){

            name.setText("活动名称："+response.getName());
            time.setText("开始时间："+response.getStartime());
            endtime.setText("结束时间："+response.getEndtime());
            title.setText(response.getContent());
            df.setText("活动得分："+response.getCredit()+"分");

            String eventype = response.getEventype();

            if (eventype.equals("14101")) {
                type.setText("活动类型：支部党员大会");
            }else if(eventype.equals("14102")){
                type.setText("活动类型：支部党员会");
            }else if(eventype.equals("14103")){
                type.setText("活动类型：党小组会");
            }else if(eventype.equals("14104")){
                type.setText("活动类型：党课");
            }else{
                type.setText("活动类型：组织生活");
            }
        }



    }

    @Override
    public void onClick(View v) {
         finish();

    }




}
