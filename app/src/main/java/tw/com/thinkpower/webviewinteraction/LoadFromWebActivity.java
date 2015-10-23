package tw.com.thinkpower.webviewinteraction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LoadFromWebActivity extends AppCompatActivity {

    private WebView webViewLoadFromWeb ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_from_web);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        webViewLoadFromWeb = (WebView) findViewById(R.id.webViewLoadFromWeb);
        webViewLoadFromWeb.setWebViewClient(mWebViewClient);
        WebSettings webSettings = webViewLoadFromWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewLoadFromWeb.loadUrl("http://www.google.com");
    }

    WebViewClient mWebViewClient = new WebViewClient(){

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);

            return true;
        }
    };
}
