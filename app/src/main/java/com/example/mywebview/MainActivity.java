package com.example.mywebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements JsBridge{
    private WebView mWebView;
    private TextView mTextView;
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inti();

    }

    private void inti() {
        mHandler=new Handler();
        mWebView=findViewById(R.id.webview);
        mTextView=findViewById(R.id.tv_result);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许WEBVIEW加载JS代码
        mWebView.addJavascriptInterface(new JsInterface(this),"Launcher");//给webView添加JS接口
        mWebView.loadUrl("file:///android_asset/index.html");
        mWebView.getSettings().setUserAgentString(mWebView.getSettings().getUserAgentString());
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.getSettings().setAllowFileAccess(true);
        mWebView.getSettings().setAppCacheEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setDatabaseEnabled(true);
    }

    @Override
    public void setTextViewValue(final String value) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
             mTextView.setText(value);
            }
        });
    }
}
