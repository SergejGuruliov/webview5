package com.example.app;

import android.content.Intent;
import android.content.res.AssetManager;
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
        System.out.println(url);
//        if (url.startsWith("https://mano.vz.lt/skins/")){
//
//            view.stopLoading();
//            view.loadUrl("file:///android_asset/skins/dashboard/images/icon/avatar-04.jpg");
//        }
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
    @Override
    public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
        Uri uri = request.getUrl();
        if (uri.getPath().startsWith("/skins/")) {
            try {
                WebResourceResponse webResourceResponse = new WebResourceResponse(
                        URLConnection.guessContentTypeFromName(uri.getPath()),
                        "utf-8",
                        view.getContext().getAssets().open(uri.getPath().substring(1)));
                return webResourceResponse;
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        return super.shouldInterceptRequest(view, request);
    }


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
