package tw.com.thinkpower.webviewinteraction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class LoadLocalHtmlActivity extends AppCompatActivity {

    private WebView webViewLoadLocalHtml ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_local_html);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        webViewLoadLocalHtml = (WebView) findViewById(R.id.webViewLoadLocalHtml);
        webViewLoadLocalHtml.setWebChromeClient(new WebChromeClient());
        WebSettings webSettings = webViewLoadLocalHtml.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewLoadLocalHtml.loadData("<html><head><title>Local String</title><style type='text/css'>p{font-family : Verdana; color : purple }</style><script language='JavaScript'> function msg(){alert('Hi !');}</script></head><body><p>Hello World!</p><br /><button type='button' onclick='msg()' text='Hi'>Hi</button></body></html>", "text/html", "utf-8");
    }
}
