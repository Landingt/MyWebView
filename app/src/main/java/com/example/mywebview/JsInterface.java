package com.example.mywebview;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.webkit.JavascriptInterface;

public class JsInterface {
    private Context context;
    private JsBridge jsBridge;

    public JsInterface(JsBridge jsBridge) {
        this.jsBridge = jsBridge;
    }



    @JavascriptInterface
    public void setValue(String value){
        Log.e("JsInterface","value="+value);
        jsBridge.setTextViewValue(value);
    }
}
