package customer.tcrj.com.djproject.sy.xxkaFragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
import customer.tcrj.com.djproject.adpater.WdlistviewAdapter;
import customer.tcrj.com.djproject.adpater.xxkcAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.kcList;
import customer.tcrj.com.djproject.bean.kjInfo;
import customer.tcrj.com.djproject.mine.ExamListActivity;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.sy.PdfActivity;
import customer.tcrj.com.djproject.sy.XxksActivity;
import customer.tcrj.com.djproject.sy.infoactivity.TpActivity;
import customer.tcrj.com.djproject.sy.plActivity;
import customer.tcrj.com.djproject.video.VideoPlayerbigActivity;
import customer.tcrj.com.djproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

public class NewXxksActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    PtrFrameLayout mPtrFrameLayout;
    @BindView(R.id.txtTitle)
    TextView txtTitle;
    @BindView(R.id.btnback)
    ImageView btnback;

    private MyOkHttp mMyOkhttp;
    private WdlistviewAdapter detailAdapter;
    private List<kjInfo.DataBean.ContentBean> beanList;

    Entity loginInfo = null;
    private int pageNum = 1;
    private boolean canPull = true;

    private String id;
    String userId;

    @Override
    protected int setLayout() {
        return R.layout.activity_new_xxks;
    }

    @Override
    protected void setView() {
        txtTitle.setText("课件信息");
        id = getIntent().getStringExtra("kcid");
        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");
        userId = loginInfo.getData().getData().getId();
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        mPtrFrameLayout.disableWhenHorizontalMove(true);
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
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(detailAdapter = new WdlistviewAdapter(beanList, this,id,mMyOkhttp,userId));
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
    protected void setData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        getData(1);

    }

    @Override
    public void onDestroy() {
        mMyOkhttp.cancel(this);
        super.onDestroy();
    }

    //获取网络数据
    private void getData(final int num) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("page", num+"");
            jsonObject.put("size", "30");
            jsonObject.put("courseId", id);
            jsonObject.put("memberId", userId);
            jsonObject.put("type", "");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mMyOkhttp.post()
                .url(ApiConstants.kjlistApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<kjInfo>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {
                        Toast.makeText(NewXxksActivity.this, error_msg, Toast.LENGTH_SHORT).show();
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
                Toast.makeText(NewXxksActivity.this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
            }else{
                detailAdapter.loadMoreFail();
            }

        } else {

            if(pageNum > response.getData().getTotalPages()){//没有更多数据
                detailAdapter.loadMoreFail();
//                Toast.makeText(mContext, getResources().getString(R.string.data_nomore), Toast.LENGTH_SHORT).show();
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
//              Toast.makeText(flfgListActivity.this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
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
    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

        kjInfo.DataBean.ContentBean item = (kjInfo.DataBean.ContentBean) adapter.getItem(position);

        String type = item.getType();
        String file = item.getFile();
        String kjid = item.getId();
        String fileName = item.getFileName();

        if("13301".equals(type)){
            Bundle bundle2 = new Bundle();
            bundle2.putString("file",file);
            bundle2.putString("fileName",fileName);
            bundle2.putString("kcid",id);
            bundle2.putString("kjid",kjid);
            bundle2.putString("studyState",item.getStudyState());
            bundle2.putString("playtime",item.getPlayTime());
            bundle2.putString("minduction",item.getMinDuration());
            bundle2.putString("CloseCondition",item.getCloseCondition());
            toClass(this,plActivity.class,bundle2);
        }else if("13302".equals(type)){
            Bundle bundle3 = new Bundle();
            bundle3.putString("iconinfo",item.getFile());
            bundle3.putString("kcid",id);
            bundle3.putString("kjid",item.getId());
            bundle3.putString("studyState",item.getStudyState());
            bundle3.putString("playtime",item.getPlayTime());
            bundle3.putString("minduction",item.getMinDuration());
            toClass(this,TpActivity.class,bundle3);
        }else if("13305".equals(type)){
            Bundle bundle1 = new Bundle();
            bundle1.putString("file",file);
            bundle1.putString("fileName",fileName);
            bundle1.putString("kjid",kjid);
            bundle1.putString("kcid",id);
            bundle1.putString("studyState",item.getStudyState());
            bundle1.putString("playtime",item.getPlayTime());
            bundle1.putString("minduction",item.getMinDuration());
            toClass(this, VideoPlayerbigActivity.class,bundle1);
        }else if("13303".equals(type)){
            Bundle bundle = new Bundle();
            String s = file.replaceAll("swf", "pdf");
            bundle.putString("file",s);
            bundle.putString("fileName",fileName);
            bundle.putString("kjid",kjid);
            bundle.putString("studyState",item.getStudyState());
            bundle.putString("playtime",item.getPlayTime());
            bundle.putString("minduction",item.getMinDuration());
            toClass(this,PdfActivity.class,bundle);
        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnback:
                finish();
                break;

        }
    }
}
