package android.cs2340.activity;

import android.cs2340.R;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * For your enjoyment part 2.
 * @author tiff
 *
 */
public class TetrisViewActivity extends AbstractActivityFactory {
    private WebView webView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetris_view);
        
        webView = (WebView) findViewById(R.id.webView1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://dl.dropboxusercontent.com/u/11363011/tetris/index.html");
    }
}
