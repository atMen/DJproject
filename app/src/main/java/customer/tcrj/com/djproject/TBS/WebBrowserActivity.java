package customer.tcrj.com.djproject.TBS;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.TBS.bridge.BridgeHandler;
import customer.tcrj.com.djproject.TBS.bridge.CallBackFunction;
import customer.tcrj.com.djproject.TBS.bridge.DefaultHandler;
import customer.tcrj.com.djproject.TBS.bridge.SimpleBridgeWebViewClientListener;
import customer.tcrj.com.djproject.TBS.bridge.TbsBridgeWebView;


/**
 * Project :  TBSreader.
 * Package name: github.benjamin.tbsreader
 * Created by :  Benjamin.
 * Created time: 2018/1/3 15:36
 * Changed by :  Benjamin.
 * Changed time: 2018/1/3 15:36
 * Class description:
 */

public class WebBrowserActivity extends Activity {
    private String file;
    TbsBridgeWebView webView;
    private String TAG = "WebBrowserActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);
        getWindow().setFormat(PixelFormat.TRANSLUCENT);//（这个对宿主没什么影响，建议声明）
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE | WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        file = getIntent().getStringExtra("filePath") == null ? "" : getIntent().getStringExtra("filePath");
        initView();
    }

    private void initView() {
        webView = (TbsBridgeWebView)findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSaveFormData(false);
        webView.getSettings().setSavePassword(false);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        //设定支持h5viewport
        webView.getSettings().setUseWideViewPort(true);
        // 自适应屏幕.
        webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
//        mWwebViewebView.getSettings().setUserAgentString(Constant.useragent);


        //=======================js桥使用改方法替换原有setWebViewClient()方法==========================
        webView.setBridgeWebViewClientListener(new SimpleBridgeWebViewClientListener() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i(TAG, "超链接：" + url);
                return false;
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap bitmap) {

            }

            @Override
            public void onPageFinished(WebView view, String url) {

            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            }

            @Override
            public boolean onReceivedSslError(WebView webView, final SslErrorHandler sslErrorHandler, SslError sslError) {
                String message;
                switch (sslError.getPrimaryError()) {
                    case android.net.http.SslError.SSL_UNTRUSTED:
                        message = "证书颁发机构不受信任";
                        break;
                    case android.net.http.SslError.SSL_EXPIRED:
                        message = "证书过期";
                        break;
                    case android.net.http.SslError.SSL_IDMISMATCH:
                        message = "网站名称与证书不一致";
                        break;
                    case android.net.http.SslError.SSL_NOTYETVALID:
                        message = "证书无效";
                        break;
                    case android.net.http.SslError.SSL_DATE_INVALID:
                        message = "证书日期无效";
                        break;
                    case android.net.http.SslError.SSL_INVALID:
                    default:
                        message = "证书错误";
                        break;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(WebBrowserActivity.this);
                builder.setTitle("提示").setMessage(message + "，是否继续").setCancelable(true)
                        .setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                sslErrorHandler.proceed();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                sslErrorHandler.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });
        //=======================此方法必须调用==========================
        webView.setDefaultHandler(new DefaultHandler());
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                // TODO Auto-generated method stub
                super.onProgressChanged(view, newProgress);
            }
        });

        webView.loadUrl(file);

        //description：如需使用自定义桥名，调用以下方法即可，
        // 传空或不调用setCustom方法即使用默认桥名。
        // 默认桥名：WebViewJavascriptBridge
        //=======================使用自定义桥名时调用以下代码即可==========================
//        webView.setCustom("桥名");
        webView.setCustom("TestJavascriptBridge");

        //=======================以下4个web调用native示例方法==========================
        webView.registerHandler("initSignNetPay", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Log.i(TAG, "回传结果：" + data);
                Toast.makeText(WebBrowserActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });

        webView.registerHandler("initSignNetShare", new BridgeHandler() {

            @Override
            public void handler(String data, CallBackFunction function) {
                Log.i(TAG, "回传结果：" + data);
                Toast.makeText(WebBrowserActivity.this, data, Toast.LENGTH_SHORT).show();
            }
        });

        /*//=======================招行一网通js桥回调==========================
        webView.registerHandler("initCmbSignNetPay", new BridgeHandler() {

            @Override
            public void handler(String data, CallBackFunction function) {
                //在这里解析回调数据并执行处理
                Log.i(TAG, "回传结果：" + data);
            }
        });*/
    }

    public static void openActivity(Context context) {
        Intent intent = new Intent(context, WebBrowserActivity.class);
        intent.putExtra("filePath", "http://www.xiaobeifeng.top/YunnaGuide/html/test.html");
        context.startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (webView != null) {
            if (webView.canGoBack()) {
                webView.goBack();
            } else {
                finish();
            }
        }
    }
}
