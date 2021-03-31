package id.slametriyadi.buahku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WikiBuahActivity extends AppCompatActivity {

    @BindView(R.id.webBuah)
    WebView webBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiki_buah);
        ButterKnife.bind(this);


        //TODO 9 Fungsi untuk menuju ke link web wikipedia
        webBuah.getSettings().setJavaScriptEnabled(true);
        webBuah.setWebViewClient(new WebViewClient());
        int linkBuah = getIntent().getIntExtra("IB", 0);
        webBuah.loadUrl(getResources().getString(linkBuah));

    }
}

