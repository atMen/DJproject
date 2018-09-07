package customer.tcrj.com.djproject.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;
import com.githang.statusbar.StatusBarCompat;
import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.bean.Entity;

public class NetJSCallJavaActivity extends Activity implements View.OnClickListener {

	private WebView webView = null;
	private TextView title;
	private ImageView back;
	Entity loginInfo = null;
	private String url;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zt);
		setStatusBar();
		url = getIntent().getStringExtra("url");
		loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");

		webView = (WebView) findViewById(R.id.webview);
		title = (TextView) findViewById(R.id.txtTitle);
		back = (ImageView) findViewById(R.id.btnback);
		back.setOnClickListener(this);
		title.setText("专题活动");
		showWebView();
	}
	protected void setStatusBar() {
		StatusBarCompat.setStatusBarColor(this, getResources().getColor(R.color.red), true);
	}
	private void showWebView() {
		//支持javascript
		webView.getSettings().setJavaScriptEnabled(true);
		// 设置可以支持缩放
		webView.getSettings().setSupportZoom(true);
		// 设置出现缩放工具
		webView.getSettings().setBuiltInZoomControls(true);
		//扩大比例的缩放
		webView.getSettings().setUseWideViewPort(true);
		//自适应屏幕
		webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
		webView.getSettings().setLoadWithOverviewMode(true);


		//如果不设置WebViewClient，请求会跳转系统浏览器
		webView.setWebViewClient(new WebViewClient() {

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				//该方法在Build.VERSION_CODES.LOLLIPOP以前有效，从Build.VERSION_CODES.LOLLIPOP起，建议使用shouldOverrideUrlLoading(WebView, WebResourceRequest)} instead
				//返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
				//返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://ask.csdn.net/questions/178242



				return false;
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
				//返回false，意味着请求过程里，不管有多少次的跳转请求（即新的请求地址），均交给webView自己处理，这也是此方法的默认处理
				//返回true，说明你自己想根据url，做新的跳转，比如在判断url符合条件的情况下，我想让webView加载http://ask.csdn.net/questions/178242
//				if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//					if (request.getUrl().toString().contains("sina.cn")) {
//						view.loadUrl("http://ask.csdn.net/questions/178242");
//						return true;
//					}
//				}

				return false;
			}

		});
		webView.loadUrl(url);
	}





	@Override
	public void onClick(View v) {
		finish();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_BACK&&webView.canGoBack()){
			webView.goBack();
			return true;
		}else{
			onBackPressed();
		}
		return super.onKeyDown(keyCode, event);
	}

}
