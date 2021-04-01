package id.slametriyadi.buahku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BuahActivity extends AppCompatActivity {
    String namaBuah[] = {"Kuda", "Gajah", "Kambing", "Ular", "Kucing", "Harimau"};
    int gambarBuah[] = {R.drawable.kudahitam,
            R.drawable.gajah, R.drawable.kambing,
            R.drawable.kumpulanuler, R.drawable.kucing,
            R.drawable.harimau};
    int linkBuah[] = {R.string.linkKuda,
            R.string.linkGajah, R.string.linkKambing,
            R.string.linkUler, R.string.linkKucing,
            R.string.linkHarimau};
    int detailBuah[] = {R.string.kuda,
            R.string.gajah, R.string.kambing,
            R.string.uler, R.string.kucing,
            R.string.harimau};

    @BindView(R.id.list_buah)
    ListView listBuah;
    @BindView(R.id.grid_buah)
    GridView gridBuah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buah);
        ButterKnife.bind(this);
        setTitle("Daftar Hewan");

        Intent getData = getIntent();
        int code = getData.getIntExtra("requestCode", 0);
        if (code == 1) {
            listBuah.setVisibility(View.VISIBLE);
            gridBuah.setVisibility(View.GONE);

            //TODO 1 Adapter untuk menghubungkan antara view dengan data pada class BuahActivity.java
            BuahAdapter adapter = new BuahAdapter(this, namaBuah, gambarBuah, code);

            //TODO 2 Menghubungkan adapter ke list view
            listBuah.setAdapter(adapter);

            //TODO 5 Untuk menghandel item list ketika di klik pada BuahActivity.java
            listBuah.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

        } else if (code == 2) {
            listBuah.setVisibility(View.GONE);
            gridBuah.setVisibility(View.VISIBLE);


            //TODO 3 Adapter yang digunakan untuk menghubungkan antara view dengan data:
            BuahAdapter adapter = new BuahAdapter(this, namaBuah, gambarBuah, code);

            //TODO 4 Untuk menghubungkan adapter ke grid view
            gridBuah.setAdapter(adapter);

            //TODO 1 Handle item grid ketika di klik pada BuahActivity.java
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

