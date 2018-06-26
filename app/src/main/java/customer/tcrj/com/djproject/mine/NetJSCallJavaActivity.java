package customer.tcrj.com.djproject.mine;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import customer.tcrj.com.djproject.R;
import customer.tcrj.com.djproject.Utils.ACache;
import customer.tcrj.com.djproject.bean.Entity;

public class NetJSCallJavaActivity extends Activity implements View.OnClickListener {

	private WebView mWebView = null;
	private TextView title;
	private ImageView back;
	Entity loginInfo = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_zt);
		loginInfo = (Entity) ACache.get(this).getAsObject("loginInfo");

		mWebView = (WebView) findViewById(R.id.webview);
		title = (TextView) findViewById(R.id.txtTitle);
		back = (ImageView) findViewById(R.id.btnback);
		back.setOnClickListener(this);
		title.setText("专题活动");
		showWebView();
	}

	private void showWebView() {
		// webView与js交互代码
		try {
			mWebView.requestFocus();
			mWebView.setWebChromeClient(new MyWebChromeClient());
			mWebView.setOnKeyListener(new MyOnKeyListener());
			WebSettings webSettings = mWebView.getSettings();
			webSettings.setJavaScriptEnabled(true);
			webSettings.setDefaultTextEncodingName("utf-8");
			 // 添加一个对象, 让JS可以访问该对象的方法, 该对象中可以调用JS中的方法
			mWebView.addJavascriptInterface(getHtmlObject(), "android");
//			mWebView.loadUrl("http://192.168.20.201:8080/yldj-cms/app/exam.chtml");
			mWebView.loadUrl("file:///android_asset/netJSCallJava.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onClick(View v) {
		finish();
	}

	class MyOnKeyListener implements View.OnKeyListener {

		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event) {

			if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
				mWebView.goBack();
				return true;
			}
			return false;

		}

	}

	class MyWebChromeClient extends WebChromeClient {

		@Override
		public void onProgressChanged(WebView view, int progress) {
			NetJSCallJavaActivity.this.setTitle("Loading...");
			NetJSCallJavaActivity.this.setProgress(progress);
			if (progress >= 80) {
				NetJSCallJavaActivity.this.setTitle("JsAndroid Test");
			}
		}

	}

//	private Object getHtmlObject() {
//		Object insertObj = new Object() {
//			public String HtmlcallJava() {
//
//				return "Html call Java";
//			}
//
//			public String HtmlcallJava2(final String param) {
//				return "Html call Java : " + param;
//			}
//
//
//		};
//		return insertObj;
//	}


	public Object getHtmlObject() {

		Object insertObj = new Object(){

			public void T(final String t){//js调用java Toast方法

				runOnUiThread(new Runnable() {
					public void run() {
						Toast.makeText(NetJSCallJavaActivity.this, t, Toast.LENGTH_SHORT).show();
					}
				});

			}

			public String getUserID(){//js调用java Toast方法
				Toast.makeText(NetJSCallJavaActivity.this, loginInfo.getData().getId(), Toast.LENGTH_SHORT).show();
				return loginInfo.getData().getId();
			}



		};
		return insertObj;
	}

}
