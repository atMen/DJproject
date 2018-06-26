package customer.tcrj.com.djproject.sy.infoactivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tsy.sdk.myokhttp.MyOkHttp;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.TBS.FileDisplayActivity;
import customer.tcrj.com.djproject.adpater.WdlistviewAdapter;
import customer.tcrj.com.djproject.adpater.spplAdapter;
import customer.tcrj.com.djproject.base.BaseFragment;
import customer.tcrj.com.djproject.bean.kcList;
import customer.tcrj.com.djproject.bean.plInfo;
import customer.tcrj.com.djproject.bean.qyListInfo;
import customer.tcrj.com.djproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Created by leict on 2018/4/19.
 */

public class SpplFregment extends BaseFragment implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;

    private MyOkHttp mMyOkhttp;
    private spplAdapter detailAdapter;
    private List<plInfo.DataBean.ContentBean> beanList;

    private int pageNum = 1;
    private boolean canPull = true;

    @Override
    protected int setLayout() {
        return R.layout.dw_fregment;
    }

    @Override
    protected void setView() {
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
        mRecyclerView.setAdapter(detailAdapter = new spplAdapter(beanList, mContext));
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

        showSuccess();
        disableLoadMoreIfNotFullPage(mRecyclerView,beanList.size());
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

//        detailAdapter.setNewData(response);
//        mPtrFrameLayout.refreshComplete();
//        showSuccess();
//        disableLoadMoreIfNotFullPage(mRecyclerView,response.size());


//        mMyOkhttp.post()
//                .url(ApiConstants.qylistApi)
//                .addParam("pageSize",1+"")
//                .addParam("pageIndex",1+"")
//                .enqueue(new GsonResponseHandler<qyListInfo>() {
//                    @Override
//                    public void onFailure(int statusCode, String error_msg) {
//
//                        Toast.makeText(mContext, error_msg, Toast.LENGTH_SHORT).show();
//
//                        if(num > 1){
//                            loadMoreData(null,true);
//                        }else{
//                            loadData(null,true);
//
//                        }
//                    }
//
//                    @Override
//                    public void onSuccess(int statusCode, qyListInfo response) {
//                        Toast.makeText(mContext, response.toString(), Toast.LENGTH_SHORT).show();
//                        if(num > 1){//上拉加载
//                            loadMoreData(response.getData(),false);
//                        }else if(num > response.getTotalPageCount()){//没有更多数据
//                            detailAdapter.loadMoreEnd(false);
////                          Toast.makeText(mContext, "暂无更多数据", Toast.LENGTH_SHORT).show();
//                        }else{//下拉刷新
//                            loadData(response.getData(),false);
//                        }
//
//
//
//                    }
//                });

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


    private boolean ishidden;
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e("TAG","hidden"+hidden);
        ishidden = hidden;


    }

    @Override
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
        Log.e("TAG","position"+position);
        if(position == 0){
            FileDisplayActivity.openActivity(mContext,"http://www.xiaobeifeng.top/file/123doc.doc");
        }else if(position == 1){
            FileDisplayActivity.openActivity(mContext,"http://www.xiaobeifeng.top/file/123xls.xls");
        }else if(position == 2){
            FileDisplayActivity.openActivity(mContext,"http://113.200.26.66:8000/upfile/201609270303560.pdf");
        }else{
            FileDisplayActivity.openActivity(mContext,"http://113.200.26.66:8000/upfile/201607121226270.pdf");
        }

    }
}
