package id.slametriyadi.buahku;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailBuahActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imgbuah)
    ImageView imgbuah;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.txtdetailbuah)
    TextView txtdetailbuah;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buah);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        //TODO 4 Untuk menyimpan detail buah pada DetailBuahActivity.java
        txtdetailbuah.setText(getIntent().getIntExtra("dB", 0));
        imgbuah.setImageResource(getIntent().getIntExtra("gB", 0));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getIntent().getStringExtra("nB"));
        }
    }
        //TODO 7 Fungsi untuk meng klik wikibuahactivity pada DetailBuahActivity.java
        @OnClick(R.id.fab)
        public void onViewClicked() {
            Intent wikiIntent = new Intent(this, WikiBuahActivity.class);
            wikiIntent.putExtra("lB",getIntent().getIntExtra("lB", 0));
            startActivity(wikiIntent);
        }
    }


