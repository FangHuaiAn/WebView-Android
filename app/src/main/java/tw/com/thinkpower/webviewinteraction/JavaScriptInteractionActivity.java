package tw.com.thinkpower.webviewinteraction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class JavaScriptInteractionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_script_interaction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        WebView webViewJavaScriptInteraction = (WebView) findViewById(R.id.webViewJavaScriptInteraction);
        webViewJavaScriptInteraction.setWebChromeClient(new WebChromeClient());
        webViewJavaScriptInteraction.addJavascriptInterface(new WebAppInterface(this), "Thinkpower");
        WebSettings webSettings = webViewJavaScriptInteraction.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webViewJavaScriptInteraction.loadData("<html><head><title>Local String</title><style type='text/css'>p{font-family : Verdana; color : purple }</style><script language='JavaScript'> function msg(){Thinkpower.showToast('Hi !');}</script></head><body><p>Hello World!</p><br /><button type='button' onclick='msg()' text='Hi'>Hi</button></body></html>", "text/html", "utf-8");
    }

}
