package customer.tcrj.com.djproject.sy.xxkaFragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.adpater.WdlistviewAdapter;
import customer.tcrj.com.djproject.adpater.YplistviewAdapter;
import customer.tcrj.com.djproject.base.BaseFragment;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.kcList;
import customer.tcrj.com.djproject.bean.kjInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.video.VideoPlayerActivity;
import customer.tcrj.com.djproject.video.VideoPlayerbigActivity;
import customer.tcrj.com.djproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by leict on 2018/4/19.
 */

public class YpFregment extends BaseFragment implements  BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;

    private MyOkHttp mMyOkhttp;
    private YplistviewAdapter detailAdapter;
    private List<kjInfo.DataBean.ContentBean> beanList;

    String userId;
    private int pageNum = 1;
    private boolean canPull = true;
    Entity loginInfo = null;
    private String id;
    public YpFregment(String id) {
        this.id = id;
    }

    @Override
    protected int setLayout() {
        return R.layout.dw_fregment;
    }

    @Override
    protected void setView() {
        loginInfo = (Entity) ACache.get(mContext).getAsObject("loginInfo");
         userId = loginInfo.getData().getData().getId();

        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        mPtrFrameLayout.disableWhenHorizontalMove(true);

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

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(detailAdapter = new YplistviewAdapter(beanList, mContext,id,mMyOkhttp,userId));
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

    //错误页面的点击回调，重新加载数据
    @Override
    public void onRetry() {
        getData(pageNum);
    }
    @Override
    public void onDestroy() {
        mMyOkhttp.cancel(this);
        super.onDestroy();

    }
    @Override
    protected void setData() {
        getData(pageNum);
    }


    //获取网络数据
    private void getData(final int num) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("page", num+"");
            jsonObject.put("size", "30");
            jsonObject.put("courseId", id);
            jsonObject.put("memberId", userId);
            jsonObject.put("type", "13305");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mMyOkhttp.post()
                .url(ApiConstants.kjlistApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<kjInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Toast.makeText(mContext, error_msg, Toast.LENGTH_SHORT).show();

                        if(num > 1){
                            loadMoreData(null,true);
                        }else{
                            loadData(null,true);

                        }
                    }

                    @Override
                    public void onSuccess(int statusCode, kjInfo response) {
//                        Toast.makeText(mContext, response.getMessage(), Toast.LENGTH_SHORT).show();
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
    private void loadMoreData(kjInfo response, boolean isError) {

        if (response == null) {
            if(isError){
                detailAdapter.loadMoreFail();
                Toast.makeText(mContext, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
            }else{
                detailAdapter.loadMoreFail();
            }

        } else {

            if(pageNum > response.getData().getTotalPages()){//没有更多数据
                detailAdapter.loadMoreFail();
                Toast.makeText(mContext, getResources().getString(R.string.data_nomore), Toast.LENGTH_SHORT).show();
            }else{
                List<kjInfo.DataBean.ContentBean> content = response.getData().getContent();
                pageNum++;
                detailAdapter.addData(content);
                detailAdapter.loadMoreComplete();
            }

        }




    }

    //下拉刷新
    private void loadData(List<kjInfo.DataBean.ContentBean> response,boolean isError) {

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




    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        kjInfo.DataBean.ContentBean item = (kjInfo.DataBean.ContentBean) adapter.getItem(position);
        String file = item.getFile();
        String kjid = item.getId();
        String fileName = item.getFileName();
        Bundle bundle = new Bundle();
        bundle.putString("file",file);
        bundle.putString("fileName",fileName);
        bundle.putString("kjid",kjid);
        bundle.putString("kcid",id);
        bundle.putString("studyState",item.getStudyState());
        bundle.putString("playtime",item.getPlayTime());
        bundle.putString("minduction",item.getMinDuration());
        toClass(mContext, VideoPlayerbigActivity.class,bundle);
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

//
//    private boolean ishidden;
//    @Override
//    public void onHiddenChanged(boolean hidden) {
//        super.onHiddenChanged(hidden);
//        Log.e("TAG","hidden"+hidden);
//        ishidden = hidden;
////        if(data != null && !hidden){
////            disableLoadMoreIfNotFullPage(mRecyclerView,data.size());
////        }
//
//    }

}
