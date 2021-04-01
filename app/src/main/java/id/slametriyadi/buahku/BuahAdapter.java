package id.slametriyadi.buahku;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
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
        //TODO 1 untuk memanggil jumlah getcount pada BuahAdapter.java
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
        //TODO 2 Tampilkan layout pada kelas lain pada public View getView
        LayoutInflater inflater = act.getLayoutInflater();
        if (requestCode == 1) {
            //TODO 3 Tampilkan buah di generate butterknife dan confirm agar terbuat viewholder
            view = inflater.inflate(R.layout.tampilanbuah, null);
        } else {
            view = inflater.inflate(R.layout.tampilangridbuah, null);
        }

        //TODO 5 Fungsi untuk memanggil class ViewHolder
        ViewHolder holder = new ViewHolder(view);
            holder.txtnamabuah.setText(namaBuah[i]);
            holder.imgbuah.setImageResource(gambarBuah[i]);
            return view;
    }

        //TODO 4 Untuk menghubungkan ViewChild dengan variable pada BuahAdapter.java:
        static class ViewHolder {
            @BindView(R.id.imgbuah)
            ImageView imgbuah;
            @BindView(R.id.txtnamabuah)
            TextView txtnamabuah;

            ViewHolder(View view) {
                ButterKnife.bind(this, view);
            }
        }
    }
