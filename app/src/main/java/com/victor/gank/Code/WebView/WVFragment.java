package com.victor.gank.Code.WebView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewFragment;

/**
 * Created by Victor on 2017/6/15.
 */
public class WVFragment extends WebViewFragment {

    private WebView mWebView;
    private WebSettings mWebSettings;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public void initView(){
        mWebView = getWebView();
//        mWebView.setLayoutParams(new LinearLayout.LayoutParams(1080, 1920));
        mWebSettings = mWebView.getSettings();

        mWebSettings.setSavePassword(false);
        mWebSettings.setSaveFormData(false);
        mWebSettings.setJavaScriptEnabled(true);

//        // 设置可以支持缩放
//        mWebSettings.setSupportZoom(true);
//        // 设置出现缩放工具
//        mWebSettings.setBuiltInZoomControls(true);
        //设置自适应屏幕，两者合用
        mWebSettings.setUseWideViewPort(true);                              //将图片调整到适合WebView的大小
        mWebSettings.setLoadWithOverviewMode(true);                         // 缩放至屏幕的大小

        mWebSettings.setCacheMode(WebSettings.LOAD_DEFAULT);                //设置 缓存模式
//        mWebSettings.setLoadsImagesAutomatically(true);                     //支持自动加载图片
//        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);        //支持通过JS打开新窗口


//        mWebSettings.setPluginState(WebSettings.PluginState.ON);
//
        // 开启Dom storage Api 功能 用于缓存
        mWebSettings.setDomStorageEnabled(true);
        // 开启database storage Api 功能 用于缓存
        mWebSettings.setDatabaseEnabled(true);

        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
//        mWebSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
//        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);//适应内容大小

//         看这里用到了 addJavascriptInterface 这就是我们的重点中的重点
        // 我们再看他的DemoJavaScriptInterface这个类。还要这个类一定要在主线程中
        mWebView.addJavascriptInterface(new DemoJavaScriptInterface(), "demo1");
//


        mWebView.setWebChromeClient(new MyWebChromeClient());
        mWebView.setWebViewClient(new webViewClient());
        mWebView.loadUrl("http://gank.io/xiandu");
    }

    /**
     * Provides a hook for calling "alert" from javascript. Useful for
     * 从javascript中提供了一个叫“提示框” 。这是很有用的
     * debugging your javascript.
     *  调试你的javascript。
     */
    final class MyWebChromeClient extends WebChromeClient {
        @Override
        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
//            Log.d(LOG_TAG, message);
            result.confirm();
            return true;
        }
    }
    //Web视图
    private class webViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    // 这是他定义由 addJavascriptInterface 提供的一个Object
    final class DemoJavaScriptInterface {
        DemoJavaScriptInterface() {
        }

        /**
         * This is not called on the UI thread. Post a runnable to invoke
         * 这不是呼吁界面线程。发表一个运行调用
         * loadUrl on the UI thread.
         * loadUrl在UI线程。
         */

        @JavascriptInterface
        public void clickOnAndroid(final String uid) {        // 注意这里的名称。它为clickOnAndroid(),注意，注意，严重注意
//            mHandler.post(new Runnable() {
//                public void run() {
//                    // 此处调用 HTML 中的javaScript 函数
////                    mWebView.loadUrl("javascript:wave()");
////                    Toast.makeText(mContext, "1111111111 + uid = " + uid, Toast.LENGTH_SHORT).show();
//                }
//            });
        }
    }



}
