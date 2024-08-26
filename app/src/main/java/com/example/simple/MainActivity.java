package com.example.simple;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import java.util.function.Function;

import de.robv.android.xposed.XposedBridge;

public class MainActivity extends Activity {
    public static final void setInsLikeCount(String like) {
        XposedBridge.log("setInsLikeCount: " + like);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        savedInstanceState.getString()
        setContentView(R.layout.activity_main);
        View btnOpen = findViewById(R.id.btn_open);
        btnOpen.setOnClickListener(v -> previewInsLink());
    }

    public void previewInsLink() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String link = "https://www.instagram.com/p/C-JdoqCyABQ/";
//        String link = "https://www.instagram.com/p/C-jTCvISGIg/?igsh=bW05amZuZHFsejlw";
//        String link = "https://www.instagram.com/p/C-X_C-cMNpq";
//        String link = "https://www.instagram.com/p/C-SUVCBPQCw/?utm_source=ig_web_copy_link&igsh=MzRlODBiNWFlZA==";
        intent.setData(Uri.parse(link));
        intent.setPackage("com.instagram.android");
        startActivity(intent);
    }
}