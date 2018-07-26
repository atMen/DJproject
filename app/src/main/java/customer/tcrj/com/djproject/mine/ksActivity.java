package customer.tcrj.com.djproject.mine;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.base.BaseActivity;
import customer.tcrj.com.djproject.bean.Entity;

public class ksActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView mWebView;
    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;
    Entity loginInfo = null;



    private String url;

    @Override
    protected int setLayout() {
        return R.layout.activity_ks;
    }

    @Override
    protected void setView() {
        loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");
        url = getIntent().getStringExtra("url");

        // 设置WebViewClient
        mWebView.setWebViewClient(new WebViewClient() {
            // url拦截
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //使用自己的WebView组件来响应Url加载事件，而不是使用默认浏览器器加载页面
                view.loadUrl(url);
                // 相应完成返回true
                return false;
                //return super.shouldOverrideUrlLoading(view, url);
            }

            // 页面开始加载
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                mProgressBar.setVisibility(View.VISIBLE);
                super.onPageStarted(view, url, favicon);
            }

            // 页面加载完成
            @Override
            public void onPageFinished(WebView view, String url) {
//                mProgressBar.setVisibility(View.GONE);
                super.onPageFinished(view, url);
            }



            // WebView加载的所有资源url
            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

        });

//        // 设置WebChromeClient
//        mWebView.setWebChromeClient(new WebChromeClient() {
//            @Override
//            // 处理javascript中的alert
//            public boolean onJsAlert(WebView view, String url, final String message,
//                                     final JsResult result) {
//
////            final SweetAlertDialog sad = new SweetAlertDialog(MyApprovalDetailsActivity.this);
////            sad.setTitleText("提示");
////            sad.setContentText(message);
////            sad.setCanceledOnTouchOutside(true);
////            sad.setCancelable(true);
////            sad.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
////                @Override
////                public void onClick(SweetAlertDialog sweetAlertDialog) {
////                    if (message.indexOf("成功") >= 0 || message.indexOf("完成") >= 0) {
////                        result.confirm();
////                        sad.dismiss();
////                        finish();
////                    } else {
////                        result.confirm();
////                        sad.dismiss();
////                    }
////
////                }
////            });
////            sad.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
////                @Override
////                public void onClick(SweetAlertDialog sweetAlertDialog) {
////                    if (message.indexOf("成功") >= 0 || message.indexOf("完成") >= 0) {
////                        result.confirm();
////                        sad.dismiss();
////                        finish();
////                    } else {
////                        result.confirm();
////                        sad.dismiss();
////                    }
////                }
////            });
////            sad.show();
//                result.confirm();
//                return true;
//
//            }
//
//
//            @Override
//            // 处理javascript中的confirm
//            public boolean onJsConfirm(WebView view, String url,
//                                       String message, final JsResult result) {
//
//
//                return super.onJsConfirm(view, url, message, result);
//            }
//
//            ;
//
//            @Override
//            // 处理javascript中的prompt
//            public boolean onJsPrompt(WebView view, String url, String message,
//                                      String defaultValue, final JsPromptResult result) {
//                return super.onJsPrompt(view, url, message, defaultValue, result);
//            }
//
//            ;
//
//            //设置网页加载的进度条
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                mProgressBar.setProgress(newProgress);
//                super.onProgressChanged(view, newProgress);
//            }
//
//            //设置程序的Title
//            @Override
//            public void onReceivedTitle(WebView view, String title) {
//                setTitle(title);
//                super.onReceivedTitle(view, title);
//            }
//        });
        //声明WebSettings子类
        WebSettings webSettings = mWebView.getSettings();

        //如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);

        //支持插件
//        webSettings.setPluginsEnabled(true);

        //设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

        //缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件

        //其他细节操作
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); //关闭webview中缓存
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式

        mWebView.addJavascriptInterface(getAndroidObject(), "android");
        mWebView.loadUrl(url);
    }

    @Override
    protected void setData() {

//        Log.e("TAG","url:"+url);
//        mWebView.loadUrl(url);



//        webView.loadUrl("http://192.168.20.201:8080/yldj-cms/app/exam.chtml");



//    //设置支持JavaScript脚本
//    WebSettings webSettings = mWebView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//    //设置可以访问文件
//        webSettings.setAllowFileAccess(true);
//    //设置可以支持缩放
//        webSettings.setSupportZoom(true);
//    //设置默认缩放方式尺寸是far
//        webSettings.setDefaultZoom(WebSettings.ZoomDensity.MEDIUM);
//    //设置出现缩放工具
//        webSettings.setBuiltInZoomControls(false);
//        webSettings.setDefaultFontSize(20);
    //访问地址设置
//        mWebView.loadUrl("http://192.168.20.201:8080/yldj-cms/app/exam.chtml");


//        mWebView.loadUrl("file:///android_asset/netJSCallJava.html");



//        WebSettings webSettings = ariginating_web.getSettings();
//        //设置WebView属性，能够执行Javascript脚本
//
//        webSettings.setJavaScriptEnabled(true);
//        //设置可以访问文件
//        webSettings.setAllowFileAccess(true);
//        //设置支持缩放
//        webSettings.setBuiltInZoomControls(true);
//        ariginating_web.loadUrl(Url);
//        ariginating_web.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                // TODO Auto-generated method stub
//                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
//                view.loadUrl(url);
//                return true;
//            }
//        }
// );

}



    @Override
    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btnback:
//                back();
//                break;
//        }
    }

    /**
     * 拦截返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 是否触发按键为back键
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            back();
            Log.e("TAG","back1");
            return true;
            //如果不是back键正常响应
        }
        else {
            return true;
        }
    }

    private void back() {
        Log.e("TAG","back2");
        if (mWebView.canGoBack()) {
            mWebView.goBack();
            Log.e("TAG","back3");
        } else {
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWebView.pauseTimers();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.resumeTimers();
    }



    public Object getAndroidObject() {

        Object insertObj = new Object(){

            @JavascriptInterface
            public void T(final String t){//js调用java Toast方法

                runOnUiThread(new Runnable() {
                    public void run() {
                        Toast.makeText(ksActivity.this, t, Toast.LENGTH_SHORT).show();
                    }
                });

            }

            @JavascriptInterface
            public String getUserID(){//js调用java Toast方法
                Toast.makeText(ksActivity.this, loginInfo.getData().getData().getId(), Toast.LENGTH_SHORT).show();
                        return loginInfo.getData().getData().getId();
            }

            @JavascriptInterface
            public void back() {

                    finish();

            }

        };
        return insertObj;
    }


}
