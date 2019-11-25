package com.jack.kotlin.javascriptefficentdemo

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.loadUrl("https://www.baidu.com")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true)
        }
        webView.webViewClient = DefaultMonitorWebViewClient {
            val data = DefaultMonitorData(it)
            Log.d("MainActivity", it)

            when (data.type) {
                "monitor_navigateTiming" -> {
                    Log.d(
                        "MainActivity",
                        "[url:${data.url}]\n" +
                                "[whiteScreenTime:${data.whiteScreenTime}]\n" +
                                "[loadTotalTime:${data.loadTotalTime}]\n"
                    )
                }
                "monitor_resourceTiming" -> {

                }
            }
        }
    }
}
