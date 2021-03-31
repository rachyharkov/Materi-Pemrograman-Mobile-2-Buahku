package id.slametriyadi.buahku;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuahActivity extends AppCompatActivity {

    String namaBuah[] = {"Alpukat", "Apel", "Ceri", "Durian", "Jambu Air", "Manggis", "Strawberry"};
    int gambarBuah[] = {R.drawable.alpukat, R.drawable.apel,
            R.drawable.ceri, R.drawable.durian,
            R.drawable.jambuair, R.drawable.manggis,
            R.drawable.strawberry};
    int linkBuah[] = {R.string.linkAlpukat, R.string.linkApel,
            R.string.linkCeri, R.string.linkDurian,
            R.string.linkJambuair, R.string.linkManggis,
            R.string.linkStrawberry};
    int detailBuah[] = {R.string.alpukat, R.string.apel,
            R.string.ceri, R.string.durian,
            R.string.jambuair, R.string.manggis,
            R.string.strawberry};


    @BindView(R.id.list_buah)
    ListView listBuah;
    @BindView(R.id.grid_buah)
    GridView gridBuah;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah);
        ButterKnife.bind(this);

        Intent getData = getIntent();
        int code = getData.getIntExtra("requestCode", 0);
        if (code == 1) {
            listBuah.setVisibility(View.VISIBLE);
            gridBuah.setVisibility(View.GONE);
            // Menguhubungkan view dengan data debgab adaoter
            BuahAdapter adapter = new BuahAdapter(this, namaBuah, gambarBuah, code);

            //Menghubungkan adapter ke list view
            listBuah.setAdapter(adapter);

            // Handle item list ketika di klik
            listBuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(BuahActivity.this, DetailBuahActivity.class);
                    intent.putExtra("nB", namaBuah[i]);
                    intent.putExtra("gB",gambarBuah[i]);
                    intent.putExtra("dB", detailBuah[i]);
                    intent.putExtra("lB", linkBuah[i]);
                    startActivity(intent);
                }
            });

        } else if (code == 2) {
            listBuah.setVisibility(View.GONE);
            gridBuah.setVisibility(View.VISIBLE);

            // Adapter yang digunakan untuk menghubungkan antara view dengan adapter
            BuahAdapter adapter = new BuahAdapter(this, namaBuah, gambarBuah, code);

            //Menghubungkan adapter ke grid View
            gridBuah.setAdapter(adapter);
            //TODO 1 Handle item grid
            gridBuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(BuahActivity.this, DetailBuahActivity.class);
                    intent.putExtra("nB", namaBuah[i]);
                    intent.putExtra("gB", gambarBuah[i]);
                    intent.putExtra("dB", detailBuah[i]);
                    intent.putExtra("lB", linkBuah[i]);
                    startActivity(intent);
                }
            });
        }

    }
}