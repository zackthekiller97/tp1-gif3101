package ca.ulaval.ima.tp1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import com.example.tp1.R

class UniversiteLavalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_universite_laval)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val urlMaps = intent.getStringExtra("URL_MAPS")
        val webView = findViewById<WebView>(R.id.webViewMaps)
        val btnFermer = findViewById<Button>(R.id.btnFermer)

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        if (urlMaps != null) {
            webView.loadUrl(urlMaps)
        }

        btnFermer.setOnClickListener {
            finish()
        }
    }
}