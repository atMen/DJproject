package customer.tcrj.com.djproject.sy;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tsy.sdk.myokhttp.MyOkHttp;
import com.tsy.sdk.myokhttp.response.GsonResponseHandler;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import butterknife.BindView;
import customer.tcrj.com.djproject.MyApp;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.Utils.Utils;
import customer.tcrj.com.djproject.adpater.FreshNewsAdapter;
import customer.tcrj.com.djproject.adpater.xxcxAdapter;
import customer.tcrj.com.djproject.adpater.xxkcAdapter;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.Entity;
import customer.tcrj.com.djproject.bean.kcList;
import customer.tcrj.com.djproject.bean.qyListInfo;
import customer.tcrj.com.djproject.net.ApiConstants;
import customer.tcrj.com.djproject.sy.xxkaFragment.NewXxksActivity;
import customer.tcrj.com.djproject.widget.CustomLoadMoreView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;


public class XxcxActivity extends BaseActivity implements BaseQuickAdapter.OnItemClickListener {

    @BindView(R.id.txtTitle)
    public TextView title_tv;
    @BindView(R.id.recycler_view)
    public RecyclerView mRecyclerView;
    @BindView(R.id.mPtrFrameLayout)
    public PtrFrameLayout mPtrFrameLayout;

    @BindView(R.id.id_flowlayout)
    public TagFlowLayout id_flowlayout;
    @BindView(R.id.tv_search)
    TextView tv_search;
    @BindView(R.id.edt_search_result)
    EditText edt_search_result;
    @BindView(R.id.btnback)
    ImageView btnback;

    private MyOkHttp mMyOkhttp;
    private xxkcAdapter detailAdapter;
    private List<kcList.DataBean.ContentBean> beanList;
    private int pageNum = 1;
    private boolean canPull = false;

    private String title = "";
    private String time = "";//day,week,mouth,year

    private String[] mVals = new String[]
            {"全部", "一天内", "一周内", "一月内", "一年内"};

    Entity loginInfo;

    @Override
    protected int setLayout() {
        return R.layout.activity_xxcx;
    }

    @Override
    protected void setView() {
        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");
        id_flowlayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener()
        {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent)
            {

                switch (position){
                    case 0:
                        time = "";
                        break;
                    case 1:
                        time = "day";
                        break;
                    case 2:
                        time = "week";
                        break;
                    case 3:
                        time = "mouth";
                        break;
                    case 4:
                        time = "year";
                        break;
                }
                Log.e("TAG","position:"+position);
                return true;
            }
        });

        tv_search.setOnClickListener(this);
        mMyOkhttp = MyApp.getInstance().getMyOkHttp();
        mPtrFrameLayout.disableWhenHorizontalMove(true);
        title_tv.setText("信息查询");
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
        mRecyclerView.setLayoutManager(new GridLayoutManager(XxcxActivity.this, 2));
        mRecyclerView.setAdapter(detailAdapter = new xxkcAdapter(beanList, XxcxActivity.this));
//      detailAdapter.setPreLoadNumber(1);
        detailAdapter.setLoadMoreView(new CustomLoadMoreView());
//        detailAdapter.setEnableLoadMore(true);
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

        final LayoutInflater mInflater = LayoutInflater.from(this);
        TagAdapter adapter = new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.time,
                        parent, false);
                tv.setText(s);
                return tv;
            }

        };
        adapter.setSelectedList(0);
        id_flowlayout.setAdapter(adapter);
        getData(pageNum);
