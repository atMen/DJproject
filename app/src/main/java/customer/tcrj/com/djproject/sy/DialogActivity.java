package customer.tcrj.com.djproject.sy;

import android.app.Activity;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.adpater.dialogactivityAdapter;
import customer.tcrj.com.djproject.adpater.spplAdapter;
import customer.tcrj.com.djproject.bean.plInfo;
import customer.tcrj.com.djproject.widget.CustomLoadMoreView;

public class DialogActivity extends Activity implements View.OnClickListener, dialogactivityAdapter.OnItemClickListener {
    private RecyclerView mRecyclerView;
    private TextView bzda;
    private TextView title;
    private Button sure;
    private LinearLayout ll_btn;

    private dialogactivityAdapter detailAdapter;
    private List<plInfo.DataBean.ContentBean> beanList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findview();
        initview();
    }

    private void initview() {
        beanList = new ArrayList<>();
        plInfo.DataBean.ContentBean data = new plInfo.DataBean.ContentBean();
        plInfo.DataBean.ContentBean data1 = new plInfo.DataBean.ContentBean();

        plInfo.DataBean.ContentBean data2 = new plInfo.DataBean.ContentBean();

        plInfo.DataBean.ContentBean data3 = new plInfo.DataBean.ContentBean();


        beanList.add(data);
        beanList.add(data1);
        beanList.add(data2);
        beanList.add(data3);
//        beanList.add(data);
//        beanList.add(data1);
//        beanList.add(data2);
//        beanList.add(data3);
//        beanList.add(data);
//        beanList.add(data1);
//        beanList.add(data2);
//        beanList.add(data3);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(detailAdapter = new dialogactivityAdapter(beanList, this));
        detailAdapter.setOnItemRlClickListener(this);

    }

    private void findview() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        bzda = (TextView) findViewById(R.id.bzda);
        title = (TextView) findViewById(R.id.title);
        sure = (Button) findViewById(R.id.sure);
         ll_btn = (LinearLayout)findViewById(R.id.ll_btn);

        sure.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
         finish();

    }



    @Override
    public void OnItemClick(plInfo.DataBean.ContentBean item) {
        Log.e("TAG","item点击事件");
        ll_btn.setVisibility(View.VISIBLE);
        sure.setEnabled(true);
    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
