package customer.tcrj.com.djproject.sy;

import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
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
import customer.tcrj.com.djproject.Utils.Utils;
import customer.tcrj.com.djproject.adpater.FreshNewsAdapter;
import customer.tcrj.com.djproject.adpater.hdjlAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.base.NpaLinearLayoutManager;
import customer.tcrj.com.djproject.bean.hdjlInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;


public class hdjlActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;

    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;

    private MyOkHttp mMyOkhttp;
    private hdjlAdapter detailAdapter;
    private List<hdjlInfo.DataBean.ContentBean> beanList;

    private int pageNum = 1;
    private boolean canPull = true;

    @Override
    protected int setLayout() {
        return R.layout.activity_dkgl;
    }

    @Override
    protected void setView() {

        txtTitle.setText("互动交流");
        btnback.setOnClickListener(this);
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
        hdjlInfo.DataBean.ContentBean a = new hdjlInfo.DataBean.ContentBean("1","阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房管理上不敢啦三课");
        hdjlInfo.DataBean.ContentBean b = new hdjlInfo.DataBean.ContentBean("2张三","阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房管理上不敢啦三课阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房圾费格拉斯库房管理上不敢啦三课理上不敢啦三课阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房管理上不敢啦三课");
        hdjlInfo.DataBean.ContentBean c = new hdjlInfo.DataBean.ContentBean("3张三","阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房管理上不敢啦三课阿卡数据恢复哥萨克减肥药噶福挂一个发送");
        hdjlInfo.DataBean.ContentBean d = new hdjlInfo.DataBean.ContentBean("4张三","阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房管理上不敢啦三课理上不敢啦三课阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房管理上不敢啦三课");
        hdjlInfo.DataBean.ContentBean e = new hdjlInfo.DataBean.ContentBean("5张三","阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房管理上不敢啦三课阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房管理上不敢啦三课阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房管理上不敢啦三课");
        hdjlInfo.DataBean.ContentBean f = new hdjlInfo.DataBean.ContentBean("6张三","阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房管理上不敢啦三课阿卡数据恢复哥萨克减肥药噶福挂一个发送垃圾费格拉斯库房管理上不敢啦三课");

        beanList.add(a);
        beanList.add(b);
        beanList.add(c);
        beanList.add(d);
        beanList.add(e);
        beanList.add(f);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,  StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(detailAdapter = new hdjlAdapter(beanList, hdjlActivity.this));
        detailAdapter.setPreLoadNumber(1);
        detailAdapter.setLoadMoreView(new CustomLoadMoreView());
        detailAdapter.setEnableLoadMore(true);
        detailAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        detailAdapter.setOnItemClickListener(this);
        detailAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                Log.e("TAG","点击重新加载数据");
//                getData(pageNum);
            }
        }, mRecyclerView);
        showSuccess();

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
            jsonObject.put("size", "5");


        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.xyqinfoApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<hdjlInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Toast.makeText(hdjlActivity.this, error_msg, Toast.LENGTH_SHORT).show();

                        if(num > 1){
                            loadMoreData(null,true);
                        }else{
                            loadData(null,true);

                        }
                    }

                    @Override
                    public void onSuccess(int statusCode, hdjlInfo response) {
//                        Toast.makeText(mContext, response.getMessage(), Toast.LENGTH_SHORT).show();

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
    private void loadMoreData(hdjlInfo response,boolean isError) {
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
                Log.e("TAG","没有更多数据"+response.getData().getTotalPages());


                detailAdapter.loadMoreFail();


//                Toast.makeText(mContext, getResources().getString(R.string.data_nomore), Toast.LENGTH_SHORT).show();
            }else{
                List<hdjlInfo.DataBean.ContentBean> content = response.getData().getContent();
                Log.e("TAG","content:"+content.size());
                pageNum++;

                detailAdapter.addData(content);

                detailAdapter.loadMoreComplete();
            }

        }




    }

    //下拉刷新
    private void loadData(List<hdjlInfo.DataBean.ContentBean> response,boolean isError) {

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
finish();
    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

    }
}
