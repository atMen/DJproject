package customer.tcrj.com.djproject.mine;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.adpater.ExamlistAdapter;
import customer.tcrj.com.djproject.adpater.FreshNewsAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.base.NpaLinearLayoutManager;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.examlistInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;
import customer.tcrj.com.djproject.bean.zxdtInfo;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.sy.infoactivity.dkInfoActivity;
import customer.tcrj.com.djproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;


public class ExamListActivity extends BaseActivity implements FreshNewsAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;

    private MyOkHttp mMyOkhttp;
    private ExamlistAdapter detailAdapter;
    private List<zxdtInfo.DataBean.ContentBean> beanList;

    private int pageNum = 1;
    private boolean canPull = true;
    Entity loginInfo = null;

    String type;
    @Override
    protected int setLayout() {
        return R.layout.activity_dkgl;
    }

    @Override
    protected void setView() {
        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        type = getIntent().getStringExtra("type");
        mPtrFrameLayout.disableWhenHorizontalMove(true);
        txtTitle.setText("考试列表");
        btnback.setOnClickListener(this);
        mPtrFrameLayout.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {

                if(!canPull){
                    return false;
                }
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mRecyclerView, header);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                pageNum = 1;
                getData(pageNum);

            }
        });
        beanList = new ArrayList<>();
        mRecyclerView.setLayoutManager(new NpaLinearLayoutManager(this));
        mRecyclerView.setAdapter(detailAdapter = new ExamlistAdapter(beanList, ExamListActivity.this));
        detailAdapter.setPreLoadNumber(1);
        detailAdapter.setLoadMoreView(new CustomLoadMoreView());
        detailAdapter.setEnableLoadMore(true);
        detailAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        detailAdapter.setOnItemClickListener(this);
        detailAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.e("TAG","点击重新加载数据");
                getData(pageNum);
            }
        }, mRecyclerView);

    }

    @Override
    protected void onResume() {
        super.onResume();
        getData(1);
    }

    //错误页面的点击回调，重新加载数据
    @Override
    public void onRetry() {
        getData(pageNum);
    }

    @Override
    protected void setData() {
//        getData(pageNum);
    }



    //获取网络数据
    private void getData(final int num) {

    JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("page", num+"");
            jsonObject.put("size", "30");
            jsonObject.put("memberId", loginInfo.getData().getData().getId());

    } catch (JSONException e) {
        e.printStackTrace();
    }

//                    .url( (type.equals("0"))? ApiConstants.examyklistApi : ApiConstants.examwklistApi )


        mMyOkhttp.post()
                .url( (type.equals("0"))? ApiConstants.examyklistApi : ApiConstants.examwklistApi)
                .jsonParams(jsonObject.toString())
                .tag(this)
            .enqueue(new GsonResponseHandler<zxdtInfo>() {
        @Override
        public void onFailure(int statusCode, String error_msg) {

            Toast.makeText(ExamListActivity.this, error_msg, Toast.LENGTH_SHORT).show();

            if(num > 1){
                loadMoreData(null,true);
            }else{
                loadData(null,true);

            }
        }

        @Override
        public void onSuccess(int statusCode, zxdtInfo response) {
//      Toast.makeText(mContext, response.getMessage(), Toast.LENGTH_SHORT).show();

            if("0".equals(response.getErrorCode())){

                if(num > 1){//上拉加载
                    loadMoreData(response,false);
                }else{//下拉刷新
                    loadData(response.getData().getContent(),false);
                }

            }



        }
    });

}

    //上拉加载更多数据
    private void loadMoreData(zxdtInfo response,boolean isError) {
        Log.e("TAG","loadMoreData");
        if (response == null) {
            Log.e("TAG","response == null:");
            if(isError){
                detailAdapter.loadMoreFail();
                Toast.makeText(this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
            }else{
                detailAdapter.loadMoreFail();
            }

        } else {

            if(pageNum > response.getData().getTotalPages()){//没有更多数据


                detailAdapter.loadMoreFail();


//          Toast.makeText(mContext, getResources().getString(R.string.data_nomore), Toast.LENGTH_SHORT).show();
            }else{
                List<zxdtInfo.DataBean.ContentBean> content = response.getData().getContent();
                Log.e("TAG","content:"+content.size());
                pageNum++;

                detailAdapter.addData(content);


                detailAdapter.loadMoreComplete();
            }

        }




    }

    //下拉刷新
    private void loadData(List<zxdtInfo.DataBean.ContentBean> response,boolean isError) {

        if (response == null  || response.size() <= 0) {
            if(mPtrFrameLayout != null){
                mPtrFrameLayout.refreshComplete();
            }
            if(isError){
//                Toast.makeText(flfgListActivity.this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
                showFaild();
            }else{
                showEmptyView();
            }
            canPull = false;

        } else {

            canPull = true;
            pageNum++;
            detailAdapter.setNewData(response);
            if(mPtrFrameLayout != null){
                mPtrFrameLayout.refreshComplete();
            }
            showSuccess();
            disableLoadMoreIfNotFullPage(mRecyclerView,response.size());
        }
    }


    public void disableLoadMoreIfNotFullPage(RecyclerView recyclerView, final int size) {
        detailAdapter.setEnableLoadMore(false);
        if (recyclerView == null) return;
        RecyclerView.LayoutManager manager = recyclerView.getLayoutManager();
        if (manager == null) return;
        if (manager instanceof LinearLayoutManager) {
            final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) manager;

            recyclerView.postDelayed(new Runnable() {
                @Override
                public void run() {

                    //要等到列表显示出来才可以去获取：findLastCompletelyVisibleItemPosition
                    if ((linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1) != size) {
                        detailAdapter.setEnableLoadMore(true);
                    }

                    Log.e("TAG","测试："+(linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1));
                }
            }, 1000);



        }
    }

    @Override
    protected void onDestroy() {
        mMyOkhttp.cancel(this);
        super.onDestroy();

    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        zxdtInfo.DataBean.ContentBean response = (zxdtInfo.DataBean.ContentBean) adapter.getItem(position);
//        Log.e("TAG","h5:"+"http://192.168.20.201:8080/yldj-cms/app/exam.chtml"+"?examId="+response.getId()+"&memberId="+loginInfo.getData().getId());
        Bundle bundle1 = new Bundle();


//        Log.e("TAG","考试页面："+ApiConstants.h5xxks+response.getId());
//        bundle1.putString("url",ApiConstants.h5xxks+response.getId());
//        toClass(this,ksActivity.class,bundle1);


        String examState = response.getApproved();

        if(examState != null){
            if(examState.equals("1")){//未考试

                if(response.getStartTime() != null && response.getStartTime().equals("1")){
                    Toast.makeText(this, "正在阅卷,请稍后查看", Toast.LENGTH_SHORT).show();
                }else {
                    bundle1.putString("url",ApiConstants.h5examApi+"?memberId="+loginInfo.getData().getData().getId()+"&examId="+response.getId());
//                bundle1.putString("url",ApiConstants.h5examApi);
                    toClass(this,ksdtActivity.class,bundle1);
                }

            }else if(examState.equals("2")){//已交卷
                Toast.makeText(this, "还未阅卷,暂无法查看", Toast.LENGTH_SHORT).show();
            }else if(examState.equals("3")){//已阅卷
                bundle1.putString("url",ApiConstants.h5yyj+"?examId="+response.getId()+"&pid="+loginInfo.getData().getData().getId());
                toClass(this,ksActivity.class,bundle1);
            }
        }else {
            Toast.makeText(this, "试卷状态为空,请在pc端进行操作", Toast.LENGTH_SHORT).show();
        }



    }
}
