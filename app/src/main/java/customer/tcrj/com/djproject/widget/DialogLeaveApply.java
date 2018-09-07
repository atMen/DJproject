package customer.tcrj.com.djproject.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.chad.library.adapter.base.BaseQuickAdapter;
import com.lzy.okgo.model.Progress;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.Utils;
import customer.tcrj.com.djproject.adpater.cqryAdapter;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.LeaveApplyEntity;
import customer.tcrj.com.djproject.bean.cqryInfo;
import customer.tcrj.com.djproject.net.ApiConstants;

/**
 * 类别
 * Created by leict on 2017/11/16.
 */

public class DialogLeaveApply extends Dialog implements DialogInterface, BaseQuickAdapter.OnItemClickListener, View.OnClickListener {
    private TextView tvTitleName;
    private RecyclerView listView;
    private Button btnSure;
    private ProgressBar progress;

    private ILeaveApplyCallBack callBack;
    private View view;
    private int mDuration = -1;
    private static Context mContext;
    private boolean isCancelable = true;
    private static DialogLeaveApply instance;
    private cqryAdapter adapter;
    private Context context;

    private List<cqryInfo.DataBean> selectDatas = new ArrayList<>();//记录选中项

    private MyOkHttp mMyOkhttp;


    public DialogLeaveApply(Context context) {
        super(context, R.style.dialog_untran);
        this.context = context;
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        initView(context);
        getData();
    }

    public static DialogLeaveApply getInstance(Context context) {
        if (instance == null || !mContext.equals(context)) {
            synchronized (DialogLeaveApply.class) {
                if (instance == null || !mContext.equals(context)) {
                    instance = new DialogLeaveApply(context);
                }
            }
        }
        mContext = context;
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowManager.LayoutParams p = getWindow().getAttributes();  // 获取对话框当前的参数值
        p.width = (int) (Utils.getWidth(mContext) * 0.9);            // 宽度设置为屏幕的0.8
        p.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getWindow().setAttributes(p);
    }

    private void initView(Context context) {
        view = View.inflate(context, R.layout.dialog_spinner_leaveapply, null);
        tvTitleName = (TextView) view.findViewById(R.id.spinner_title);
        progress = (ProgressBar) view.findViewById(R.id.recycler_view_progress);
        listView = (RecyclerView) view.findViewById(R.id.recycler_view);
        btnSure = (Button) view.findViewById(R.id.btn_sure);
        this.setCanceledOnTouchOutside(false);
        setContentView(view);
        btnSure.setOnClickListener(this);
        listView.setLayoutManager(new LinearLayoutManager(context));
    }

    public DialogLeaveApply setDuration(int duration) {
        this.mDuration = duration;
        return this;
    }

    public DialogLeaveApply setTitleName(CharSequence msg) {
        tvTitleName.setText(msg);
        return this;
    }


    @Override
    public void dismiss() {
        super.dismiss();
    }



    public void getData() {

        progress.setVisibility(View.VISIBLE);
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("memberId", "10f6e9137ee14b37af4b199032102178");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.cqrylistApi)
                .jsonParams(jsonObject.toString())
                .tag(this)
                .enqueue(new GsonResponseHandler<cqryInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        progress.setVisibility(View.GONE);
                        Log.e("TAG","msg"+statusCode);
                    }

                    @Override
                    public void onSuccess(int statusCode, cqryInfo response) {
                        progress.setVisibility(View.GONE);
                        if(response.getErrorCode().equals("0")){
                            setData(response.getData());
                        }
                    }
                });



    }


    private void setData(List<cqryInfo.DataBean> data){

        adapter = new cqryAdapter(data,context);
        adapter.setOnItemClickListener(this);
        listView.setAdapter(adapter);
    }


    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        cqryInfo.DataBean bean = (cqryInfo.DataBean) adapter.getItem(position);
        if(!bean.isselect()){
            bean.setIsselect(true);
            selectDatas.add(bean);
        }else {
            bean.setIsselect(false);
            selectDatas.remove(bean);
        }
        adapter.notifyItemChanged(position);
    }


    public void setOnItemClickListener(ILeaveApplyCallBack callBack) {
        this.callBack = callBack;
    }

    @Override
    public void onClick(View v) {
        if (callBack != null) {
            callBack.setOnItemListener(selectDatas);
            dismiss();
        }
    }

    public interface ILeaveApplyCallBack {
        void setOnItemListener(List<cqryInfo.DataBean> selectDatas);
    }
}