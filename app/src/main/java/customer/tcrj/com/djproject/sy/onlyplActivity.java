package customer.tcrj.com.djproject.sy;


import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.NiceVideoPlayerManager;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.adpater.spplAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.kjdzInfo;
import customer.tcrj.com.djproject.bean.plInfo;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class onlyplActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;
    @BindView(R.id.tv_search)
    TextView tv_search;
    @BindView(R.id.edt_pl)
    EditText edt_pl;

    private MyOkHttp mMyOkhttp;
    private spplAdapter detailAdapter;
    private List<plInfo.DataBean.ContentBean> beanList;

    private int pageNum = 1;
    private boolean canPull = true;
    private String memberId;

    private String courseId;

    Entity loginInfo;

    @Override
    protected int setLayout() {
        return R.layout.activity_onlypl;
    }

    @Override
    protected void setView() {
        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");

        memberId = getIntent().getStringExtra("memberId");
        courseId = getIntent().getStringExtra("courseId");


        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        mPtrFrameLayout.disableWhenHorizontalMove(true);
        txtTitle.setText("课件评论");
        tv_search.setOnClickListener(this);
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
//        plInfo.DataBean.ContentBean data = new plInfo.DataBean.ContentBean();
//        plInfo.DataBean.ContentBean data1 = new plInfo.DataBean.ContentBean();
//        plInfo.DataBean.ContentBean data2 = new plInfo.DataBean.ContentBean();
//        beanList.add(data);
//        beanList.add(data);
//        beanList.add(data);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(detailAdapter = new spplAdapter(beanList, this));
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

//        showSuccess();

    }

    //错误页面的点击回调，重新加载数据
    @Override
    public void onRetry() {
        getData(pageNum);
    }

    @Override
    protected void setData() {
        getData(pageNum);
    }
    //获取网络数据
    private void getData(final int num) {

        JSONObject jsonObject = new JSONObject();

        Log.e("TAG","courseId"+courseId);

        try {
            jsonObject.put("coursewareId", courseId);
            jsonObject.put("page", num+"");
            jsonObject.put("size", "20");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.kcpllistApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<plInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Toast.makeText(onlyplActivity.this, error_msg, Toast.LENGTH_SHORT).show();

                        if(num > 1){
                            loadMoreData(null,true);
                        }else{
                            loadData(null,true);

                        }
                    }

                    @Override
                    public void onSuccess(int statusCode, plInfo response) {
//                        Toast.makeText(onlyplActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();

                        Log.e("TAG","pl:"+response.toString());

                        if(response.getErrorCode().equals("0")){

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
    private void loadMoreData(plInfo response,boolean isError) {

        if (response == null) {
            if(isError){
                detailAdapter.loadMoreFail();
                Toast.makeText(this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
            }else{
                detailAdapter.loadMoreEnd(false);
            }

        } else {

            if(pageNum > response.getData().getTotalPages()){//没有更多数据
                detailAdapter.loadMoreFail();

            }else{
                List<plInfo.DataBean.ContentBean> content = response.getData().getContent();
                pageNum++;
                detailAdapter.addData(content);
                detailAdapter.loadMoreComplete();
            }

        }




    }

    //下拉刷新
    private void loadData(List<plInfo.DataBean.ContentBean> response,boolean isError) {

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
            mPtrFrameLayout.refreshComplete();
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
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnback:
                finish();
                break;
            case R.id.tv_search:
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                String s = edt_pl.getText().toString();
                if(s.equals("")){
                    Toast.makeText(this, "评论内容不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    toPL(s);
                }
                break;

        }
    }

    private void toPL(String s) {
//        {"memberId":"8ef0da67b0ee4d98ad70b91c2f653617","courseId":"663a0a3b759648748467d793ab0a467e","coursewareId":"e229809ead984abfa02e1555912e3bb4","content":"测试测试测试测试"}
        JSONObject jsonObject = new JSONObject();
        Log.e("TAG","memberId:"+loginInfo.getData().getData().getId()+"---coursewareId:"+memberId+"---courseId:"+courseId+"---content:"+s);
        try {
            jsonObject.put("memberId", loginInfo.getData().getData().getId());
            jsonObject.put("coursewareId", courseId);
            jsonObject.put("courseId", memberId);
            jsonObject.put("content", s);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.kcplApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<kjdzInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Toast.makeText(onlyplActivity.this, error_msg, Toast.LENGTH_SHORT).show();


                    }

                    @Override
                    public void onSuccess(int statusCode, kjdzInfo response) {
                        Toast.makeText(onlyplActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();

                        if(response.getErrorCode().equals("0")){

                            Log.e("TAG","成功");
                            getData(1);
                            edt_pl.setText(null);
                        }



                    }
                });
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }

}
