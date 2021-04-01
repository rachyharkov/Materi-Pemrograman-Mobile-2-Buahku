package id.slametriyadi.buahku;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WikiBuahActivity extends AppCompatActivity {

    @BindView(R.id.webBuah)
    WebView webBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_buah);
        ButterKnife.bind(this);
        setTitle("Wiki Hewan");

        //TODO 9 Fungsi untuk menuju ke link web wikipedia
        webBuah.getSettings().setJavaScriptEnabled(true);
        webBuah.setWebViewClient(new WebViewClient());
        int linkBuah = getIntent().getIntExtra("lB", 0);
        webBuah.loadUrl(getResources().getString(linkBuah));
    }
}
