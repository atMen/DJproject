package customer.tcrj.com.djproject.sy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.githang.statusbar.StatusBarCompat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.bean.picInfo;

public class NewsDetailActivity extends Activity {


    private TextView title;
    private ImageView backBtn;
    private WebView mWebView = null;
    private TextView sub_title;
    private TextView source;
    private TextView number;
    private TextView date;

    picInfo.DataBean response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.red), true);
        response = (picInfo.DataBean) getIntent().getSerializableExtra("picInfo");
        initView();
        getData();
    }


    public void initView() {
        Intent intent = getIntent();
        backBtn = (ImageView) findViewById(R.id.btnback);
        backBtn.setVisibility(View.VISIBLE);
        mWebView = (WebView) findViewById(R.id.webView);
        backBtn.setOnClickListener(new OnClick());

        title = (TextView) findViewById(R.id.title);
        sub_title = (TextView) findViewById(R.id.sub_title);
        source = (TextView) findViewById(R.id.source);
        number = (TextView) findViewById(R.id.number);
        date = (TextView) findViewById(R.id.date);

//        // 设置WebViewClient
//        mWebView.setWebViewClient(new WebViewClient() {
//            // url拦截
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                //使用自己的WebView组件来响应Url加载事件，而不是使用默认浏览器器加载页面
//                view.loadUrl(url);
//                // 相应完成返回true
//                return true;
//                //return super.shouldOverrideUrlLoading(view, url);
//            }
//
//            // 页面开始加载
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
////                mProgressBar.setVisibility(View.VISIBLE);
//                super.onPageStarted(view, url, favicon);
//            }
//
//            // 页面加载完成
//            @Override
//            public void onPageFinished(WebView view, String url) {
////                mProgressBar.setVisibility(View.GONE);
//                super.onPageFinished(view, url);
//            }
//
//
//
//            // WebView加载的所有资源url
//            @Override
//            public void onLoadResource(WebView view, String url) {
//                super.onLoadResource(view, url);
//            }
//
//            @Override
//            public void onReceivedError(WebView view, int errorCode,
//                                        String description, String failingUrl) {
//
//                Log.e("TAG","errorCode"+errorCode);
//                super.onReceivedError(view, errorCode, description, failingUrl);
//            }
//
//        });
//
//
//        //声明WebSettings子类
//        WebSettings webSettings = mWebView.getSettings();
//
//        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
//        webSettings.setJavaScriptEnabled(true);
//
//        //支持插件
////        webSettings.setPluginsEnabled(true);
//
//        //设置自适应屏幕，两者合用
//        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
//        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
//
//        //缩放操作
//        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
//        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
//        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
//
//        //其他细节操作
//        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); //关闭webview中缓存
//        webSettings.setAllowFileAccess(true); //设置可以访问文件
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
//        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
//        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
    }

    public static String getNewContent(String htmltext){
        try {
            Document doc= Jsoup.parse(htmltext);
            Elements elements=doc.getElementsByTag("img");
            for (Element element : elements) {
                element.attr("width","100%").attr("height","auto");
            }

            return doc.toString();
        } catch (Exception e) {
            return htmltext;
        }
    }

    public void getData() {

        Log.e("TAG","response.getInfoContent():"+response.getInfoContent());
//        mWebView.loadDataWithBaseURL(null,html, "text/html", "UTF-8",null);
        if(response != null && response.getInfoContent() != null){
            Log.e("TAG","加载webview");
//            mWebView.loadDataWithBaseURL(null,response.getInfoContent(), "text/html", "UTF-8",null);
            String newContent = getNewContent(response.getInfoContent());

            mWebView.loadData(newContent, "text/html; charset=UTF-8", null);


            title.setText(response.getTitle());
        date.setText(response.getShowTime());
        }

    }

    class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnback:
                    finish();
                    break;

            }
        }
    }

    /**
     * 拦截返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 是否触发按键为back键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            back();
            return true;
            // 如果不是back键正常响应
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    private void back() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            finish();
        }
    }
}
