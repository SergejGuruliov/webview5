package com.example.app;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import java.net.URL;
import java.net.URLConnection;

class MyWebViewClient extends WebViewClient {

    @Override
    public void onLoadResource(WebView view, String url){
        if (url.indexOf("/skins/") > 1){
            url.replace("https://mano.vz.lt/skins/", "file:///android_asset/skins/");
            System.out.println(url);

            view.stopLoading();
            view.loadUrl(url);
        }
    }

//    @Override
//    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
//        String url = request.getUrl().toString();
//        if (url.startsWith("https://mano.vz.lt/skins/")) {
//            try {
//                //change protocol of url string
//                url.replace("https://mano.vz.lt/skins/", "file:///android_asset/skins/");
//                System.out.println(url);
//                //return modified response
////                URL httpsUrl = new URL(url);
////                URLConnection connection = httpsUrl.openConnection();
////                return new WebResourceResponse(connection.getContentType(), connection.getContentEncoding(), connection.getInputStream());
//            } catch (Exception e) {
//                //an error occurred
//            }
//        }
//        return super.shouldInterceptRequest(view, request);
//    }
//
//    @Override
//    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
//        System.out.println(request.getRequestHeaders());
//
//        return null;
//    }


//    @Override
//    public boolean shouldOverrideUrlLoading(WebView view, String url) {
//
////        if (url.startsWith("/skins/")){
////            url.replace("/skins/", "file:///android_asset/skins/");
////        }
////        System.out.println(url);
////        return super.shouldOverrideUrlLoading(view, url);
//
//
////        String hostname;
////
////        // YOUR HOSTNAME
////        hostname = "mano.vz.lt";
////
////        Uri uri = Uri.parse(url);
////        if (url.startsWith("file:") || uri.getHost() != null && uri.getHost().endsWith(hostname)) {
////            return false;
////        }
////        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
////        view.getContext().startActivity(intent);
////        return true;
//    }

//    @Override
//    public void onPageFinished(WebView view, String url) {
//        Toast.makeText(view.getContext(), url, Toast.LENGTH_LONG).show();
//        System.out.println(url);
//      view.loadUrl("javascript:(function(){alert(0)})()");
//    }
}
