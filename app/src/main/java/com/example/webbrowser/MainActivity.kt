package com.example.webbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var mywebview: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mywebview = findViewById(R.id.mywebview)

        val eturl : EditText = findViewById(R.id.eturl)
        val imgsearch: ImageView = findViewById(R.id.imgsearch)
        val imgfacebook : ImageView = findViewById(R.id.imgfacebook)
        val imginstagram : ImageView = findViewById(R.id.imginstagram)
        val imggithub : ImageView = findViewById(R.id.imggithub)
        val imgyoutube : ImageView = findViewById(R.id.imgyoutube)

        mywebview.webViewClient = WebViewClient()

        imgsearch.setOnClickListener{
            val siteUrl:String = eturl.text.toString()

            if(URLUtil.isValidUrl(siteUrl)){
                mywebview.loadUrl(siteUrl)
            }
            else{
                mywebview.loadUrl("https://www.google.com/search?q=$siteUrl")
            }
        }
        imgfacebook.setOnClickListener{
            mywebview.loadUrl("https://www.facebook.com")
        }
        imginstagram.setOnClickListener{
            mywebview.loadUrl("https://www.instagram.com")
        }
        imggithub.setOnClickListener{
            mywebview.loadUrl("https://www.github.com")
        }
        imgyoutube.setOnClickListener{
            mywebview.loadUrl("https://www.youtube.com")
        }

        mywebview.settings.javaScriptEnabled = true

    }

    override fun onBackPressed() {
        if (mywebview.canGoBack()){
            mywebview.goBack()
        }
        else{
            super.onBackPressed()
        }
    }
}
