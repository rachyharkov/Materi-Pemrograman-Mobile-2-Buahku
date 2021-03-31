package id.slametriyadi.buahku;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BuahAdapter extends BaseAdapter {

    private String[] namaBuah;
    private int[] gambarBuah;
    private Activity act;
    private int requestCode;

    BuahAdapter(BuahActivity buahActivity, String[] namaBuah, int[] gambarBuah, int requestCode) {
        act = buahActivity;
        this.namaBuah = namaBuah;
        this.gambarBuah = gambarBuah;
        this.requestCode = requestCode;
    }

    @Override
    public int getCount() {
        //tampilkan jumlah nama buahnya
        return namaBuah.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = act.getLayoutInflater();
        if (requestCode == 1) {
            //tampilkan buah di generate butterknife dan confirm agar terbuat viewholder
            view = inflater.inflate(R.layout.tampilanbuah, null);
        } else {
            view = inflater.inflate(R.layout.tampilangridbuah, null);
        }

        //Fungsi tuk memanggil class Viewholder
        ViewHolder holder = new ViewHolder(view);
        holder.txtnamabuah.setText(namaBuah[i]);
        holder.imgbuah.setImageResource(gambarBuah[i]);
        return view;
    }
        //Menghubungkan viewchild dengan variabel pada buahadapter.java
        static
        class ViewHolder {
            @BindView(R.id.imgbuah)
            ImageView imgbuah;
            @BindView(R.id.txtnamabuah)
            TextView txtnamabuah;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
        }
    }
}