//        showEmptyView();
    }


    //获取网络数据
    private void getData(final int num) {

        if(title == null && title.equals("")){
            return;
        }
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put("memberId", loginInfo.getData().getData().getId());
            jsonObject.put("page", num+"");
            jsonObject.put("size", "30");
            jsonObject.put("title", title);
            jsonObject.put("time", time);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        mMyOkhttp.post()
                .url(ApiConstants.kclistApi)
                .jsonParams(jsonObject.toString())
                .enqueue(new GsonResponseHandler<kcList>() {
                    @Override
                    public void onFailure(int statusCode, String error_msg) {

                        Toast.makeText(XxcxActivity.this, error_msg, Toast.LENGTH_SHORT).show();

                        if(num > 1){
                            loadMoreData(null,true);
                        }else{
                            loadData(null,true);

                        }
                    }

                    @Override
                    public void onSuccess(int statusCode, kcList response) {
//                        Toast.makeText(XxcxActivity.this, response.getMessage(), Toast.LENGTH_SHORT).show();

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
    private void loadMoreData(kcList response,boolean isError) {

        if (response == null) {
            if(isError){
                detailAdapter.loadMoreFail();
                Toast.makeText(XxcxActivity.this, getResources().getString(R.string.data_failed), Toast.LENGTH_SHORT).show();
            }else{
                detailAdapter.loadMoreFail();
            }

        } else {

            if(pageNum > response.getData().getTotalPages()){//没有更多数据
                detailAdapter.loadMoreFail();
//                Toast.makeText(XxcxActivity.this, getResources().getString(R.string.data_nomore), Toast.LENGTH_SHORT).show();
            }else{
                List<kcList.DataBean.ContentBean> content = response.getData().getContent();
                pageNum++;
                detailAdapter.addData(content);
                detailAdapter.loadMoreComplete();
            }

        }




    }

    //下拉刷新
    private void loadData(List<kcList.DataBean.ContentBean> response,boolean isError) {

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
        if (manager instanceof GridLayoutManager) {
            final GridLayoutManager linearLayoutManager = (GridLayoutManager) manager;

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

        kcList.DataBean.ContentBean item = (kcList.DataBean.ContentBean) adapter.getItem(position);
        String id = item.getId();
        Bundle bundle = new Bundle();
        bundle.putString("kcid",id);
        toClass(this,NewXxksActivity.class,bundle);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.tv_search:

                InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                String string = edt_search_result.getText().toString();
                Log.e("TAg","edt_search_result:"+string);
//                if(string.equals("")){
//                    Toast.makeText(this, "请输入搜索内容", Toast.LENGTH_SHORT).show();
//                }else{
                    title = string;
                    getData(1);
//                }

                break;
            case R.id.btnback:
                finish();
                break;

            default:
                break;
        }
    }

    @Override
    public void onDestroy() {
        mMyOkhttp.cancel(this);
        super.onDestroy();

    }


//    private PopupWindow mPopTop;
//    private TextView tvPopuReport;
//    private TextView tvPopuShare;
//    private TextView tvPopuMove;
//    private TextView tvPopuSeas;
//    /**
//     * 弹出框样式设置
//     */
//    private void setPopuWindow() {
//        mPopTop = new PopupWindow(this);
//        int w = Utils.getWidth(this);
//        mPopTop.setWidth(w / 2);
//        mPopTop.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
//        mPopTop.setFocusable(true);//TODO 获取焦点
//        mPopTop.setTouchable(true);
//        mPopTop.setOutsideTouchable(true);//TODO 设置popupwindow外部可点击
//        ColorDrawable dw = new ColorDrawable(0000000000);// TODO 实例化一个ColorDrawable颜色为半透明
//        mPopTop.setBackgroundDrawable(dw);// TODO 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
//        mPopTop.setAnimationStyle(R.style.mystyle);//TODO 设置显示和消失动画
//        View conentView = Utils.getLayoutInflater(this).inflate(R.layout.item_popu_current, null);
//        setConentViewClickListener(conentView);
//        mPopTop.setContentView(conentView);
//    }
//
//    /**
//     * 事件
//     *
//     * @param v
//     */
//    private void setConentViewClickListener(View v) {
//        tvPopuReport = (TextView) v.findViewById(R.id.tv_popu_report);
//        tvPopuShare = (TextView) v.findViewById(R.id.tv_popu_share);
//        tvPopuMove = (TextView) v.findViewById(R.id.tv_popu_move);
//        tvPopuSeas = (TextView) v.findViewById(R.id.tv_popu_seas);
//
//        tvPopuReport.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPopTop.dismiss();
//                tv_sx.setText("文档");
//            }
//        });
//        tvPopuShare.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPopTop.dismiss();
//                tv_sx.setText("音频");
//            }
//        });
//        tvPopuMove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPopTop.dismiss();
//                tv_sx.setText("视频");
//            }
//        });
//        tvPopuSeas.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mPopTop.dismiss();
//                tv_sx.setText("图片");
//            }
//        });
//    }
}
